package kr.swdl.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QnAListDAO {
	private Connection conn;
	
	public QnAListDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<QnAVO> getQuestions(int start, int end) {
		List<QnAVO> list=new ArrayList<QnAVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_QUESTIONS);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnAVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getQuestionCount() {
		int cnt = 0;
		
		try(Statement stmt = conn.createStatement()) {
			
			try(ResultSet rs = stmt.executeQuery(Query.GET_QUESTION_COUNT)) {
				if(rs.next()) {
					cnt = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public List<QnAVO> getQuestionsSearchByTitle(int start, int end, String keyword) {
		List<QnAVO> list=new ArrayList<QnAVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_QUESTIONS_SEARCH_BY_TITLE);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnAVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<QnAVO> getQuestionsSearchByContent(int start, int end, String keyword) {
		List<QnAVO> list=new ArrayList<QnAVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_QUESTIONS_SEARCH_BY_CONTENT);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnAVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<QnAVO> getQuestionsSearchByTitleOrContent(int start, int end, String keyword) {
		List<QnAVO> list=new ArrayList<QnAVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_QUESTIONS_SEARCH_BY_TITLE_OR_CONTENT);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnAVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<QnAVO> getQuestionsSearchByNickname(int start, int end, String keyword) {
		List<QnAVO> list=new ArrayList<QnAVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_QUESTIONS_SEARCH_BY_NICKNAME);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnAVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getQuestionsCountSearchByKeyword(String searchSelect, String keyword) {
		int cnt = -1;
		String sql = null;
		
		switch(searchSelect) {
		case "title":
			sql = Query.GET_QUESTION_COUNT_SEARCH_BY_TITLE;
			break;
		case "author":
			sql = Query.GET_QUESTION_COUNT_SEARCH_BY_NICKNAME;
			break;
		case "content":
			sql = Query.GET_QUESTION_COUNT_SEARCH_BY_CONTENT;
			break;
		case "titleContent":
			sql = Query.GET_QUESTION_COUNT_SEARCH_BY_TITLE_OR_CONTENT;
			break;
		}
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, keyword);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					cnt = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
}

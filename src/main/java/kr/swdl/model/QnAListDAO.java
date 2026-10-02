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
	
	public List<QnAVO> getQuestionsSearchByTitle(int start, int end, String title) {
		List<QnAVO> list=new ArrayList<QnAVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_QUESTIONS);
			pstmt.setString(1, title);
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
	public List<QnAVO> getQuestionSearchByContent(int start, int end, String content) {
		List<QnAVO> list=new ArrayList<QnAVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_QUESTIONS);
			pstmt.setString(1, content);
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
	
	public List<QnAVO> getQuestionSearchByTitleOrContent(int start, int end, String title, String content) {
		List<QnAVO> list=new ArrayList<QnAVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_QUESTIONS);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
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
	
	public List<QnAVO> getQuestionSearchByNickname(int start, int end, String nickname) {
		return null;
	}
}

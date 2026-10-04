package kr.swdl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QnADAO {
	private Connection conn;

	// service 만들기 전에 임시코드...
	public QnADAO() throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.OracleDriver";
		Class.forName(driver);
		System.out.println("1 driver loading ok");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		conn = DriverManager.getConnection(url, "hr", "hr");
		System.out.println("2 DBMS 연결 OK");
	}

	public QnAVO getQnA(String questionNumber) {
		QnAVO result = null;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(Query.GET_QNA);
			pstmt.setString(1, questionNumber);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new QnAVO(rs.getString("question_number"), rs.getString("member_number"),
						rs.getString("statement"), rs.getString("title"), rs.getString("nickname"),
						rs.getString("write_date"), rs.getInt("view_count"), rs.getString("content"),
						rs.getInt("answer_count"), null);
				pstmt.close();
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean addQnA(String memberNumber, String title, String content) {
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.ADD_QNA);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, memberNumber);
			result = pstmt.executeUpdate() == 1;
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean setQnA(String questionNumber, String title, String content) { // title, content 추가...
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.ADD_QNA);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(1, questionNumber);
			result = pstmt.executeUpdate() == 1;
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean deleteQnA(String questionNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.DELETE_QNA);
			pstmt.setString(1, questionNumber);
			result = pstmt.executeUpdate() == 1;
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<AnswerVO> getAnswer(String questionNumber) {
		List<AnswerVO> list = new ArrayList<AnswerVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_ANSWER);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new AnswerVO(rs.getString("memberNumber"), rs.getString("m.nickname"),rs.getString("write_date"),rs.getString("contents"),rs.getString("answerNumber"),rs.getInt("select_state") == 1));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean addAnswer(String memberNumber, String questionNumber, String content) {// questionNumber 추가...
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.ADD_ANSWER);
			pstmt.setString(1, content);
			pstmt.setString(2, questionNumber);
			pstmt.setString(3, memberNumber);
			result = pstmt.executeUpdate() == 1;
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	//////////////////////////////////////////////////////////////

	public boolean setAnswer(String answerNumber) {
		return false;
	}

	public boolean deleteAnswer(String answerNumber) {
		return false;
	}

	public boolean setSelectState(String answerNumber) {
		return false;
	}

	public boolean setQnAView(String questionNumber) {
		return false;
	}

	public boolean isQnAView(String memberNumber, String questionNumber) {
		return false;
	}

	public boolean addQnAView(String memberNumber, String questionNumber) {
		return false;
	}

}

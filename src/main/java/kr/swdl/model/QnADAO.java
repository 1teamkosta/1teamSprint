package kr.swdl.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QnADAO {
	private Connection conn;
	public QnADAO(Connection conn) {  //service
		this.conn=conn;
	}
	
	public QnAVO getQnA(String questionNumber) {
		return null;
	}
	
	public boolean addQnA(String memberNumber, String title, String content) {
		return false;
	}
	
	public boolean setQnA(String questionNumber) {
		return false;
	}
	
	public boolean deleteQnA(String questionNumber) {
		return false;
	}
	
	public List<AnswerVO> getAnswer(String questionNumber){
		return null;
	}
	
	public boolean addAnswer(String memberNumber, String content) {
		return false;
	}
	
	
	public boolean setAnswer(String answerNumber,String content) {
		boolean result = false;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.SET_ANSWER);
			pstmt.setString(2, answerNumber);
			pstmt.setString(1, content);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteAnswer(String answerNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.DELETE_ANSWER);
			pstmt.setString(1, answerNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean setQuestionStatement (String questionNumber) {
		boolean result =false;
		try {
			PreparedStatement pstmt= conn.prepareStatement(Query.SET_QUESTION_STATEMENT);
			pstmt.setString(1, questionNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
}
	//답변 상태 추가
	public boolean setAnswerStatement (String answerNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(Query.SET_ANSWER_STATEMENT);
			pstmt.setString(1, answerNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//조회 테이블에 회원과 글번호 추가 
	public boolean setQnAView (String memberNumber,String questionNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(Query.SET_QNA_VIEW);
			pstmt.setString(1, memberNumber);
			pstmt.setString(2, questionNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//중복조회 확인 
	public boolean isQnAView(String memberNumber, String questionNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.IS_QNA_VIEW);
		
			
			pstmt.setString(1,memberNumber);
			pstmt.setString(2, questionNumber);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) 
				result = (rs.getInt(1) == 1);
			rs.close();
			pstmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	//조회수 중가 
	public boolean addQnAView(String questionNumber) {
		boolean result =false;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.ADD_QNA_VIEW);
			pstmt.setString(1, questionNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}

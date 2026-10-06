package kr.swdl.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class QnAService {
	
	  private Connection conn;
	
	   public QnAService(Connection conn) {
	        this.conn = conn;
	    }

	public QnAVO getQnA(String questionNumber) {
		try {
			return new QnADAO(conn).getQnA(questionNumber);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addQnA(String memberNumber, String title, String content) {

		try {
			return new QnADAO(conn).addQnA(memberNumber, title, content);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean setQnA(String questionNumber, String title, String content) { // title, content 추가...
		try {
			return new QnADAO(conn).setQnA(questionNumber, title, content);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean deleteQnA(String questionNumber) {
		try {
			return new QnADAO(conn).deleteQnA(questionNumber);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	//추후 AnswerService로 분리 필요 
	public List<AnswerVO> getAnswer(String questionNumber) {
		try {
			return new QnADAO(conn).getAnswer(questionNumber);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean addAnswer(String memberNumber, String questionNumber, String content) {// questionNumber 추가...
		try {
			return new QnADAO(conn).addAnswer(memberNumber, questionNumber, content);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

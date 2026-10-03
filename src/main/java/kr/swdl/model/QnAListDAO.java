package kr.swdl.model;

import java.sql.Connection;
import java.util.List;

public class QnAListDAO {
//	private Connection conn;
//	
//	public QuestionListDAO(Connection conn) {
//		this.conn = conn;
//	}
	
	public List<QnADAO> getQuestions(int start, int end) {
		return null;
	}
	
	public List<QnADAO> getQuestionsSearchByTitle(int start, int end, String keyword) {
		return null;
	}
	
	public List<QnADAO> getQuestionSearchByContent(int start, int end, String keyword) {
		return null;
	}
	
	public List<QnADAO> getQuestionSearchByTitleOrContent(int start, int end, String keyword) {
		return null;
	}
	
	public List<QnADAO> getQuestionSearchByNickname(int start, int end, String keyword) {
		return null;
	}
}

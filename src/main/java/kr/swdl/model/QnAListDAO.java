package kr.swdl.model;

import java.sql.Connection;
import java.util.List;

public class QnAListDAO {
//	private Connection conn;
//	
//	public QuestionListDAO(Connection conn) {
//		this.conn = conn;
//	}
	
	public List<QnADAO> getQuestions(int page, int pageSize) {
		return null;
	}
	
	public List<QnADAO> getQuestionsSearchByTitle(int page, int pageSize, String keyword) {
		return null;
	}
	
	public List<QnADAO> getQuestionSearchByContent(int page, int pageSize, String keyword) {
		return null;
	}
	
	public List<QnADAO> getQuestionSearchByTitleOrContent(int page, int pageSize, String keyword) {
		return null;
	}
	
	public List<QnADAO> getQuestionSearchByNickname(int page, int pageSize, String keyword) {
		return null;
	}
}

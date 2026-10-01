package kr.swdl.model;

import java.sql.Connection;
import java.util.List;

public class QnAListDAO {
//	private Connection conn;
//	
//	public QuestionListDAO(Connection conn) {
//		this.conn = conn;
//	}
	
	public List<QnADetailDAO> getQuestions(int page, int pageSize) {
		return null;
	}
	
	public List<QnADetailDAO> getQuestionsSearchByTitle(int page, int pageSize, String keyword) {
		return null;
	}
	
	public List<QnADetailDAO> getQuestionSearchByContent(int page, int pageSize, String keyword) {
		return null;
	}
	
	public List<QnADetailDAO> getQuestionSearchByTitleOrContent(int page, int pageSize, String keyword) {
		return null;
	}
	
	public List<QnADetailDAO> getQuestionSearchByNickname(int page, int pageSize, String keyword) {
		return null;
	}
}

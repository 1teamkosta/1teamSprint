package kr.swdl.model;

import java.sql.Connection;
import java.util.List;

public class QnAListDAO {
	private Connection conn;
	
	public QnAListDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<QnAVO> getQuestions(int start, int end) {
		return null;
	}
	
	public List<QnAVO> getQuestionsSearchByTitle(int start, int end, String keyword) {
		return null;
	}
	
	public List<QnAVO> getQuestionSearchByContent(int start, int end, String keyword) {
		return null;
	}
	
	public List<QnAVO> getQuestionSearchByTitleOrContent(int start, int end, String keyword) {
		return null;
	}
	
	public List<QnAVO> getQuestionSearchByNickname(int start, int end, String keyword) {
		return null;
	}
}

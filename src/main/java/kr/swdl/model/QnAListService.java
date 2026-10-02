package kr.swdl.model;

import java.sql.SQLException;
import java.util.List;

public class QnAListService {
	public List<QnAVO> getQuestions(){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestions(1, 10);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QnAVO> getQuestionsSearchByTitle(String title){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByTitle(1, 10, title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QnAVO> getQuestionsSearchByContent(String content){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByTitle(1, 10, content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}

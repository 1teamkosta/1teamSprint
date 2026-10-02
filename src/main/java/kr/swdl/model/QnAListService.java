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
	public List<QnAVO> getQuestionsSearchByTitle(String keyword){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByTitle(1, 10, keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QnAVO> getQuestionsSearchByContent(String keyword){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByContent(1, 10, keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QnAVO> getQuestionsSearchByTitleOrContent(String keyword){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByTitleOrContent(1, 10, keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QnAVO> getQuestionsSearchByNickname(String keyword){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByNickname(1, 10, keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

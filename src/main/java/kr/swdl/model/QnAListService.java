package kr.swdl.model;

import java.sql.SQLException;
import java.util.List;

public class QnAListService {
	private int getStart(int page) {
		return page*Common.PAGESIZE-(Common.PAGESIZE-1);
	}
	private int getEnd(int page) {
		return page*Common.PAGESIZE;
	}
	public int getQuestionCount() {
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public List<QnAVO> getQuestions(int page){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestions(getStart(page), getEnd(page));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QnAVO> getQuestionsSearchByTitle(int page, String keyword){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByTitle(getStart(page), getEnd(page), keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QnAVO> getQuestionsSearchByContent(int page, String keyword){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByContent(getStart(page), getEnd(page), keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QnAVO> getQuestionsSearchByTitleOrContent(int page, String keyword){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByTitleOrContent(getStart(page), getEnd(page), keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<QnAVO> getQuestionsSearchByNickname(int page, String keyword){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestionsSearchByNickname(getStart(page), getEnd(page), keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

package kr.swdl.model;

import java.util.List;

public class QnADAO {
	
	public QnAVO getQnAPost(String questionNumber) {
		return null;
	}
	
	public boolean addQnAPost(String memberNumber, String title, String content) {
		return false;
	}
	
	public boolean updateQnAPost(String questionNumber) {
		return false;
	}
	
	public boolean deleteQnAPost(String questionNumber) {
		return false;
	}
	
	public List<AnswerVO> getAnswerPost(String questionNumber){
		return null;
	}
	
	public boolean addAnswer(String memberNumber, String content) {
		return false;
	}
	
	public boolean updateAnswer(String answerNumber) {
		return false;
	}
	
	public boolean deleteAnswer(String answerNumber) {
		return false;
	}
	
	public boolean setSelectState (String answerNumber) {
		return false;
	}
	
	public boolean updateQnAView (String questionNumber) {
		return false;
	}
	
	public boolean isQnAView(String memberNumber, String questionNumber) {
		return false;
	}
	
	public boolean addQnAView(String memberNumber, String questionNumber) {
		return false;
	}
	
	
}

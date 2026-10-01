package kr.swdl.model;

public class QnADetailDAO {
	public QnADetailVO getQnAPost(String questionNumber) {
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

package kr.swdl.model;

import java.util.List;

public class QnADAO {
	
	public QnAVO getQnA(String questionNumber) {
		return null;
	}
	
	public boolean addQnA(String memberNumber, String title, String content) {
		return false;
	}
	
	public boolean setQnA(String questionNumber) {
		return false;
	}
	
	public boolean deleteQnA(String questionNumber) {
		return false;
	}
	
	public List<AnswerVO> getAnswer(String questionNumber){
		return null;
	}
	
	public boolean addAnswer(String memberNumber, String content) {
		return false;
	}
	
	public boolean setAnswer(String answerNumber) {
		return false;
	}
	
	public boolean deleteAnswer(String answerNumber) {
		return false;
	}
	
	public boolean setSelectState (String answerNumber) {
		return false;
	}
	
	public boolean setQnAView (String questionNumber) {
		return false;
	}
	
	public boolean isQnAView(String memberNumber, String questionNumber) {
		return false;
	}
	
	public boolean addQnAView(String memberNumber, String questionNumber) {
		return false;
	}
	
	
}

package kr.swdl.model;

public class AnswerVO extends CommentVO{
	private String answerNumber;
	private boolean selectState;
	
	public AnswerVO(String memberNumber, String nickname, String writeDate, String content, String answerNumber,
			boolean selectState) {
		super(memberNumber, nickname, writeDate, content);
		setAnswerNumber(answerNumber);
		setSelectState(selectState);
	}
	
	public String getAnswerNumber() {
		return answerNumber;
	}
	public void setAnswerNumber(String answerNumber) {
		this.answerNumber = answerNumber;
	}
	public boolean isSelectState() {
		return selectState;
	}
	public void setSelectState(boolean selectState) {
		this.selectState = selectState;
	}
	@Override
	public String toString() {
		return "AnswerVO [answerNumber=" + answerNumber + super.toString() + ", selectState=" + selectState + "]";
	}
	
	
}

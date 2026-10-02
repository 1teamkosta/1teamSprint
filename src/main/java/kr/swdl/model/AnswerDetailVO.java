package kr.swdl.model;

public class AnswerDetailVO {
	private String answerNumber;
	private String memberNumber;
	private String nickname;
	private String writeDate;
	private boolean selectState;
	//test
	public AnswerDetailVO(String answerNumber, String memberNuber, String nickname, String writeDate, boolean selectState) {
		setAnswerNumber(answerNumber);
		setMemberNumber(memberNuber);
		setNickname(nickname);
		setWriteDate(writeDate);
		setSelectState(selectState);
	}
	
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getAnswerNumber() {
		return answerNumber;
	}
	public void setAnswerNumber(String answerNumber) {
		this.answerNumber = answerNumber;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public boolean isSelectState() {
		return selectState;
	}
	public void setSelectState(boolean selectState) {
		this.selectState = selectState;
	}
	@Override
	public String toString() {
		return "AnswerDetailVO [answerNumber=" + answerNumber + ", nickname=" + nickname + ", writeDate=" + writeDate
				+ ", selectState=" + selectState + "]";
	}
	
}

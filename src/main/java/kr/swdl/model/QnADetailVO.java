package kr.swdl.model;

import java.util.List;

public class QnADetailVO {
	private String questionNumber;
	private String statement;
	private String memberNumber;
	private String title;
	private String nickname;
	private String writeDate;
	private int viewCount;
	private String Content;
	private int answerCount;
	private List<AnswerDetailVO> answer;
	
	
	public QnADetailVO(String qnum, String state, String title, String nick, String date, int viewCnt, int answCnt) {
		this(qnum, null, title, nick, date, viewCnt, null, answCnt, null);
	}
	public QnADetailVO(String questionNumber, String memberNumber, String title, String nickname, String writeDate, int viewCount, String content,
			int answerCount, List<AnswerDetailVO> answer) {
		setQuestionNumber(questionNumber);
		setMemberNumber(memberNumber);
		setTitle(title);
		setNickname(nickname);
		setWriteDate(writeDate);
		setViewCount(viewCount);
		setContent(content);
		setAnswerCount(answerCount);
		setAnswer(answer);
	}
	
	public String getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(String questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public List<AnswerDetailVO> getAnswer() {
		return answer;
	}
	public void setAnswer(List<AnswerDetailVO> answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "QnADetailVO [title=" + title + ", nickname=" + nickname + ", writeDate=" + writeDate
				+ ", viewCount=" + viewCount + ", Content=" + Content + ", answerCount=" + answerCount + "]";
	}
	
	
}

package kr.swdl.model;

import java.util.List;

public class QnAVO {
	private String questionNumber;
	private String statement;
	private String memberNumber;
	private String title;
	private String nickname;
	private String writeDate;
	private int viewCount;
	private String content;
	private int answerCount;
	private List<AnswerVO> answer;
	
	
	public QnAVO(String questionNumber, String statement, String title, String nickname, String date, int viewCount, int answerCount) {
		this(questionNumber, null, statement, title, nickname, date, viewCount, null, answerCount, null);
	}
	public QnAVO(String questionNumber, String memberNumber, String statement, String title, String nickname, String writeDate, int viewCount, String content,
			int answerCount, List<AnswerVO> answer) {
		setQuestionNumber(questionNumber);
		setMemberNumber(memberNumber);
		setTitle(title);
		setNickname(nickname);
		setWriteDate(writeDate);
		setViewCount(viewCount);
		setContent(content);
		setAnswerCount(answerCount);
		setAnswer(answer);
		setStatement(statement);
	}
	
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
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
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public List<AnswerVO> getAnswer() {
		return answer;
	}
	public void setAnswer(List<AnswerVO> answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "QnAVO [questionNumber=" + questionNumber + ", statement=" + statement + ", memberNumber=" + memberNumber
				+ ", title=" + title + ", nickname=" + nickname + ", writeDate=" + writeDate + ", viewCount="
				+ viewCount + ", content=" + content + ", answerCount=" + answerCount + ", answer=" + answer + "]";
	}
	
}

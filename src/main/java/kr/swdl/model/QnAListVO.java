package kr.swdl.model;

import java.util.List;

public class QnAListVO {
	private String questionNumber;
	private String statement;
	private String title;
	private String nickname;
	private String writeDate;
	private int viewCount;
	private int answerCount;
	
	
	private List<QnADetailVO> detailVO;

	public QnAListVO(String statement, String title, String nickname, String writeDate, int viewCount,
			int answerCount) {
		setStatement(statement);
		setTitle(title);
		setNickname(nickname);
		setWriteDate(writeDate);
		setViewCount(viewCount);
		setAnswerCount(answerCount);
	}
	
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
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
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	@Override
	public String toString() {
		return "QuestionDetailVO [statement=" + statement + ", title=" + title + ", nickname=" + nickname
				+ ", writeDate=" + writeDate + ", viewCount=" + viewCount + ", answerCount=" + answerCount + "]";
	}
}

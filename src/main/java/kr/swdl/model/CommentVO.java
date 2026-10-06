package kr.swdl.model;

public class CommentVO {
	private String memberNumber;
	private String nickname;
	private String writeDate;
	private String content;
	
	public CommentVO(String memberNumber, String nickname, String writeDate, String content) {
		setMemberNumber(memberNumber);
		setNickname(nickname);
		setWriteDate(writeDate);
		setContent(content);
	}
	
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "memberNumber=" + memberNumber + ", nickname=" + nickname + ", writeDate=" + writeDate
				+ ", content=" + content;
	}
	
	
}

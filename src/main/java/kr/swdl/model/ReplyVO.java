package kr.swdl.model;

public class ReplyVO extends CommentVO{
	private String replyNumber;
	
	public ReplyVO(String memberNumber, String nickname, String writeDate, String content, String replyNumber) {
		super(memberNumber, nickname, writeDate, content);
		setReplyNumber(replyNumber);
	}

	public String getReplyNumber() {
		return replyNumber;
	}

	public void setReplyNumber(String replyNumber) {
		this.replyNumber = replyNumber;
	}

	@Override
	public String toString() {
		return "ReplyDetailVO [replyNumber=" + replyNumber + super.toString() + "]";
	}
}

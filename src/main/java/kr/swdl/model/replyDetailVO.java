package kr.swdl.model;

public class replyDetailVO {
	private String replyNumber;
	private String memberNumber;
	private String content;
	private String writeDate;
	private String tradeNumber;
	
	public replyDetailVO(String replyNumber, String memberNumber, String content, String writeDate,
			String tradeNumber) {
		setReplyNumber(replyNumber);
		setMemberNumber(memberNumber);
		setContent(content);
		setWriteDate(writeDate);
		setTradeNumber(tradeNumber);
	}
	
	public String getReplyNumber() {
		return replyNumber;
	}
	public void setReplyNumber(String replyNumber) {
		this.replyNumber = replyNumber;
	}
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	@Override
	public String toString() {
		return "replyDetailVO [replyNumber=" + replyNumber + ", memberNumber=" + memberNumber + ", content=" + content
				+ ", writeDate=" + writeDate + ", tradeNumber=" + tradeNumber + "]";
	}
	
	
	
	

}

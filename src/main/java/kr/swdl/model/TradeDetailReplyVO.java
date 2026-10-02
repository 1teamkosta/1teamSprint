package kr.swdl.model;

public class TradeDetailReplyVO {
	private String replyNumber;
	//tradeNumber 가져올 필요가 있나 애매
	private String tradeNumber;
	private String memberNumber;
	private String replyNickname;
	private String replyContent;
	private String replyWriteDate;
	
	public TradeDetailReplyVO(String replyNumber, String tradeNumber, String memberNumber, String replyNickname,
			String replyContent, String replyWriteDate) {
		super();
		setReplyNumber(replyNumber);
		setTradeNumber(tradeNumber);
		setMemberNumber(memberNumber);
		setReplyNickname(replyNickname);
		setReplyContent(replyContent);
		setReplyWriteDate(replyWriteDate);
	}
	
	public String getReplyNumber() {
		return replyNumber;
	}
	public void setReplyNumber(String replyNumber) {
		this.replyNumber = replyNumber;
	}
	public String getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getReplyNickname() {
		return replyNickname;
	}
	public void setReplyNickname(String replyNickname) {
		this.replyNickname = replyNickname;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriteDate() {
		return replyWriteDate;
	}
	public void setReplyWriteDate(String replyWriteDate) {
		this.replyWriteDate = replyWriteDate;
	}
	
	@Override
	public String toString() {
		return "TradeDetailReplyVO [replyNumber=" + replyNumber + ", tradeNumber=" + tradeNumber + ", memberNumber="
				+ memberNumber + ", replyNickname=" + replyNickname + ", replyContent=" + replyContent
				+ ", replyWriteDate=" + replyWriteDate + "]";
	}	
	
}

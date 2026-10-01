package kr.swdl.model;

import java.util.List;

public class TradeDetailVO {
	private String tradeNumber;
	private String memberNumber;
	private String nickName;
	private String title;
	private String content;
	private int price;
	private String writeDate;
	private String viewCount;
	private List<replyDetailVO> reply;
	
	public TradeDetailVO(String tradeNumber, String memberNumber, String nickName, String title, String content,
			int price, String writeDate, String viewCount, List<replyDetailVO> reply) {
	setTradeNumber(tradeNumber);
	setMemberNumber(memberNumber);
	setNickName(nickName);
	setTitle(title);
	setContent(content);
	setPrice(price);
	setWriteDate(writeDate);
	setViewCount(viewCount);
	setReply(reply);

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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	
	public List<replyDetailVO> getReply() {
		return reply;
	}
	public void setReply(List<replyDetailVO> reply) {
		this.reply = reply;
	}
	@Override
	public String toString() {
		return "TradeDetailVO [tradeNumber=" + tradeNumber + ", memberNumber=" + memberNumber + ", nickName=" + nickName
				+ ", title=" + title + ", content=" + content + ", price=" + price + ", writeDate=" + writeDate
				+ ", viewCount=" + viewCount + ", reply=" + reply + "]";
	}
	
	
	
	

}

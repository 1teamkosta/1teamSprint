package kr.swdl.model;

import java.util.List;

public class TradeVO {
	private String tradeNumber;
	private String memberNumber;
	private String title;
	private String writeDate;
	private String nickName;
	private int viewCount;
	private String mainImage;
	private int price;
	private String content;
	private int replyCount;
	private List<ReplyVO> reply;
	
	public TradeVO(String tradeNumber, String mainImage, String title, String nickname, String writeDate, int viewCount, int price) {
		this(tradeNumber, null, mainImage, title, nickname, writeDate, viewCount, price, null, 0, null);
	}
	public TradeVO(String tradeNumber, String memberNumber, String mainImage, String title, String nickname, String writeDate,
			int viewCount, int price, String content, int replyCount, List<ReplyVO> reply) {
		setTradeNumber(tradeNumber);
		setMemberNumber(memberNumber);
		setTitle(title);
		setWriteDate(writeDate);
		setNickName(nickname);
		setViewCount(viewCount);
		setPrice(price);
		setContent(content);
		setReplyCount(replyCount);
		setReply(reply);
	}
	
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public List<ReplyVO> getReply() {
		return reply;
	}
	public void setReply(List<ReplyVO> reply) {
		this.reply = reply;
	}
	
	@Override
	public String toString() {
		return "TradeVO [tradeNumber=" + tradeNumber + ", memberNumber=" + memberNumber + ", title=" + title
				+ ", writeDate=" + writeDate + ", nickName=" + nickName + ", viewCount=" + viewCount + ", mainImage="
				+ mainImage + ", price=" + price + ", content=" + content + ", replyCount=" + replyCount + ", reply="
				+ reply + "]";
	}
	
}

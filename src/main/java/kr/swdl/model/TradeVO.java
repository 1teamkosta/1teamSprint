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
	private List<TradeDetailReplyVO> reply;
	
	public TradeVO(String tradeNumber, String memberNumber, int viewCount, String title, String mainImage, int price, String nickname, String writeDate) {
		this(tradeNumber, null, title, writeDate, nickname, viewCount, mainImage, price, null, 0, null);
	}
	public TradeVO(String tradeNumber, String memberNumber, String title, String writeDate, String nickName,
			int viewCount, String mainImage, int price, String content, int replyCount, List<TradeDetailReplyVO> reply) {
		super();
		setTradeNumber(tradeNumber);
		setMemberNumber(memberNumber);
		setTitle(title);
		setWriteDate(writeDate);
		setNickName(nickName);
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
	public List<TradeDetailReplyVO> getReply() {
		return reply;
	}
	public void setReply(List<TradeDetailReplyVO> reply) {
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

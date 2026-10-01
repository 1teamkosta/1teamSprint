package kr.swdl.model;

public class TradeListVO {
	private String tradeNumber;
	private String mainImage;
	private String title;
	private int price;
	private String content;
	private String writeDate;
	private int viewCount;
	private String nickName;	
	
	public TradeListVO(String tradeNumber, String mainImage, String title, int price, String content, String writeDate,
			int viewCount, String nickName) {
		setTradeNumber(tradeNumber);
		setMainImage(mainImage);
		setTitle(title);
		setPrice(price);
		setContent(content);
		setWriteDate(writeDate);
		setViewCount(viewCount);
		setNickName(nickName);
	}
	
	public String getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "TradeListVO [tradeNumber=" + tradeNumber + ", mainImage=" + mainImage + ", title=" + title + ", price="
				+ price + ", content=" + content + ", writeDate=" + writeDate + ", viewCount=" + viewCount
				+ ", nickName=" + nickName + "]";
	}
	
	
	
	

}

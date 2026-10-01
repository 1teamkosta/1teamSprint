package kr.swdl.model;

public class TradeDetailDAO {
	public  TradeDetailVO getTradePost(String tradeNumber) {
		return null;
	}
	public boolean addTradePost(String memberNumber, String title, String content, int price)
	{
		return false;	
	}
	public boolean updateTradePost(String tradeNumber) {
		return false;
	}
	public boolean deleteTradePost(String tradeNumber)
	{
		return false;
	}
	public boolean addReply(String memberNumber, String content) {
		return false;
	}
	public boolean updateReply(String replyNumber) {
		return false;
	}

	public boolean deleteReply(String replyNumber) {
		return false;
	}

	public boolean updateTradeView (String tradeNumber) {
		return false;
	}

	public boolean isTradeView(String memberNumber, String tradeNumber) {
		return false;
	}

	public boolean addTradeView(String memberNumber, String tradeNumber) {
		return false;
	}





}

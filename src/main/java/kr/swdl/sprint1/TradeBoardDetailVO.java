package kr.swdl.sprint1;

import java.util.List;

public class TradeBoardDetailVO {
	private String tradeNumber;
	private String memberNumber;
	private String title;
	private String writeDate;
	private String nickName;
	private int viewCount;
	private int price;
	private String content;
	private int replyCount;
	private List<TradeBoardDetailReplyVO> reply;
}
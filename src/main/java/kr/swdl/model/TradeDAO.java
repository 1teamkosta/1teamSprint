package kr.swdl.model;

import java.util.List;

public class TradeDAO {
	
	//조회수 중복처리
	public boolean isTradeView(String tradeNumber, String memberNumber) {
		return false;
	}
	//조회수 증가
	public boolean setTradeViewCount(String tradeNumber) {
		return false;
	}
	//뷰테이블 추가
	public boolean addTradeView(String tradeNumber, String memberNumber) {
		return false;
	}
	//게시글 상세 조회
	public TradeVO getTrade(String tradeNumber){
		return null;
	}
	
	//게시글 댓글 조회
	public List<ReplyVO> getTradeReply(String tradeNumber){
		return null;
	}
	
	//게시글 댓글 수 조회
	public int getTradeReplyCount(String tradeNumber) {
		return 0;
	}
	
	//게시글 등록
	public boolean addTrade(String memberNumber, String mainImage,String title,int price,String content) {
		return false;
	}
	
	//게시글 삭제
	public boolean deleteTrade(String tradeNumber) {
		return false;
	}
	//게시글 수정
	public boolean setTrade(String tradeNumber, String mainImage,String title,int price,String content) {
		return false;
	}
	//댓글 등록
	public boolean addTradeReply(String replyNumber, String content) {
		return false;
	}
	//댓글 수정
	public boolean setTradeReply(String replyNumber, String content) {
		return false;
	}
	//댓글 삭제
	public boolean deleteTradeReply(String replyNumber) {
		return false;
	}
}

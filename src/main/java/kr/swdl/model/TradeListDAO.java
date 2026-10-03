package kr.swdl.model;

import java.util.List;

public class TradeListDAO {
	
	//거래게시판 목록 조회
	public List<TradeVO> getTrades(int page, int pagesize) {
		return null;
	}
	//거래게시판 제목 검색
	public List<TradeVO> getTradesSearchByTitle(int start, int end, String title){
		return null;
	}
	
	//거래게시판 내용 검색
	public List<TradeVO> getTradesSearchByContent(int start, int end,String content){
		return null;
	}
	
	//거래게시판 제목+내용 검색
	public List<TradeVO> getTradesSearchByTitleOrContent(int start, int end,String title, String content){
		return null;
	}
	
	//거래게시판 작성자 검색
	public List<TradeVO> getTradesSearchByNickname(int start, int end, String nickname){
		return null;
	}
	
}

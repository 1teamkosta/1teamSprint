package kr.swdl.sprint1;

import java.util.List;

public class TradeBoardDAO {
	//거래게시판 목록 조회
	public List<TradeBoardListVO> getTradeBoardList() {
		return null;
	}
	//거래게시판 목록 검색
	public List<TradeBoardListVO> getSearchTradeBoardList(String title){
		return null;
	}
	//거래글 작성
	public boolean addTradeBoard(String mainImage,String title,int price,String content) {
		return false;
	}
	//조회수 중복처리
	public boolean isTradeViewTable() {
		return false;
	}
	//조회수 증가
	public boolean setTradeBoardViewCount() {
		return false;
	}
	//뷰테이플 추가
	public boolean addTradeViewTable() {
		return false;
	}
	//게시글 상세 조회
	public TradeBoardDetailVO getTradeBoardDetail(){
		return null;
	}
	//게시글 댓글 조회
	public List<TradeBoardDetailReplyVO> getTradeBoardDetailReply(){
		return null;
	}
	//게시글 삭제
	public boolean delTradeBoard() {
		return false;
	}
	//게시글 수정
	public boolean setTradeBoard(String mainImage,String title,int price,String content) {
		return false;
	}
	//댓글 등록
	public boolean addTradeBoardReply(String content) {
		return false;
	}
	//댓글 수정
	public boolean setTradeBoardReply(String content) {
		return false;
	}
	//댓글 삭제
	public boolean delTradeBoardReply() {
		return false;
	}
}

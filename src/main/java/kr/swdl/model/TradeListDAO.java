package kr.swdl.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TradeListDAO {
	
	private Connection conn;
	
	public TradeListDAO(Connection conn) {
		this.conn = conn;
	}
	
	//거래게시판 목록 조회
	public List<TradeVO> getTrades(int start, int end) {
		List<TradeVO> list = new ArrayList<TradeVO>();
		
		try {
		PreparedStatement pstmt = conn.prepareStatement(Query.GET_TRADELIST);
		ResultSet rs = pstmt.executeQuery();
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		while(rs.next()) {
//			list.add(new TradeVO(rs.get))
		}
		rs.close();
		pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//거래게시판 제목 검색
	public List<TradeVO> getTradesSearchByTitle(int start, int end, String title){
		return null;
	}
	
	//거래게시판 내용 검색
	public List<TradeVO> getTradesSearchByContent(int start, int end, String content){
		return null;
	}
	
	//거래게시판 제목+내용 검색
	public List<TradeVO> getTradesSearchByTitleOrContent(int start, int end, String title, String content){
		return null;
	}
	
	//거래게시판 작성자 검색
	public List<TradeVO> getTradesSearchByNickname(int start, int end, String nickname){
		return null;
	}
	
}

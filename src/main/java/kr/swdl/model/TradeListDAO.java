package kr.swdl.model;

import java.util.List;

public class TradeListDAO {
	
	//거래게시판 목록 조회
	public List<TradeVO> getTrades(int start, int end) {
		List<TradeVO> list = new ArrayList<TradeVO>();
		
		try {
		PreparedStatement pstmt = conn.prepareStatement(Query.GET_TRADELIST);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			list.add(new TradeVO(rs.getString("trade_number"), rs.getString("main_image"), rs.getString("title"), rs.getString("nickname"), rs.getString("write_date"), rs.getInt("view_count"), rs.getInt("price")));
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
		List<TradeVO> list = new ArrayList<TradeVO>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_TRADES_SEARCH_TITLE);
			pstmt.setString(1, title);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new TradeVO(rs.getString("trade_number"), rs.getString("main_image"), rs.getString("title"), rs.getString("nickname"), rs.getString("write_date"), rs.getInt("view_count"), rs.getInt("price")));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//거래게시판 내용 검색
	public List<TradeVO> getTradesSearchByContent(int start, int end, String content){
		List<TradeVO> list = new ArrayList<TradeVO>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_TRADES_SEARCH_TITLE);
			pstmt.setString(1, content);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new TradeVO(rs.getString("trade_number"), rs.getString("main_image"), rs.getString("title"), rs.getString("nickname"), rs.getString("write_date"), rs.getInt("view_count"), rs.getInt("price")));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//거래게시판 제목+내용 검색
	public List<TradeVO> getTradesSearchByTitleOrContent(int start, int end, String keyword){
		List<TradeVO> list = new ArrayList<TradeVO>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_TRADES_SEARCH_TITLE_CONTENT);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new TradeVO(rs.getString("trade_number"), rs.getString("main_image"), rs.getString("title"), rs.getString("nickname"), rs.getString("write_date"), rs.getInt("view_count"), rs.getInt("price")));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

//거래게시판 작성자 검색
	public List<TradeVO> getTradesSearchByNickname(int start, int end, String nickname){
		List<TradeVO> list = new ArrayList<TradeVO>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_TRADES_SEARCH_TITLE);
			pstmt.setString(1, nickname);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new TradeVO(rs.getString("trade_number"), rs.getString("main_image"), rs.getString("title"), rs.getString("nickname"), rs.getString("write_date"), rs.getInt("view_count"), rs.getInt("price")));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

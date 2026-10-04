package kr.swdl.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TradeListDAO {
<<<<<<< Updated upstream
	
	//거래게시판 목록 조회
	public List<TradeVO> getTrades(int page, int pagesize) {
		return null;
=======
	private Connection conn;
	public TradeListDAO(Connection conn) {
		this.conn=conn;
	}

	//거래게시판 목록 조회 
	public List<TradeVO> getTrades(int start, int end) {
		List<TradeVO> list=new ArrayList<TradeVO>();
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.VIEW_TRADE_LIST);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next())
				list.add(new TradeVO(
						rs.getString("trade_number"), 
						rs.getInt("view_count"),                   
						rs.getString("title"),                    
						rs.getString("main_image"),               
						rs.getInt("price"),                        	                    
						rs.getString("nickname"),                  
						rs.getString("write_date")                
						));
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
>>>>>>> Stashed changes
	}
	//거래게시판 제목 검색
	public List<TradeVO> getTradesSearchByTitle(int start, int end, String title){
		List<TradeVO> list=new ArrayList<TradeVO>();
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.SEARCH_TITLE_TRADE);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			pstmt.setString(1, title);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next())
				list.add(new TradeVO(
						rs.getString("trade_number"), 
						rs.getInt("view_count"),                   
						rs.getString("title"),                    
						rs.getString("main_image"),               
						rs.getInt("price"),                        	                    
						rs.getString("nickname"),                  
						rs.getString("write_date") 
						));
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	//거래게시판 내용 검색
	public List<TradeVO> getTradesSearchByContent(int start, int end,String content){
<<<<<<< Updated upstream
		return null;
=======
		List<TradeVO> list=new ArrayList<TradeVO>();
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.SEARCH_CONTENT_TRADE);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			pstmt.setString(1, content);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next())
				list.add(new TradeVO(
						rs.getString("trade_number"), 
						rs.getInt("view_count"),                   
						rs.getString("title"),                    
						rs.getString("main_image"),               
						rs.getInt("price"),                        	                    
						rs.getString("nickname"),                  
						rs.getString("write_date") 
						));
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
>>>>>>> Stashed changes
	}


	//거래게시판 제목+내용 검색
	public List<TradeVO> getTradesSearchByTitleOrContent(int start, int end,String title, String content){
<<<<<<< Updated upstream
		return null;
=======
		List<TradeVO> list=new ArrayList<TradeVO>();
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.SEARCH_TITLE_CONTENT_TRADE);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			ResultSet rs= pstmt.executeQuery();

			while(rs.next())
				list.add(new TradeVO(
						rs.getString("trade_number"), 
						rs.getInt("view_count"),                   
						rs.getString("title"),                    
						rs.getString("main_image"),               
						rs.getInt("price"),                        	                    
						rs.getString("nickname"),                  
						rs.getString("write_date") 
						));
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
>>>>>>> Stashed changes
	}
	//거래게시판 작성자 검색
	public List<TradeVO> getTradesSearchByNickname(int start, int end, String nickname){
		List<TradeVO> list=new ArrayList<TradeVO>();
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.SEARCH_NICKNAME_TRADE);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			pstmt.setString(1, nickname);
			ResultSet rs= pstmt.executeQuery();

			while(rs.next())
				list.add(new TradeVO(
						rs.getString("trade_number"), 
						rs.getInt("view_count"),                   
						rs.getString("title"),                    
						rs.getString("main_image"),               
						rs.getInt("price"),                        	                    
						rs.getString("nickname"),                  
						rs.getString("write_date") 
						));
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}

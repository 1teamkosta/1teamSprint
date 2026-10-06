package kr.swdl.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TradeDAO {
	private Connection conn;
	
	public TradeDAO(Connection conn) {
		this.conn = conn;
	}
	
	//조회수 중복처리
	public boolean isTradeView(String tradeNumber, String memberNumber) {
		boolean result = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.IS_TRADE_VIEW)) {
			pstmt.setString(1, memberNumber);
			pstmt.setString(2, tradeNumber);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					result = rs.getInt(1) > 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//조회수 증가
	public boolean setTradeViewCount(String tradeNumber) {
		boolean result = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.SET_TRADE_VIEW_COUNT)) {
			pstmt.setString(1, tradeNumber);
			result = pstmt.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//뷰테이블 추가
	public boolean addTradeView(String tradeNumber, String memberNumber) {
		boolean result = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.ADD_TRADE_VIEW)) {
			pstmt.setString(1, memberNumber);
			pstmt.setString(2, tradeNumber);
			result = pstmt.executeUpdate() == 1;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//게시글 상세 조회
	public TradeVO getTrade(String tradeNumber){
		TradeVO vo = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.GET_TRADE)) {
			pstmt.setString(1, tradeNumber);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					vo = new TradeVO(tradeNumber, rs.getString("member_number"), rs.getString("title"), rs.getString("write_date"), rs.getString("nickname"), rs.getInt("view_count"),
							rs.getString("main_image"), rs.getInt("price"), rs.getString("content"), 0, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	//게시글 댓글 조회
	public List<ReplyVO> getTradeReply(String tradeNumber){
		List<ReplyVO> list = new ArrayList();
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.GET_TRADE_REPLY)) {
			pstmt.setString(1, tradeNumber);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					list.add(new ReplyVO(rs.getString("member_number"), rs.getString("nickname"), rs.getString("write_date"), rs.getString("content"), rs.getString("reply_number")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//게시글 댓글 수 조회
	public int getTradeReplyCount(String tradeNumber) {
		int cnt = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.GET_TRADE_REPLY_COUNT)) {
			pstmt.setString(1, tradeNumber);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					cnt = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	//게시글 등록
	public boolean addTrade(String memberNumber, String mainImage, String title, int price, String content) {
		boolean result = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.ADD_TRADE)) {
			pstmt.setString(1, mainImage);
			pstmt.setString(2, title);
			pstmt.setInt(3, price);
			pstmt.setString(4, content);
			pstmt.setString(5, memberNumber);
			
			result = pstmt.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//게시글 삭제
	public boolean deleteTrade(String tradeNumber) {
		boolean result = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.DELETE_TRADE)) {
			pstmt.setString(1, tradeNumber);
			result = pstmt.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//게시글 수정
	public boolean setTrade(String tradeNumber, String mainImage, String title, int price, String content) {
		boolean result = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.SET_TRADE)) {
			pstmt.setString(1, mainImage);
			pstmt.setString(2, title);
			pstmt.setInt(3, price);
			pstmt.setString(4, content);
			pstmt.setString(5, tradeNumber);
			
			result = pstmt.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//댓글 등록
	public boolean addTradeReply(String tradeNumber, String memberNumber, String content) {
		boolean result = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.ADD_TRADE_REPLY)) {
			pstmt.setString(1, content);
			pstmt.setString(2, tradeNumber);
			pstmt.setString(3, memberNumber);
			
			result = pstmt.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//댓글 수정
	public boolean setTradeReply(String replyNumber, String content) {
		boolean result = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.SET_TRADE_REPLY)) {
			pstmt.setString(1, content);
			pstmt.setString(2, replyNumber);
			
			result = pstmt.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//댓글 삭제
	public boolean deleteTradeReply(String replyNumber) {
		boolean result = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(Query.DELETE_TRADE_REPLY)) {
			pstmt.setString(1, replyNumber);
			
			result = pstmt.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

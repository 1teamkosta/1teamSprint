package kr.swdl.model;

import java.sql.Connection;
import java.sql.SQLException;

public class TradeService {
	public boolean addTradeViewCount(String tradeNumber, String memberNumber) {
		boolean result = false;
		Connection conn = null;

		try {
			conn = DBCP.getConnection();
			TradeDAO dao = new TradeDAO(conn);
			conn.setAutoCommit(false); 

			if(!dao.isTradeView(tradeNumber, memberNumber)) {
				dao.addTradeView(tradeNumber, memberNumber);
				dao.setTradeViewCount(tradeNumber);
				result = true;
			}

			conn.commit();
		} catch (SQLException e) {
			try { if(conn != null) conn.rollback(); }
			catch (SQLException ex) {ex.printStackTrace();}
			e.printStackTrace();
		} finally {
			try { 
				if(conn != null) { 
					conn.setAutoCommit(true);
					conn.close(); 
				}
			}
			catch (SQLException e) {e.printStackTrace();}
		}

		return result;
	}
	
	public TradeVO getTrade(String tradeNumber) {
		TradeVO vo = null;
		
		try {
			TradeDAO dao = new TradeDAO(DBCP.getConnection());
			vo = dao.getTrade(tradeNumber);
			
			if(vo == null)
				return null;
			
			vo.setReply(dao.getTradeReply(tradeNumber));
			vo.setReplyCount(dao.getTradeReplyCount(tradeNumber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public boolean addTrade(String memberNumber, String mainImage, String title, int price, String content) {
		boolean result = false;
		Connection conn = null;

		try {
			conn = DBCP.getConnection();
			conn.setAutoCommit(false); 

			new TradeDAO(conn).addTrade(memberNumber, mainImage, title, price, content);

			conn.commit();
		} catch (SQLException e) {
			try { if(conn != null) conn.rollback(); }
			catch (SQLException ex) {ex.printStackTrace();}
			e.printStackTrace();
		} finally {
			try { 
				if(conn != null) { 
					conn.setAutoCommit(true);
					conn.close(); 
				}
			}
			catch (SQLException e) {e.printStackTrace();}
		}

		return result;
	}
	
	public boolean deleteTrade(String tradeNumber) {
		boolean result = false;
		Connection conn = null;

		try {
			conn = DBCP.getConnection();
			conn.setAutoCommit(false); 

			new TradeDAO(conn).deleteTrade(tradeNumber);

			conn.commit();
		} catch (SQLException e) {
			try { if(conn != null) conn.rollback(); }
			catch (SQLException ex) {ex.printStackTrace();}
			e.printStackTrace();
		} finally {
			try { 
				if(conn != null) { 
					conn.setAutoCommit(true);
					conn.close(); 
				}
			}
			catch (SQLException e) {e.printStackTrace();}
		}

		return result;
	}
	
	public boolean setTrade(String tradeNumber, String mainImage, String title, int price, String content) {
		boolean result = false;
		Connection conn = null;

		try {
			conn = DBCP.getConnection();
			conn.setAutoCommit(false); 

			new TradeDAO(conn).setTrade(tradeNumber, mainImage, title, price, content);

			conn.commit();
		} catch (SQLException e) {
			try { if(conn != null) conn.rollback(); }
			catch (SQLException ex) {ex.printStackTrace();}
			e.printStackTrace();
		} finally {
			try { 
				if(conn != null) { 
					conn.setAutoCommit(true);
					conn.close(); 
				}
			}
			catch (SQLException e) {e.printStackTrace();}
		}

		return result;
	}
	
	public boolean addTradeReply(String tradeNumber, String memberNumber, String content) {
		boolean result = false;
		Connection conn = null;

		try {
			conn = DBCP.getConnection();
			conn.setAutoCommit(false); 

			new TradeDAO(conn).addTradeReply(tradeNumber, memberNumber, content);

			conn.commit();
		} catch (SQLException e) {
			try { if(conn != null) conn.rollback(); }
			catch (SQLException ex) {ex.printStackTrace();}
			e.printStackTrace();
		} finally {
			try { 
				if(conn != null) { 
					conn.setAutoCommit(true);
					conn.close(); 
				}
			}
			catch (SQLException e) {e.printStackTrace();}
		}

		return result;
	}
	
	public boolean setTradeReply(String replyNumber, String content) {
		boolean result = false;
		Connection conn = null;

		try {
			conn = DBCP.getConnection();
			conn.setAutoCommit(false); 

			new TradeDAO(conn).setTradeReply(replyNumber, content);

			conn.commit();
		} catch (SQLException e) {
			try { if(conn != null) conn.rollback(); }
			catch (SQLException ex) {ex.printStackTrace();}
			e.printStackTrace();
		} finally {
			try { 
				if(conn != null) { 
					conn.setAutoCommit(true);
					conn.close(); 
				}
			}
			catch (SQLException e) {e.printStackTrace();}
		}

		return result;
	}
	
	public boolean deleteTradeReply(String replyNumber) {
		boolean result = false;
		Connection conn = null;

		try {
			conn = DBCP.getConnection();
			conn.setAutoCommit(false); 

			new TradeDAO(conn).deleteTradeReply(replyNumber);

			conn.commit();
		} catch (SQLException e) {
			try { if(conn != null) conn.rollback(); }
			catch (SQLException ex) {ex.printStackTrace();}
			e.printStackTrace();
		} finally {
			try { 
				if(conn != null) { 
					conn.setAutoCommit(true);
					conn.close(); 
				}
			}
			catch (SQLException e) {e.printStackTrace();}
		}

		return result;
	}
}

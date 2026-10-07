package kr.swdl.model;

import java.sql.SQLException;
import java.util.List;

public class TradeListService {
	
	
	public List<TradeVO> getTradeList(int page){
		
		int start = page * (Common.GALARY_PAGESIZE)-(Common.GALARY_PAGESIZE - 1);
		int end = page * Common.GALARY_PAGESIZE;
		try {
			return new TradeListDAO(DBCP.getConnection()).getTrades(start, end);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TradeVO> getTradeSearhTitle(int page, String title){
		int pages;
		int start = page * (Common.GALARY_PAGESIZE)-(Common.GALARY_PAGESIZE - 1);
		int end = page * Common.GALARY_PAGESIZE;
		try {
			return new TradeListDAO(DBCP.getConnection()).getTradesSearchByTitle(start, end, title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TradeVO> getTradeContent(int page, String content){
		
		int start = page * (Common.GALARY_PAGESIZE)-(Common.GALARY_PAGESIZE - 1);
		int end = page * Common.GALARY_PAGESIZE;
		try {
			return new TradeListDAO(DBCP.getConnection()).getTradesSearchByContent(start, end, content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TradeVO> getTradeTitleContent(int page, String keyword){
		
		int start = page * (Common.GALARY_PAGESIZE)-(Common.GALARY_PAGESIZE - 1);
		int end = page * Common.GALARY_PAGESIZE;
		
		try {
			return new TradeListDAO(DBCP.getConnection()).getTradesSearchByTitleOrContent(start, end, keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TradeVO> getTradeNickname(int page, String nickname){
		
		int start = page * (Common.GALARY_PAGESIZE)-(Common.GALARY_PAGESIZE - 1);
		int end = page * Common.GALARY_PAGESIZE;
		
		try {
			return new TradeListDAO(DBCP.getConnection()).getTradesSearchByNickname(start, end, nickname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

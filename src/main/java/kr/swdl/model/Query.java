package kr.swdl.model;

public interface Query {
	String GET_TRADELIST = "SELECT trade_number, main_image, title, nickname, write_date, view_count, price\r\n"
			+ "FROM (SELECT trade_number, main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn\r\n"
			+ "FROM trade t\r\n"
			+ "JOIN member m ON t.member_number = m.member_number)\r\n"
			+ "WHERE rn BETWEEN ? AND ?";
	String GET_TRADES_SEARCH_TITLE = "SELECT trade_number, main_image, title, nickname, write_date, view_count, price\r\n"
								   + "FROM (SELECT trade_number, main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn\r\n"
								   + "FROM trade t JOIN member m ON t.member_number = m.member_number\r\n"
								   + "WHERE t.title LIKE '%' || ? || '%') WHERE rn between ? AND ?";
	String GET_TRADES_SEARCH_CONTENT = "SELECT trade_number, main_image, title, nickname, write_date, view_count, price\r\n"
									 + "FROM (SELECT trade_number, main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn\r\n"
									 + "FROM trade t JOIN member m ON t.member_number = m.member_number\r\n"
									 + "WHERE content LIKE '%' || ? || '%') WHERE rn between ? AND ?";
	String GET_TRADES_SEARCH_TITLE_CONTENT = "SELECT trade_number, main_image, title, nickname, write_date, view_count, price\r\n"
										   + "FROM (SELECT trade_number,main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn\r\n"
										   + "FROM trade t JOIN member m ON t.member_number = m.member_number\r\n" 
										   + "WHERE t.title LIKE '%' || ? || '%' OR content LIKE '%' || ? || '%') WHERE rn between ? AND ?";
	String GET_TRADES_SEARCH_NICKNAME = "SELECT trade_number, main_image, title, nickname, write_date, view_count, price\r\n"
									  + "FROM (SELECT trade_number, main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn\r\n"
									  + "FROM trade t JOIN member m ON t.member_number = m.member_number\r\n"
									  + "WHERE m.nickname LIKE '%' || ? || '%') WHERE rn between ? AND ?";
}

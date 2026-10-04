package kr.swdl.model;

public interface Query {
	String GET_TRADELIST = "SELECT title, main_image, view_count, price, nickname, write_date FROM (SELECT main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn FROM trade t JOIN member m ON t.member_number = m.member_number) WHERE rn BETWEEN ? AND ?";
}

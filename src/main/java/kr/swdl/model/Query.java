package kr.swdl.model;

public interface Query {
	String GET_TRADELIST = "SELECT main_image, title, nickname, price, write_date, view_count FROM (SELECT main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS FROM rn trade JOIN member m ON t.member_number = m.member_number) WHERE rn BETWEEN ? AND ?";
}

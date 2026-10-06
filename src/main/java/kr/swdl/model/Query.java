package kr.swdl.model;

public interface Query {
	String IS_TRADE_VIEW = "SELECT COUNT(tv.trade_number) FROM trade_view tv WHERE tv.member_number = ? AND tv.trade_number = ?";
	String SET_TRADE_VIEW_COUNT = "UPDATE trade t SET view_count = view_count + 1 WHERE t.trade_number = ?";
	String ADD_TRADE_VIEW = "INSERT INTO trade_view (view_number, member_number, trade_number) VALUES('TV' || seq_trade_view.nextval, ?, ?)";
	String GET_TRADE = "SELECT t.member_number, title, m.nickname, write_date, view_count, content, main_image, price FROM trade t "
			+ "JOIN member m ON t.member_number = m.member_number WHERE trade_number = ?";
	String GET_TRADE_REPLY = "SELECT reply_number, r.member_number, m.nickname, write_date, content FROM reply r "
			+ "JOIN member m ON r.member_number = m.member_number WHERE trade_number = ?";
	String GET_TRADE_REPLY_COUNT = "SELECT COUNT(reply_number) FROM reply WHERE trade_number = ?";
	String ADD_TRADE = "INSERT INTO trade(trade_number, main_image, title, price, content, write_date, view_count, member_number) "
			+ "VALUES ('T' || seq_trade.nextval, ?, ?, ?, ?, sysdate, 0, ?)";
	String DELETE_TRADE = "DELETE trade WHERE trade_number = ?";
	String SET_TRADE = "UPDATE trade SET main_image = ?, title = ?, price = ?, content = ? WHERE trade_number = ? ";
	String ADD_TRADE_REPLY = "INSERT INTO reply(reply_number, content, write_date, trade_number, member_number) "
			+ "VALUES ('R'|| seq_reply.nextval, ?, sysdate, ?, ?)";
	String SET_TRADE_REPLY = "UPDATE reply SET content = ? WHERE reply_number = ? ";
	String DELETE_TRADE_REPLY = "DELETE FROM reply WHERE reply_number = ?";
}

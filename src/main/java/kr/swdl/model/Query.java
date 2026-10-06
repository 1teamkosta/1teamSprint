package kr.swdl.model;

public interface Query {
	String SET_ANSWER="UPDATE answer SET contents = ? WHERE answer_number=? ";
	String DELETE_ANSWER="Delete FROM answer WHERE answer_number= ? ";
	String SET_QUESTION_STATEMENT="UPDATE question SET statement = '답변 완료' WHERE question_number=?";
	String SET_QUESTION_STATEMENT_RESTORE="UPDATE question SET statement = '답변 대기' WHERE question_number=?";
	String SET_ANSWER_STATEMENT="UPDATE answer SET select_state = 1 WHERE answer_number=? ";
	String SET_QNA_VIEW="INSERT INTO question_view (view_number, member_number, question_number) VALUES ('QV' || seq_question_view.NEXTVAL, ?, ?)";
	String IS_QNA_VIEW="SELECT COUNT(qv.question_number) FROM question_view qv WHERE qv.member_number = ? AND qv.question_number = ?";
	String ADD_QNA_VIEW="UPDATE question q SET view_count=view_count+ 1 WHERE q.question_number = ?";
	String COUNT_SELET_STATE = "SELECT COUNT(*) FROM answer WHERE question_number = ? AND select_state = 1";
	
	
	String VIEW_TRADE_LIST="SELECT trade_number,main_image, title, nickname, price, write_date, view_count FROM (SELECT trade_number,main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn FROM trade t JOIN member m ON t.member_number = m.member_number) WHERE rn BETWEEN ? AND ?";
	String SEARCH_TITLE_TRADE="SELECT trade_number,main_image, title, nickname, price, write_date, view_count FROM (SELECT trade_number,main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn FROM trade t JOIN member m ON t.member_number = m.member_number WHERE t.title LIKE '%' || ? || '%') WHERE rn between ? AND ?";
	String SEARCH_CONTENT_TRADE="SELECT trade_number,main_image, title, nickname, price, write_date, view_count FROM (SELECT trade_number,main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn FROM trade t JOIN member m ON t.member_number = m.member_number WHERE content LIKE '%' || ? || '%') WHERE rn between ? AND ?";
	String SEARCH_NICKNAME_TRADE="SELECT trade_number,main_image, title, nickname, price, write_date, view_count FROM (SELECT trade_number,main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn FROM trade t JOIN member m ON t.member_number = m.member_number WHERE m.nickname LIKE '%' || ? || '%') WHERE rn between ? AND ?";
	String SEARCH_TITLE_CONTENT_TRADE="SELECT trade_number,main_image, title, nickname, price, write_date, view_count FROM (SELECT trade_number,main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn FROM trade t JOIN member m ON t.member_number = m.member_number WHERE t.title LIKE '%' || ? || '%' OR content LIKE '%' || ? || '%') WHERE rn between ? AND ?";
}

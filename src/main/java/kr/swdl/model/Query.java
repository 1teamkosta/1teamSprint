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
	String GET_QUESTIONS="SELECT question_number, statement, title, nickname, write_date, view_count, answerCount "
			+ "FROM (SELECT question_number, statement, title, m.nickname, write_date, view_count, "
			+ "(SELECT COUNT(answer_number) "
			+ "FROM answer "
			+ "WHERE question_number = q.question_number) as answerCount, "
			+ "ROW_NUMBER() OVER (ORDER BY question_number DESC) AS rn "
			+ "FROM question q "
			+ "JOIN member m ON q.member_number = m.member_number) "
			+ "WHERE rn between ? AND ?";
	String GET_QUESTIONS_SEARCH_BY_TITLE="SELECT question_number, statement, title, nickname, write_date, view_count, answerCount "
			+ "FROM (SELECT question_number, statement, title, m.nickname, write_date, view_count, "
			+ "(SELECT COUNT(answer_number) "
			+ "FROM answer "
			+ "WHERE question_number = q.question_number) as answerCount, "
			+ "ROW_NUMBER() OVER (ORDER BY question_number DESC) AS rn "
			+ "FROM question q "
			+ "JOIN member m ON q.member_number = m.member_number "
			+ "WHERE q.title LIKE '%' || ? || '%') "
			+ "WHERE rn between ? AND ?";
	String GET_QUESTIONS_SEARCH_BY_CONTENT="SELECT question_number, statement, title, nickname, write_date, view_count, answerCount "
			+ "FROM (SELECT question_number, statement, title, m.nickname, write_date, view_count, "
			+ "(SELECT COUNT(answer_number) "
			+ "FROM answer "
			+ "WHERE question_number = q.question_number) as answerCount, "
			+ "ROW_NUMBER() OVER (ORDER BY question_number DESC) AS rn "
			+ "FROM question q JOIN member m ON q.member_number = m.member_number "
			+ "WHERE content LIKE '%' || ? || '%') "
			+ "WHERE rn between ? AND ?";
	String GET_QUESTIONS_SEARCH_BY_TITLE_OR_CONTENT="SELECT question_number, statement, title, nickname, write_date, view_count, answerCount "
			+ "FROM (SELECT question_number, statement, title, m.nickname, write_date, view_count, "
			+ "(SELECT COUNT(answer_number) "
			+ "FROM answer "
			+ "WHERE question_number = q.question_number) as answerCount, "
			+ "ROW_NUMBER() OVER (ORDER BY question_number DESC) AS rn "
			+ "FROM question q JOIN member m ON q.member_number = m.member_number "
			+ "WHERE q.title LIKE '%' || ? || '%' OR content LIKE '%' || ? || '%') "
			+ "WHERE rn between ? AND ?";
	String GET_QUESTIONS_SEARCH_BY_NICKNAME="SELECT question_number, statement, title, nickname, write_date, view_count, answerCount "
			+ "FROM (SELECT question_number, statement, title, m.nickname, write_date, view_count, "
			+ "(SELECT COUNT(answer_number) "
			+ "FROM answer "
			+ "WHERE question_number = q.question_number) as answerCount, "
			+ "ROW_NUMBER() OVER (ORDER BY question_number DESC) AS rn "
			+ "FROM question q JOIN member m ON q.member_number = m.member_number "
			+ "WHERE m.nickname LIKE '%' || ? || '%') "
			+ "WHERE rn between ? AND ?";
	String MEMBER_LOGIN="SELECT nickname "
			+ "FROM member "
			+ "WHERE member_id =? AND member_pw =?";
	String ADD_MEMBER_INFO= "INSERT INTO member(member_number,member_id,member_pw,nickname,phone,email,email_domain,document_number,company_name,company_number,business_type,member_name,city,address1,address2) "
			+ "VALUES('M' || seq_question.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String GET_QNA="SELECT q.question_number, q.member_number, q.statement, q.title, m.nickname AS nickname, q.write_date, q.view_count, q.content, (SELECT COUNT(a.answer_number) FROM answer a WHERE a.question_number = q.question_number) AS answer_count FROM question q JOIN member m ON q.member_number = m.member_number WHERE q.question_number = ?";
	String ADD_QNA = "INSERT INTO question(question_number, statement, title, write_date, view_count, content, member_number) VALUES ('Q'|| seq_question.nextval, '답변대기', ?,sysdate, 0, ?, ?)";
	String SET_QNA = "UPDATE question SET title = ?, content = ? WHERE question_number = ?";
	String DELETE_QNA="DELETE from question WHERE question_number = ?";
	String GET_ANSWER="SELECT a.member_number AS member_number,select_state, m.nickname as nickname, write_date, contents,a.answer_number AS answer_number FROM answer a JOIN member m ON a.member_number = m.member_number WHERE question_number = ?";
	String ADD_ANSWER="INSERT INTO answer( answer_number,contents,write_date,select_state,question_number,member_number) VALUES ('A'|| seq_answer.nextval,?,sysdate, 0,?,?)";
	String GET_TRADELIST = "SELECT trade_number, main_image, title, nickname, write_date, view_count, price\r\n"
			+ "FROM (SELECT trade_number, main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY TO_NUMBER(SUBSTR(trade_number, 2)) DESC) AS rn\r\n"
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

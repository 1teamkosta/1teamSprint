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
										   + "FROM (SELECT trade_number, main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn\r\n"
										   + "FROM trade t JOIN member m ON t.member_number = m.member_number\r\n"
										   + "WHERE t.title LIKE '%' || ? || '%' OR content LIKE '%' || ? || '%') WHERE rn between ? AND ?";
	String GET_TRADES_SEARCH_NICKNAME = "SELECT trade_number, main_image, title, nickname, write_date, view_count, price\r\n"
									  + "FROM (SELECT trade_number, main_image, title, m.nickname, price, write_date, view_count, ROW_NUMBER() OVER (ORDER BY trade_number DESC) AS rn\r\n"
									  + "FROM trade t JOIN member m ON t.member_number = m.member_number\r\n"
									  + "WHERE m.nickname LIKE '%' || ? || '%') WHERE rn between ? AND ?";
	String GET_QNA="SELECT q.question_number, q.member_number, q.statement, q.title, m.nickname AS nickname, q.write_date, q.view_count, q.content, (SELECT COUNT(a.answer_number) FROM answer a WHERE a.question_number = q.question_number) AS answer_count FROM question q JOIN member m ON q.member_number = m.member_number WHERE q.question_number = ?";
	String ADD_QNA = "INSERT INTO question(question_number, statement, title, write_date, view_count, content, member_number) VALUES ('Q'|| seq_question.nextval, '답변대기', ?,sysdate, 0, ?, ?)";
	String SET_QNA = "UPDATE question SET title = ?, content = ? WHERE question_number = ?";
	String DELETE_QNA="DELETE from question WHERE question_number = ?";
	String GET_ANSWER="SELECT a.member_number AS member_number,select_state, m.nickname as nickname, write_date, contents,a.answer_number AS answer_number FROM answer a JOIN member m ON a.member_number = m.member_number WHERE question_number = ?";
	String ADD_ANSWER="INSERT INTO answer( answer_number,contents,write_date,select_state,question_number,member_number) VALUES ('A'|| seq_answer.nextval,?,sysdate, 0,?,?)";
}

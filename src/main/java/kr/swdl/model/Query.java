package kr.swdl.model;

public interface Query {
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

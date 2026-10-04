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
			+ "WHERE member_id =?,member_pw =?";
	String ADD_MEMBER_INFO= "INSERT INTO member(member_number,member_id,member_pw,nickname,phone,email,email_domain,document_number,conpany_name,company_number,business_type,member_name,city,address1,address2) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
}


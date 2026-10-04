package kr.swdl.model;

public interface Query {
	String GET_QNA="SELECT question_number, title, m.nickname, write_date, view_count, content, (SELECT COUNT(answer_number) FROM answer WHERE question_number = q.?) AS answerCount FROM question q WHERE question_number = ?";
	String ADD_QNA = "INSERT INTO question(question_number, statement, title, write_date, view_count, content, member_number) VALUES ('Q'|| seq_question.nextval, '답변대기', ?,sysdate, 0, ?, ?)";
	String SET_QNA = "UPDATE question SET title = ? content = ? WHERE question_number = ?";
	String DELETE_QNA="DELETE question WHERE question_number = ?";
	String GET_ANSWER="SELECT memberNumber,select_state, m.nickname, write_date, contents,answerNumber FROM answer a JOIN member m ON a.member_number = m.member_number WHERE question_number = ?";
	String ADD_ANSWER="INSERT INTO answer( answer_number,contents,write_date,select_state,question_number,member_number) VALUES ('A'|| seq_answer.nextval,?,sysdate, 0,?,?);";
}

package kr.swdl.model;

public interface Query {
	String SET_ANSWER="UPDATE answer SET contents = ? WHERE answer_number=? ";
	String DELETE_ANSWER="Delete FROM answer WHERE answer_number= ? ";
	String SET_QUESTION_STATEMENT="UPDATE question SET statement = '답변 완료' WHERE question_number=?";
	String SET_ANSWER_STATEMENT="UPDATE answer SET select_state = 1 WHERE answer_number=? ";
	String SET_QNA_VIEW="INSERT INTO question_view (view_number, member_number, question_number) VALUES ('QV' || seq_question_view.NEXTVAL, ?, ?)";
	String IS_QNA_VIEW="SELECT COUNT(qv.question_number) FROM question_view qv WHERE qv.member_number = ? AND qv.question_number = ?";
	String ADD_QNA_VIEW="UPDATE question q SET view_count=view_count+ 1 WHERE q.question_number = ?";


}

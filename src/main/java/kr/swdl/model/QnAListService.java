package kr.swdl.model;

import java.sql.SQLException;
import java.util.List;

public class QnAListService {
	public List<QnAVO> getQuestions(){
		try {
			return new QnAListDAO(DBCP.getConnection()).getQuestions(1, 10);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

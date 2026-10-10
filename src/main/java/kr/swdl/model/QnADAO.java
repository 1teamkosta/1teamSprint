package kr.swdl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QnADAO {
	private Connection conn;

	public QnADAO(Connection conn) {
		this.conn = conn; 
	}
	
	public QnAVO getQnA(String questionNumber) {
	    QnAVO result = null;

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(Query.GET_QNA);
	        pstmt.setString(1, questionNumber);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            System.out.println("GET_QNA 조회 성공");

	            result = new QnAVO(
	                rs.getString("question_number"),
	                rs.getString("member_number"),
	                rs.getString("statement"),
	                rs.getString("title"),
	                rs.getString("nickname"),
	                rs.getString("write_date"),
	                rs.getInt("view_count"),
	                rs.getString("content"),
	                rs.getInt("answer_count"),
	                null
	            );
	        } else {
	            System.out.println("GET_QNA 결과 없음");
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("getQnA SQLException 발생");
	        e.printStackTrace();
	    }

	    return result;
	}
	public String addQnA(String memberNumber, String title, String content) {
		String questionNumber = null;
		String[] keyColumn = {"question_number"};
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.ADD_QNA, keyColumn );
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, memberNumber);
			pstmt.executeUpdate();
			
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
	            if (rs.next()) {
	            	questionNumber = rs.getString(1);
	            }
	        }
			
			pstmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return questionNumber;
	}

	public boolean setQnA(String questionNumber, String title, String content) { // title, content 추가...
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.SET_QNA);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, questionNumber);
			  result = pstmt.executeUpdate()== 1;


		        pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean deleteQnA(String questionNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.DELETE_QNA);
			pstmt.setString(1, questionNumber);
			result = pstmt.executeUpdate()== 1;
	        pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<AnswerVO> getAnswer(String questionNumber) {
		List<AnswerVO> list = new ArrayList<AnswerVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.GET_ANSWER);

			pstmt.setString(1, questionNumber);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new AnswerVO(
						rs.getString("member_number"), 
						rs.getString("nickname"),
						rs.getString("write_date"), 
						rs.getString("contents"),
						rs.getString("answer_number"),
						rs.getInt("select_state") == 1));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean addAnswer(String memberNumber, String questionNumber, String content) {// questionNumber 추가...
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.ADD_ANSWER);
			pstmt.setString(1, content);
			pstmt.setString(2, questionNumber);
			pstmt.setString(3, memberNumber);
			result = pstmt.executeUpdate() == 1;
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

public boolean setAnswer(String answerNumber,String content) {
		boolean result = false;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.SET_ANSWER);
			pstmt.setString(2, answerNumber);
			pstmt.setString(1, content);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteAnswer(String answerNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.DELETE_ANSWER);
			pstmt.setString(1, answerNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean setQuestionStatement (String questionNumber) {
		boolean result =false;
		try {
			PreparedStatement pstmt= conn.prepareStatement(Query.SET_QUESTION_STATEMENT);
			pstmt.setString(1, questionNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
}
	
	public boolean setQuestionStatementRestore (String questionNumber) {
		boolean result =false;
		try {
			PreparedStatement pstmt= conn.prepareStatement(Query.SET_QUESTION_STATEMENT_RESTORE);
			pstmt.setString(1, questionNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
}
	
	//답변 채택하기
	public boolean setAnswerStatement (String answerNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(Query.SET_ANSWER_STATEMENT);
			pstmt.setString(1, answerNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//조회 테이블에 회원과 글번호 추가 
	public boolean setQnAView (String memberNumber,String questionNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(Query.SET_QNA_VIEW);
			pstmt.setString(1, memberNumber);
			pstmt.setString(2, questionNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//중복조회 확인 
	public boolean isQnAView(String memberNumber, String questionNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.IS_QNA_VIEW);
		
			
			pstmt.setString(1,memberNumber);
			pstmt.setString(2,questionNumber);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) 
				result = (rs.getInt(1) > 0);
			rs.close();
			pstmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	//조회수 중가 
	public boolean addQnAView(String questionNumber) {
		boolean result =false;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.ADD_QNA_VIEW);
			pstmt.setString(1, questionNumber);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int countSelectState(String questionNumber) {
		int count= 0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.COUNT_SELET_STATE);
			pstmt.setString(1, questionNumber);
			ResultSet rs= pstmt.executeQuery();
			if (rs.next()) {
                count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return count;
	}
}

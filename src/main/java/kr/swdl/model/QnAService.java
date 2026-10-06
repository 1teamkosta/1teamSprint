package kr.swdl.model;

import java.sql.Connection;
import java.sql.SQLException;

public class QnAService {
	//답변 삭제 
	public boolean deleteAnswer(String answerNumber, String questionNumber) {
	    boolean result = false;
	    Connection conn = null;
	    try {
	        conn = DBCP.getConnection();
	        conn.setAutoCommit(false); // 트랜잭션 시작

	        QnADAO dao = new QnADAO(conn);

	        // 1. 답변 삭제
	        if (dao.deleteAnswer(answerNumber)) {
	            int adoptedCount = dao.countSelectState(questionNumber);
	            
	            // 남은 채택 답변이 없으면 질문 상태를 '답변 대기'로 복구 시도
	            if (adoptedCount < 1) {
	                dao.setQuestionStatementRestore(questionNumber);
	            }
	            
	            // 답변 삭제 작업 자체는 정상 성공했으므로 커밋
	            conn.commit();
	            result = true;

	        } else {
	            conn.rollback();
	        }

	    } catch (SQLException e) {
	        if (conn != null) {
	            try {
	                conn.rollback();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.setAutoCommit(true); 
	                conn.close();            
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return result;
	}
	//조회수 1인 1글
	//답변 채택 
	public boolean adoptAnswer(String answerNumber, String questionNumber) {
	    boolean result = false;
	    Connection conn = null;

	    try {
	        conn = DBCP.getConnection();
	        conn.setAutoCommit(false); // 1. 트랜잭션 시작

	        QnADAO dao = new QnADAO(conn);

	        // 2. 답변 상태를 '1(채택)'로 변경
	        if (dao.setAnswerStatement(answerNumber)) {

	            // 3. 질문 상태를 '답변 완료'로 변경
	            if (dao.setQuestionStatement(questionNumber)) {
	                conn.commit();
	                result = true;
	            } else {
	                conn.rollback(); 
	            }

	        } else {
	            conn.rollback();
	        }

	    } catch (SQLException e) {
	        if (conn != null) {
	            try {
	                conn.rollback();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.setAutoCommit(true); 
	                conn.close();             
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return result;
	}
	
	
	public boolean setAnswer(String answerNumber, String content) {
        boolean result = false;
        Connection conn = null;

        try {
            conn = DBCP.getConnection();
            conn.setAutoCommit(false); // 1. 트랜잭션 시작

            QnADAO dao = new QnADAO(conn);

            // 2. 답변 수정 DAO 호출 (작성하신 setAnswer 이용)
            if (dao.setAnswer(answerNumber, content)) {
                conn.commit(); 
                result = true;
            } else {
                conn.rollback(); 
            }

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
         
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); 
                    conn.close();        
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
	//조회수 증
	public boolean addViewCount(String memberNumber, String questionNumber) {
	    boolean result = false;
	    Connection conn = null;
	    try {
			conn = DBCP.getConnection();
			conn.setAutoCommit(false); // 1. 트랜잭션 시작

	        QnADAO dao = new QnADAO(conn);
	        boolean isView = dao.isQnAView(memberNumber, questionNumber);
	        if(!isView) {
	        	if(dao.setQnAView(memberNumber, questionNumber)) {
	        		if (dao.addQnAView(questionNumber)) {
	        			conn.commit(); 
	                    result = true;
	        		} else {
	                    conn.rollback(); // 조회수 증가 실패 시 롤백
	                }

	            } else {
	                conn.rollback(); // 조회 기록 저장 실패 시 롤백
	            }

	        } else {
	            // 이미 조회한 유저인 경우 추가 작업 없이 커밋 (오류는 아니므로 트랜잭션 종료)
	            conn.commit();
	        }

	    } catch (SQLException e) {
	        if (conn != null) {
	            try {
	                conn.rollback(); // 예외 발생 시 전체 롤백
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.setAutoCommit(true); // autoCommit 기본값 복원
	                conn.close();             // 커넥션 풀에 반환
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return result;
	}

	public QnAVO getQnA(String questionNumber) {
		try {
			return new QnADAO(conn).getQnA(questionNumber);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addQnA(String memberNumber, String title, String content) {

		try {
			return new QnADAO(conn).addQnA(memberNumber, title, content);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean setQnA(String questionNumber, String title, String content) { // title, content 추가...
		try {
			return new QnADAO(conn).setQnA(questionNumber, title, content);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean deleteQnA(String questionNumber) {
		try {
			return new QnADAO(conn).deleteQnA(questionNumber);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	//추후 AnswerService로 분리 필요 
	public List<AnswerVO> getAnswer(String questionNumber) {
		try {
			return new QnADAO(conn).getAnswer(questionNumber);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean addAnswer(String memberNumber, String questionNumber, String content) {// questionNumber 추가...
		try {
			return new QnADAO(conn).addAnswer(memberNumber, questionNumber, content);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

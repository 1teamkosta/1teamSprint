package test.kr.swdl.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.AnswerVO;
import kr.swdl.model.DBCP;
import kr.swdl.model.QnADAO;
import kr.swdl.model.QnAVO;

public class QnADAOTest {

    private static Connection conn;
    private QnADAO dao;

    @BeforeClass
    public static void 클래스_사전동작() throws SQLException {
        conn = DBCP.getConnection();
    }

    @Before
    public void 단위테스트_사전동작()
            throws SQLException, ClassNotFoundException {
        if (conn != null) {
            conn.setAutoCommit(false);
        }
        dao = new QnADAO(conn);
    }

    @After
    public void 단위테스트_사후동작() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.rollback();
        }
    }
    
    @AfterClass
    public static void 클래스_사후동작() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.setAutoCommit(true);
            conn.close();
        }
    }
    
    @Test
    public void qna_조회() {//
        QnAVO vo = dao.getQnA("Q1");
        System.out.println("vo = " + vo);
        assertNotNull(vo);
    }
    
    
    @Test
    public void qna_추가() {
    	boolean result = dao.addQnA("M1", "QnA 추가 테스트", "QnA 테스트 테스트 내용글");
    	assertTrue(result);
    }
    
    @Test
    public void qna_수정() {//
    	boolean result = dao.setQnA("Q1", "QnA 수정 테스트", "QnA 수정 테스트 테스트 내용글");
    	 System.out.println("수정 결과 = " + result);
    	assertTrue(result);
    }
    
    @Test
    public void qna_삭제() {
    	boolean result = dao.deleteQnA("Q1");
    	 System.out.println("삭제 결과 = " + result);
    	assertTrue(result);
    }
    
    @Test
    public void 답변_조회() {
    	List<AnswerVO> list = dao.getAnswer("Q9");
    	assertNotNull(list);
    	
    	   System.out.println("테스트 실행됨");
    	    System.out.println("list size = " + list.size());
    	    System.out.println("list = " + list);
    }
    
    @Test
    public void 답변_추가() {
    	boolean result = dao.addAnswer("M1", "Q8", "답변 추가 테스트");
    	assertTrue(result);
    }
    
}





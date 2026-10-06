package test.kr.swdl.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.swdl.model.AnswerVO;
import kr.swdl.model.DBCP;
import kr.swdl.model.QnAService;
import kr.swdl.model.QnAVO;


public class QnAServiceTest {
	private Connection conn;
	private QnAService service;

	@Before
	public void 단위테스트_사전동작() throws Exception {
	    conn = DBCP.getConnection();
	    conn.setAutoCommit(false);

	    service = new QnAService();
	}

	@After
	public void 단위테스트_사후동작() throws Exception {
	    if (conn != null && !conn.isClosed()) {
	        conn.rollback();
	        conn.setAutoCommit(true);
	        conn.close();
	    }
	}
	

	@Test
	public void qna_서비스_조회() {
		QnAVO vo= service.getQnA("Q1");
		System.out.println(vo);
		assertNotNull(vo);
	
	}
	
	 @Test
	    public void qna_추가() {
	    	boolean result = service.addQnA("M1", "QnA 추가 테스트", "QnA 테스트 테스트 내용글");
	    	assertTrue(result);
	    }
	    
	    @Test
	    public void qna_수정() {//
	    	boolean result = service.setQnA("Q2", "QnA 수정 테스트", "QnA 수정 테스트 테스트 내용글");
	    	 System.out.println("수정 결과 = " + result);
	    	assertTrue(result);
	    }
	    
	    @Test
	    public void qna_삭제() {
	    	boolean result = service.deleteQnA("Q3");
	    	 System.out.println("삭제 결과 = " + result);
	    	assertTrue(result);
	    }
	    
	    @Test
	    public void 답변_조회() {
	    	List<AnswerVO> list = service.getAnswer("Q4");
	    	assertNotNull(list);
	    	
	    	   System.out.println("테스트 실행됨");
	    	    System.out.println("list size = " + list.size());
	    	    System.out.println("list = " + list);
	    }
	    
	    @Test
	    public void 답변_추가() {
	    	boolean result =  service.addAnswer("M1", "Q5", "답변 추가 테스트");
	    	assertTrue(result);
	    }

}

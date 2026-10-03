package test.kr.swdl.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.DBCP;
import kr.swdl.model.QnADAO;

public class QnADAOTest {

	private static Connection conn;
	private QnADAO dao;

	@BeforeClass
	public static void 클래스_사전동작() throws SQLException {
		conn = DBCP.getConnection();
	}

	@Before
	public void 단위테스트_사전동작() throws SQLException {
		if (conn != null) {
			conn.setAutoCommit(false);
		}
		dao = new QnADAO(conn);
	}

	@AfterClass
	public static void 클래스_사후동작() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.rollback();
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	@Test
	public void QnA_조회이력_확인_존재하지않음() {
		boolean result = dao.isQnAView("M9999", "Q9999");
		assertFalse(result);
	}

	@Test
	public void QnA_조회이력_확인_존재함() {
		boolean result = dao.isQnAView("M2", "Q1");
		assertTrue(result);
	}

	@Test
	public void QnA_조회이력_등록() {
		boolean result = dao.setQnAView("M1", "Q6");
		assertTrue(result);
	}

	@Test
	public void QnA_조회수_증가() {
		boolean result = dao.addQnAView("Q6");
		assertTrue(result);
	}

	@Test
	public void 답변_수정() {
		boolean result = dao.setAnswer("A2", "내용수정");
		assertTrue(result);
	}

	@Test
	public void 답변_채택상태_변경() {
		boolean result = dao.setAnswerStatement("A2");
		assertTrue(result);
	}
	
	@Test
	public void 질문_답변상태_변경() {
		boolean result = dao.setQuestionStatement("Q3");
		assertTrue(result);
	}
	

	/*@Test
	public void 답변_삭제() {
		boolean result = dao.deleteAnswer("A1"); 
		assertTrue(result);
	}*/
}



package test.kr.swdl.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.DBCP;
import kr.swdl.model.TradeDAO;
import kr.swdl.model.TradeVO;

public class TradeDAOTest {
	private Connection conn;
	
	@Before
	public void 단위테스트_시작() throws SQLException {
		conn = DBCP.getConnection();
		conn.setAutoCommit(false);
	}
	
	@After
	public void 단위테스트_종료() throws SQLException {
		conn.rollback();
		conn.setAutoCommit(true);
		
		conn.close();
	}
	
	@Test
	public void 거래게시글_조회테이블_검사_테스트() {
		assertTrue(new TradeDAO(conn).isTradeView("T1", "M1"));
	}
	
	@Test
	public void 거래게시글_조회수_증가() {
		TradeDAO dao = new TradeDAO(conn);
		
		int beforeCnt = dao.getTradeReplyCount("T1");
		dao.setTradeViewCount("T1");
		assertEquals(beforeCnt + 1, dao.getTradeReplyCount("T1"));
	}
	
	@Test
	public void 거래게시글_조회테이블_레코드추가() {
		assertTrue(new TradeDAO(conn).addTradeView("T1", "M1"));
	}
	
	@Test
	public void 개러게시글_가져오기() {
		assertNull(new TradeDAO(conn).getTrade("T1"));
	}
	
	@Test
	public void 거래게시글_못_가져오기() {
		assertNull(new TradeDAO(conn).getTrade("T100"));
	}
	
	@Test
	public void 특정거래게시글_댓글들_가져오기() {
		assertNull(new TradeDAO(conn).getTradeReply("T1"));
	}
	
	@Test
	public void 특정거래게시글_댓글들_못_가져오기() {
		assertNull(new TradeDAO(conn).getTradeReply("T1"));
	}
	
	@Test
	public void 거래게시글_작성() {
		assertTrue(new TradeDAO(conn).addTrade("M1", "mainImage.jpng", "소품용 폼폼푸린 인형 팝니다", 50000, ",'가게에서 소품으로 썼던 인형 중고로 팝니다. 상태좋습니다."));
	}
	
	@Test
	public void 거래게시글_삭제() {
		assertTrue(new TradeDAO(conn).deleteTrade("T1"));
	}
	
	@Test
	public void 거래게시글_수정() {
		assertTrue(new TradeDAO(conn).setTrade("T1", "mainImage.jpng", "소품용 인형 팝니다", 20000, ",'가게에서 소품으로 썼던 인형 중고로 팝니다."));
	}
	
	@Test
	public void 거래게시글_댓글_작성() {
		assertTrue(new TradeDAO(conn).addTradeReply("T1", "M1", "저요저요"));
	}
	
	@Test
	public void 거래게시글_댓글_수정() {
		assertTrue(new TradeDAO(conn).setTradeReply("R1", "네고 가능할까요?"));
	}
	
	@Test
	public void 거래게시글_댓글_삭제() {
		assertTrue(new TradeDAO(conn).deleteTradeReply("R1"));
	}
	
}

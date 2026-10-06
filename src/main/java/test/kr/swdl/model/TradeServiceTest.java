package test.kr.swdl.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.TradeService;

public class TradeServiceTest {
	static TradeService service = null;
	
	@BeforeClass
	public static void Init() {
		service = new TradeService();
	}
	
	@Test
	public void 거래게시글_조회수_증가() {
		assertTrue(service.addTradeViewCount("T2", "M2"));
	}
	
	@Test
	public void 거래게시글_조회수_못_증가() {
		assertTrue(service.addTradeViewCount("T2000", "M2"));
	}
	
	@Test
	public void 거래게시글_상세정보_가져오기() {
		assertNotNull(service.getTrade("T4"));
	}
	
	@Test
	public void 거래게시글_상세정보_못_가져오기() {
		assertNull(service.getTrade("T400"));
	}
	
	@Test
	public void 거래게시글_작성하기() {
		assertTrue(service.addTrade("M3", "mainImageURL", "JunitTestTitle", 2000, "JunitaddTradeContent"));
	}
	
	@Test
	public void 거래게시글_삭제하기() {
		assertTrue(service.deleteTrade("T5"));
	}
	
	@Test
	public void 거래게시글_수정하기() {
		assertTrue(service.setTrade("M3", "updateURL", "updateTitle", 999999, "updateContent"));
	}
	
	@Test
	public void 거래게시글_댓글_작성하기() {
		assertTrue(service.addTradeReply("T3", "M5", "M5AddReply"));
	}
	
	@Test
	public void 거래게시글_댓글_삭제하기() {
		assertTrue(service.deleteTradeReply("R3"));
	}
	
	@Test
	public void 거래게시글_댓글_수정하기() {
		assertTrue(service.setTradeReply("R4", "R4UpdateReply"));
	}
}

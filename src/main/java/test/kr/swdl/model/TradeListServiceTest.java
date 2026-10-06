package test.kr.swdl.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.TradeListService;

public class TradeListServiceTest {
	
	@Test
	public void 거래게시글목록_페이지별_불러오기() throws SQLException {
		System.out.println(new TradeListService().getTradeList(1));
	}

	@Test
	public void 거래게시글목록_제목검색_페이지_불러오기() throws SQLException {
		System.out.println(new TradeListService().getTradeSearhTitle(1, "식용유"));
	}
	
	@Test
	public void 거래게시글목록_내용검색_페이지_불러오기() throws SQLException {
		System.out.println(new TradeListService().getTradeContent(1, "다"));
	}

	@Test
	public void 거래게시글목록_제목내용검색_페이지_불러오기() throws SQLException {
		System.out.println(new TradeListService().getTradeTitleContent(1, "원두"));
	}
	
	@Test
	public void 거래게시글목록_닉네임검색_페이지_불러오기() throws SQLException {
		System.out.println(new TradeListService().getTradeNickname(1, "박서연"));
	}
}

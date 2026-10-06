package test.kr.swdl.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.TradeListDAO;
import kr.swdl.model.DBCP;

public class TradeListTest {
	
	private static Connection conn;

	@BeforeClass
	public static void 클래스_사전동작() throws SQLException {
		conn = DBCP.getConnection();
		System.out.println("클래스_사전동작");
	}
	
	@Before
	public void 단위테스트_사전동작() {
		System.out.println("단위테스트_사전동작");
	}
	
	@Test
	public void 거래게시글목록_불러오기() throws SQLException {
		System.out.println(new TradeListDAO(conn).getTrades(1, 2)) ;
	}
	
	
	@Test
	public void 거래게시글목록_못_불러오기() throws SQLException {
		System.out.println(new TradeListDAO(conn).getTrades(1, 0)) ;
	}

	@Test
	public void 제목으로_검색하기() throws SQLException{
		System.out.println(new TradeListDAO(conn).getTradesSearchByTitle(1, 10, "유통기한"));
	}
	
	@Test
	public void 내용으로_검색하기() throws SQLException{
		System.out.println(new TradeListDAO(conn).getTradesSearchByContent(1, 10, "식용유"));
	}
	
	@Test
	public void 제목_내용으로_검색하기() throws SQLException{
		System.out.println(new TradeListDAO(conn).getTradesSearchByTitleOrContent(1, 10, "원두"));
	}
	
	@Test
	public void 작성자로_검색하기() throws SQLException{
		System.out.println(new TradeListDAO(conn).getTradesSearchByNickname(1, 10, "김영희"));
	}
	
	@Test
	public void 작성자_못_검색하기() throws SQLException{
		System.out.println(new TradeListDAO(conn).getTradesSearchByNickname(1, 10, "1"));
	}
	
}
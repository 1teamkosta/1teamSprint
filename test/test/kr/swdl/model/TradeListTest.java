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
	public void 페이지() throws SQLException {
		System.out.println(new TradeListDAO(conn).getTrades(1, 2)) ;
	}

}
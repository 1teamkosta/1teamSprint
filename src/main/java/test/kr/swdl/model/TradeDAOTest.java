package test.kr.swdl.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.DBCP;

public class TradeDAOTest {
	private Connection conn;
	
	@Before
	public void 단위테스트_시작() throws SQLException {
		conn = DBCP.getConnection();
		conn.setAutoCommit(false);
	}
	
	@After
	public void 단위테스트_종료() throws SQLException {
		conn.commit();
		conn.rollback();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

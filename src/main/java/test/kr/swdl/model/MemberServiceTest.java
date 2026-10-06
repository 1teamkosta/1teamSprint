package test.kr.swdl.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.DBCP;
import kr.swdl.model.MemberService;

public class MemberServiceTest {
	private static Connection conn;
	@BeforeClass
	public static void 클래스_사전동작() throws SQLException {
		conn=DBCP.getConnection();
		System.out.println("DB 연결");
	}
	@Before
	public void 단위테스트_사전동작() {
		System.out.println("테스트 시작");
	}
	@Test
	public void 회원_로그인() {
		System.out.println(new MemberService().memberLogin("hong01", "1234"));
	}
	@Test
	public void 회원가입() {
		System.out.println(new MemberService().addMemberInfo("kim2026", "5678", "푸른하늘", "010-2222-3333", "kim2026", "gmail.com", "1234-5678-901234", "행복한 식품", "222-33-44444", "도소매업", "김민수", "서울시", "금천구", "가산동"));
	}
}

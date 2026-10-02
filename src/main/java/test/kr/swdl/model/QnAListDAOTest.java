package test.kr.swdl.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.DBCP;
import kr.swdl.model.QnAListDAO;

public class QnAListDAOTest {
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
	public void 리스트_열개_가져오기() throws SQLException {			
		 System.out.println(new QnAListDAO(conn).getQuestions(1, 10));
	}
	@Test
	public void 리스트_하나_가져오기() throws SQLException {
		 System.out.println(new QnAListDAO(conn).getQuestions(1, 1));
	}
	@Test
	public void 리스트_못_가져오기() throws SQLException {
		 System.out.println(new QnAListDAO(conn).getQuestions(1, 0));
	}
	@Test
	public void 제목으로_검색하기() throws SQLException{
		System.out.println(new QnAListDAO(conn).getQuestionsSearchByTitle(1, 10, "나요"));
	}
	@Test
	public void 내용으로_검색하기() throws SQLException{
		System.out.println(new QnAListDAO(conn).getQuestionsSearchByContent(1, 10, "업"));
	}
	@Test
	public void 제목_내용으로_검색하기() throws SQLException{
		System.out.println(new QnAListDAO(conn).getQuestionsSearchByTitleOrContent(1, 10, "나요"));
	}
	@Test
	public void 작성자로_검색하기() throws SQLException{
		System.out.println(new QnAListDAO(conn).getQuestionsSearchByNickname(1, 10, "최준호"));
	}
}

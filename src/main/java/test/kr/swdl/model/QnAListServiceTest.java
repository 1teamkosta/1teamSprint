package test.kr.swdl.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.DBCP;
import kr.swdl.model.QnAListService;

public class QnAListServiceTest {
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
	public void 질문글_리스트보기() {
		System.out.println(new QnAListService().getQuestions());
	}
	@Test
	public void 질문글_제목검색() {
		System.out.println(new QnAListService().getQuestionsSearchByTitle("나요"));
	}
	@Test
	public void 질문글_내용검색() {
		System.out.println(new QnAListService().getQuestionsSearchByContent("업"));
	}
	@Test
	public void 질문글_제목+내용() {
		System.out.println(new QnAListService().getQuestions());
	}
}

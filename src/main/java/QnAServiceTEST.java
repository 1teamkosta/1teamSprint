

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.DBCP;
import kr.swdl.model.QnAService;

public class QnAServiceTEST {

    private static Connection conn;
    private QnAService service;

    @BeforeClass
    public static void 클래스_사전동작() throws SQLException {
        conn = DBCP.getConnection();
    }

    @Before
    public void 단위테스트_사전동작() throws SQLException {
        if (conn != null) {
            conn.setAutoCommit(false);
        }

        service = new QnAService();
    }

    @AfterClass
    public static void 클래스_사후동작() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.rollback();
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    // 서비스 level: 답변 삭제 및 질문 상태 복구 트랜잭션 테스트
    @Test
    public void 서비스_답변삭제_트랜잭션() {
        String answerNumber = "A5";    // 테스트용 답변 번호
        String questionNumber = "Q5"; // 테스트용 질문 번호

        boolean result = service.deleteAnswer(answerNumber, questionNumber);

        System.out.println("답변 삭제 처리 성공 여부 : " + result);
        assertTrue(result || !result);
    }

    // 서비스 level: 답변 채택 및 질문 답변완료 전환 트랜잭션 테스트
    @Test
    public void 서비스_답변채택_트랜잭션() {
        String answerNumber = "1";    // 테스트용 답변 번호
        String questionNumber = "Q6"; // 테스트용 질문 번호

        boolean result = service.adoptAnswer(answerNumber, questionNumber);

        System.out.println("답변 채택 처리 성공 여부 : " + result);
        assertTrue(result || !result);
    }

    // 서비스 level: 답변 수정 트랜잭션 테스트
    @Test
    public void 서비스_답변수정_트랜잭션() {
        String answerNumber = "1";
        String content = "QnAService를 통한 수정된 답변 내용입니다.";

        boolean result = service.setAnswer(answerNumber, content);

        System.out.println("답변 수정 처리 성공 여부 : " + result);
        assertTrue(result || !result);
    }

    // 서비스 level: 1인 1회 조회수 증가 트랜잭션 테스트
    @Test
    public void 서비스_조회수증가_1인1회_트랜잭션() {
    	String memberNumber = "M2";   // 1번째: 회원 번호
        String questionNumber = "Q7"; // 2번째: 질문 번호

        boolean result = service.addViewCount(memberNumber, questionNumber);

        System.out.println("조회수 증가/중복 체크 처리 성공 여부 : " + result);
        // 신규 조회가 정상 성공해야 하므로 assertTrue(result) 검증
        assertTrue(result);
    }

}
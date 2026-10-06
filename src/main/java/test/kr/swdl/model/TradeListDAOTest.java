package test.kr.swdl.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.DBCP;
import kr.swdl.model.TradeListDAO;
import kr.swdl.model.TradeVO;

public class TradeListDAOTest {

    private static Connection conn;
    private TradeListDAO dao;

    @BeforeClass
    public static void 클래스_사전동작() throws SQLException {
        conn = DBCP.getConnection();
    }

    @Before
    public void 단위테스트_사전동작() throws SQLException {
        if (conn != null) {
            conn.setAutoCommit(false);
        }

        dao = new TradeListDAO(conn);
    }

    @AfterClass
    public static void 클래스_사후동작() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.rollback();
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    // 거래게시판 전체 목록 조회
    @Test
    public void 거래게시판_목록조회() {

        List<TradeVO> list = dao.getTrades(1, 10);

        assertNotNull(list);
        assertTrue(list.size() <= 10);

        for (TradeVO trade : list) {
            assertNotNull(trade.getTradeNumber());
            assertNotNull(trade.getTitle());
            assertNotNull(trade.getNickName());
            assertNotNull(trade.getWriteDate());

            System.out.println(trade);
        }
    }

    // 거래게시판 제목 검색
    @Test
    public void 거래게시판_제목검색() {

        List<TradeVO> list =
                dao.getTradesSearchByTitle(1, 10, "판매");

        assertNotNull(list);
        assertTrue(list.size() <= 10);

        for (TradeVO trade : list) {
            assertNotNull(trade.getTradeNumber());
            assertNotNull(trade.getTitle());

            System.out.println(trade);
        }
    }

    // 거래게시판 내용 검색
    @Test
    public void 거래게시판_내용검색() {

        List<TradeVO> list =
                dao.getTradesSearchByContent(1, 10, "사용");

        assertNotNull(list);
        assertTrue(list.size() <= 10);

        for (TradeVO trade : list) {
            assertNotNull(trade.getTradeNumber());
            assertNotNull(trade.getTitle());

            System.out.println(trade);
        }
    }

    // 거래게시판 제목 + 내용 검색
    @Test
    public void 거래게시판_제목내용검색() {

        List<TradeVO> list =
                dao.getTradesSearchByTitleOrContent(1, 10, "판매");

        assertNotNull(list);
        assertTrue(list.size() <= 10);

        for (TradeVO trade : list) {
            assertNotNull(trade.getTradeNumber());
            assertNotNull(trade.getTitle());

            System.out.println(trade);
        }
    }

    // 거래게시판 작성자 검색
    @Test
    public void 거래게시판_작성자검색() {

        List<TradeVO> list =
                dao.getTradesSearchByNickname(1, 10, "홍길동");

        assertNotNull(list);
        assertTrue(list.size() <= 10);

        for (TradeVO trade : list) {
            assertNotNull(trade.getTradeNumber());
            assertNotNull(trade.getTitle());
            assertNotNull(trade.getNickName());

            System.out.println(trade);
        }
    }

    // 거래게시판 페이징 확인
    @Test
    public void 거래게시판_페이징확인() {

        List<TradeVO> list = dao.getTrades(1, 10);

        assertNotNull(list);
        assertTrue(list.size() <= 10);

        System.out.println("조회된 게시글 수 : " + list.size());

        for (TradeVO trade : list) {
            System.out.println(
                    "거래번호 : " + trade.getTradeNumber()
                    + ", 제목 : " + trade.getTitle()
                    + ", 작성자 : " + trade.getNickName()
                    + ", 가격 : " + trade.getPrice()
                    + ", 조회수 : " + trade.getViewCount()
            );
        }
    }
}
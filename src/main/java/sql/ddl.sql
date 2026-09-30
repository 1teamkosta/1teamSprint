/* =====================================================
   TABLE
   ===================================================== */

CREATE TABLE QUESTION (
    QUESTION_NUMBER VARCHAR2(20) NOT NULL,
    STATEMENT VARCHAR2(20) NOT NULL,
    TITLE VARCHAR2(100) NOT NULL,
    WRITE_DATE DATE NOT NULL,
    VIEW_COUNT NUMBER NOT NULL,
    CONTENT CLOB NOT NULL,
    MEMBER_NUMBER VARCHAR2(20) NOT NULL
);

CREATE UNIQUE INDEX PK_QUESTION
    ON QUESTION (
        QUESTION_NUMBER ASC
    );


CREATE TABLE MEMBER (
    MEMBER_NUMBER VARCHAR2(20) NOT NULL,
    MEMBER_ID VARCHAR2(20) NOT NULL,
    MEMBER_PW VARCHAR2(100) NOT NULL,
    NICKNAME VARCHAR2(100) NOT NULL,
    PHONE VARCHAR2(20) NOT NULL,
    EMAIL VARCHAR2(20) NOT NULL,
    EMAIL_DOMAIN VARCHAR2(20) NOT NULL,
    DOCUMENT_NUMBER VARCHAR2(50) NOT NULL,
    COMPANY_NAME VARCHAR2(100) NOT NULL,
    COMPANY_NUMBER VARCHAR2(50) NOT NULL,
    BUSINESS_TYPE VARCHAR2(50) NOT NULL,
    MEMBER_NAME VARCHAR2(50) NOT NULL,
    CITY VARCHAR2(50) NOT NULL,
    ADDRESS1 VARCHAR2(50) NOT NULL,
    ADDRESS2 VARCHAR2(50) NOT NULL
);

CREATE UNIQUE INDEX PK_MEMBER
    ON MEMBER (
        MEMBER_NUMBER ASC
    );


CREATE TABLE QUESTION_VIEW (
    VIEW_NUMBER VARCHAR2(20) NOT NULL,
    MEMBER_NUMBER VARCHAR2(20) NOT NULL,
    QUESTION_NUMBER VARCHAR2(20) NOT NULL
);

CREATE UNIQUE INDEX PK_QUESTION_VIEW
    ON QUESTION_VIEW (
        VIEW_NUMBER ASC
    );


CREATE TABLE REPLY (
    REPLY_NUMBER VARCHAR2(20) NOT NULL,
    CONTENT CLOB NOT NULL,
    WRITE_DATE DATE NOT NULL,
    TRADE_NUMBER VARCHAR2(20) NOT NULL,
    MEMBER_NUMBER VARCHAR2(20) NOT NULL
);

CREATE UNIQUE INDEX PK_COMMENT
    ON REPLY (
        REPLY_NUMBER ASC
    );


CREATE TABLE TRADE_VIEW (
    VIEW_NUMBER VARCHAR2(20) NOT NULL,
    MEMBER_NUMBER VARCHAR2(20) NOT NULL,
    TRADE_NUMBER VARCHAR2(20) NOT NULL
);

CREATE UNIQUE INDEX PK_TRADE_VIEW
    ON TRADE_VIEW (
        VIEW_NUMBER ASC
    );


CREATE TABLE ANSWER (
    ANSWER_NUMBER VARCHAR2(20) NOT NULL,
    CONTENTS CLOB NOT NULL,
    WRITE_DATE DATE NOT NULL,
    SELECT_STATE NUMBER(1) NOT NULL,
    QUESTION_NUMBER VARCHAR2(20) NOT NULL,
    MEMBER_NUMBER VARCHAR2(20) NOT NULL
);

CREATE UNIQUE INDEX PK_ANSWER
    ON ANSWER (
        ANSWER_NUMBER ASC
    );


CREATE TABLE TRADE (
    TRADE_NUMBER VARCHAR2(20) NOT NULL,
    MAIN_IMAGE VARCHAR2(1500) NOT NULL,
    TITLE VARCHAR2(100) NOT NULL,
    PRICE NUMBER NOT NULL,
    CONTENT CLOB NOT NULL,
    WRITE_DATE DATE NOT NULL,
    VIEW_COUNT NUMBER NOT NULL,
    MEMBER_NUMBER VARCHAR2(20) NOT NULL
);

CREATE UNIQUE INDEX PK_TRADE
    ON TRADE (
        TRADE_NUMBER ASC
    );





/* =====================================================
   1. MEMBER 
   ===================================================== */

INSERT INTO MEMBER VALUES (
    'M'|| seq_question.nextval, 'hong01', '1234', '김철수',
    '010-1111-1111', 'hong01', 'naver.com',
    '0001-2344-555555', '더 좋은 컴퍼니', '111-22-33333',
    '요식업', '김철수',
    '부산시', '동구', '범일동'
);

INSERT INTO MEMBER VALUES (
    'M'|| seq_question.nextval, 'kim02', '1234', '김영희',
    '010-2222-2222', 'kim02', 'gmail.com',
    '0002-2222-333333', '나무야 미안해', '222-33-44444',
    '인쇄업', '김수민',
    '서울특별시', '금천구', '가산동'
);

INSERT INTO MEMBER VALUES (
    'M'|| seq_question.nextval, 'lee01', '1234', '이민수',
    '010-1111-1111', 'lee01', 'naver.com',
    '0001-1111-222222', '푸른하늘', '111-22-33333',
    '도소매업', '박지훈',
    '서울특별시', '강남구', '역삼동'
);


INSERT INTO MEMBER VALUES (
    'M'|| seq_question.nextval, 'park03', '1234', '박서연',
    '010-3333-3333', 'park03', 'gmail.com',
    '0003-3333-444444', '행복상사', '333-44-55555',
    '서비스업', '최유진',
    '서울특별시', '마포구', '서교동'
);


INSERT INTO MEMBER VALUES (
    'M'|| seq_question.nextval, 'choi04', '1234', '최준호',
    '010-4444-4444', 'choi04', 'daum.net',
    '0004-4444-555555', '준호기획', '444-55-66666',
    '광고업', '이수진',
    '부산광역시', '해운대구', '우동'
);


/* =====================================================
   2. TRADE 
   ===================================================== */

INSERT INTO TRADE VALUES (
     'T'|| seq_trade.nextval,
    '/images/trade/product01.jpg',
    '일요일까지인 식용유 팔아요',
    500000,
    '<p>일요일까지인 식용유 팝니다. 당장 오늘도 기름이 남습니다... 튀긴음식점 많은 분들께 팝니다',
   sysdate,
    12,
    'M1'
);

INSERT INTO TRADE VALUES (
    'T'|| seq_trade.nextval,
    '/images/trade/product02.jpg',
    '유통기한 얼마 안 남은 참치캔 판매합니다',
    120000,
    '<p>매장 정리하면서 남은 참치캔 판매합니다. 유통기한이 얼마 남지 않아 저렴하게 넘깁니다.</p>',
    sysdate,
    8,
    'M2'
);

INSERT INTO TRADE VALUES (
    'T'|| seq_trade.nextval,
    '/images/trade/product03.jpg',
    '업소용 밀가루 저렴하게 팔아요',
    85000,
    '<p>베이커리에서 사용하고 남은 업소용 밀가루입니다. 미개봉 제품 위주로 판매합니다.</p>',
    sysdate,
    5,
    'M3'
);

INSERT INTO TRADE VALUES (
    'T'|| seq_trade.nextval,
    '/images/trade/product04.jpg',
    '남은 치킨용 식용유 일괄 판매',
    300000,
    '<p>매장 폐업으로 남은 식용유 일괄 판매합니다. 튀김집이나 음식점 운영하시는 분께 추천드립니다.</p>',
    sysdate,
    15,
    'M4'
);

INSERT INTO TRADE VALUES (
    'T'|| seq_trade.nextval,
    '/images/trade/product05.jpg',
    '카페용 원두 재고 판매합니다',
    180000,
    '<p>카페에서 사용하려고 구매한 원두 재고입니다. 포장 상태 좋고 여러 봉지 한꺼번에 판매합니다.</p>',
    sysdate,
    10,
    'M5'
);

/* =====================================================
   3. QUESTION 
   ===================================================== */

INSERT INTO QUESTION VALUES (
      'Q'|| seq_question.nextval,
    '답변 대기',
    '여러분들은 업소용 콜라 몇개씩 발주하시나요?',
    sysdate,
    10,
    '<p>초보 사장이라 너무 어렵네요ㅠㅠ 재고관리 다들 어떤식으로 하시나요?</p>',
    'M1'
);

INSERT INTO QUESTION VALUES (
    'Q'|| seq_question.nextval,
    '답변 대기',
    '배달앱 수수료 다들 어떻게 관리하시나요?',
    sysdate,
    7,
    '<p>생각보다 수수료가 많이 나가네요ㅠㅠ 다른 사장님들은 배달앱 비용 관리 어떻게 하시는지 궁금합니다.</p>',
    'M2'
);

INSERT INTO QUESTION VALUES (
    'Q'|| seq_question.nextval,
    '답변 대기',
    '식자재 발주 주기는 보통 어느 정도인가요?',
    sysdate,
    12,
    '<p>재고가 너무 많이 남기도 하고 부족할 때도 있어서 고민입니다. 보통 며칠 단위로 발주하시나요?</p>',
    'M3'
);

INSERT INTO QUESTION VALUES (
    'Q'|| seq_question.nextval,
    '답변 완료',
    '가게 오픈 시간보다 몇 시간 전에 출근하시나요?',
    sysdate,
    18,
    '<p>오픈 준비 시간이 생각보다 오래 걸리는데 다른 사장님들은 보통 몇 시간 전에 출근하시는지 궁금해요.</p>',
    'M4'
);

INSERT INTO QUESTION VALUES (
    'Q'|| seq_question.nextval,
    '답변 대기',
    '업소용 냉장고 전기세 많이 나오나요?',
    sysdate,
    9,
    '<p>이번 달 전기세가 너무 많이 나와서 걱정입니다. 업소용 냉장고 사용하시는 분들은 전기세 어느 정도 나오시나요?</p>',
    'M5'
);

/* =====================================================
   4. ANSWER 
   ===================================================== */

INSERT INTO ANSWER VALUES (
    'A'|| seq_answer.nextval,
    '<p>안녕하세요 저는 보통 10개 남을때 하나를 시킵니다</p>',
    sysdate,
    0,
    'Q1',
    'M2'
);

INSERT INTO ANSWER VALUES (
    'A'|| seq_answer.nextval,
    '<p>저는 일주일 판매량을 기준으로 재고를 계산해서 발주하고 있습니다.</p>',
    sysdate,
    0,
    'Q2',
    'M3'
);

INSERT INTO ANSWER VALUES (
    'A'|| seq_answer.nextval,
    '<p>배달앱 수수료는 월별로 따로 정리해두면 매출 계산할 때 편합니다.</p>',
    sysdate,
    0,
    'Q3',
    'M4'
);

INSERT INTO ANSWER VALUES (
    'A'|| seq_answer.nextval,
    '<p>저는 오픈 한 시간 반 전에 출근해서 재료 준비하고 매장 정리합니다.</p>',
    sysdate,
    1,
    'Q4',
    'M5'
);

INSERT INTO ANSWER 
VALUES (
    'A'|| seq_answer.nextval,
    '<p>업소용 냉장고는 문을 자주 열지 않도록 관리하면 전기세를 조금 줄일 수 있어요.</p>',
    sysdate,
    0,
    'Q5',
    'M1'
);

/* =====================================================
   5. REPLY 
   ===================================================== */

INSERT INTO REPLY VALUES (
    'R'|| seq_reply.nextval,
    '<p>저요저요! 제발저요!</p>',
    sysdate,
    'T1',
    'M2'
);

INSERT INTO REPLY VALUES (
    'R'|| seq_reply.nextval,
    '<p>혹시 아직 판매 중이신가요? 제가 구매하고 싶습니다!</p>',
    sysdate,
    'T2',
    'M3'
);

INSERT INTO REPLY VALUES (
    'R'|| seq_reply.nextval,
    '<p>수량이 얼마나 남아있는지 알 수 있을까요?</p>',
    sysdate,
    'T3',
    'M4'
);

INSERT INTO REPLY VALUES (
    'R'|| seq_reply.nextval,
    '<p>가격 조금 조정 가능하시면 바로 거래하고 싶어요.</p>',
    sysdate,
    'T4',
    'M5'
);

INSERT INTO REPLY VALUES (
    'R'|| seq_reply.nextval,
    '<p>제가 근처인데 오늘 바로 가지러 가도 될까요?</p>',
    sysdate,
    'T5',
    'M1'
);


/* =====================================================
   6. TRADE_VIEW 
   ===================================================== */

INSERT INTO TRADE_VIEW VALUES (
   'TV'|| seq_trade_view.nextval, 
   'M2', 
   'T1'
);

INSERT INTO TRADE_VIEW VALUES (
    'TV'|| seq_trade_view.nextval,
    'M3',
    'T2'
);

INSERT INTO TRADE_VIEW VALUES (
    'TV'|| seq_trade_view.nextval,
    'M4',
    'T3'
);

INSERT INTO TRADE_VIEW VALUES (
    'TV'|| seq_trade_view.nextval,
    'M5',
    'T4'
);

INSERT INTO TRADE_VIEW VALUES (
    'TV'|| seq_trade_view.nextval,
    'M1',
    'T5'
);

/* =====================================================
   7. QUESTION_VIEW 
   ===================================================== */

INSERT INTO QUESTION_VIEW VALUES (
     'QV'|| seq_question_view.nextval, 
     'M2', 
     'Q1'
);

INSERT INTO QUESTION_VIEW VALUES (
    'QV'|| seq_question_view.nextval,
    'M3',
    'Q2'
);

INSERT INTO QUESTION_VIEW VALUES (
    'QV'|| seq_question_view.nextval,
    'M4',
    'Q3'
);

INSERT INTO QUESTION_VIEW VALUES (
    'QV'|| seq_question_view.nextval,
    'M5',
    'Q4'
);

INSERT INTO QUESTION_VIEW VALUES (
    'QV'|| seq_question_view.nextval,
    'M1',
    'Q5'
);

COMMIT;

SELECT * FROM MEMBER;
SELECT * FROM TRADE;
SELECT * FROM QUESTION;
SELECT * FROM ANSWER;
SELECT * FROM REPLY;
SELECT * FROM TRADE_VIEW;
SELECT * FROM QUESTION_VIEW;
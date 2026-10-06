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


/* ANSER → ANSWER 수정 */
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
   SEQUENCE
   ===================================================== */

CREATE SEQUENCE seq_member;
CREATE SEQUENCE seq_trade;
CREATE SEQUENCE seq_question;

/* seq_anser → seq_answer 수정 */
CREATE SEQUENCE seq_answer;

CREATE SEQUENCE seq_commment;
CREATE SEQUENCE seq_trade_view;
CREATE SEQUENCE seq_question_view;


/* =====================================================
   1. MEMBER 더미데이터 5개
   ===================================================== */

INSERT INTO MEMBER VALUES (
    '1', 'hong01', '1234', '홍사장',
    '010-1111-1111', 'hong01', 'naver.com',
    'DOC001', '홍길동상사', 'COMP001',
    '도소매업', '홍길동',
    '서울', '강남구 테헤란로 1', '101호'
);

INSERT INTO MEMBER VALUES (
    '2', 'kim02', '1234', '김대표',
    '010-2222-2222', 'kim02', 'gmail.com',
    'DOC002', '김철수무역', 'COMP002',
    '무역업', '김철수',
    '인천', '남동구 인주대로 10', '202호'
);

INSERT INTO MEMBER VALUES (
    '3', 'lee03', '1234', '이사장',
    '010-3333-3333', 'lee03', 'naver.com',
    'DOC003', '영희푸드', 'COMP003',
    '식품업', '이영희',
    '부산', '해운대구 센텀로 20', '303호'
);

INSERT INTO MEMBER VALUES (
    '4', 'park04', '1234', '박대표',
    '010-4444-4444', 'park04', 'kakao.com',
    'DOC004', '박상사', 'COMP004',
    '제조업', '박민수',
    '대전', '서구 둔산로 30', '404호'
);

INSERT INTO MEMBER VALUES (
    '5', 'choi05', '1234', '최사장',
    '010-5555-5555', 'choi05', 'gmail.com',
    'DOC005', '최유통', 'COMP005',
    '유통업', '최지우',
    '대구', '수성구 동대구로 40', '505호'
);


/* =====================================================
   2. TRADE 더미데이터 5개
   ===================================================== */

INSERT INTO TRADE VALUES (
    '1',
    '/images/trade/product01.jpg',
    '중고 노트북 판매합니다',
    500000,
    '업무용으로 사용하던 노트북입니다. 상태 좋습니다.',
    TO_DATE('2026-09-20', 'YYYY-MM-DD'),
    12,
    '1'
);

INSERT INTO TRADE VALUES (
    '2',
    '/images/trade/product02.jpg',
    '사무용 의자 대량 판매',
    80000,
    '사무실 이전으로 인해 의자를 저렴하게 판매합니다.',
    TO_DATE('2026-09-21', 'YYYY-MM-DD'),
    25,
    '2'
);

INSERT INTO TRADE VALUES (
    '3',
    '/images/trade/product03.jpg',
    '업소용 냉장고 판매',
    1200000,
    '사용기간 1년 정도 된 업소용 냉장고입니다.',
    TO_DATE('2026-09-22', 'YYYY-MM-DD'),
    34,
    '3'
);

INSERT INTO TRADE VALUES (
    '4',
    '/images/trade/product04.jpg',
    '포장 박스 1000개 판매',
    300000,
    '미사용 포장 박스입니다. 일괄 판매합니다.',
    TO_DATE('2026-09-23', 'YYYY-MM-DD'),
    18,
    '4'
);

INSERT INTO TRADE VALUES (
    '5',
    '/images/trade/product05.jpg',
    '매장용 진열대 판매',
    150000,
    '매장에서 사용하던 철제 진열대입니다.',
    TO_DATE('2026-09-24', 'YYYY-MM-DD'),
    41,
    '5'
);


/* =====================================================
   3. QUESTION 더미데이터 5개
   ===================================================== */

INSERT INTO QUESTION VALUES (
    '1',
    '답변대기',
    '사업자 등록 관련 질문',
    TO_DATE('2026-09-20', 'YYYY-MM-DD'),
    10,
    '개인사업자 등록을 처음 하는데 필요한 서류가 궁금합니다.',
    '1'
);

INSERT INTO QUESTION VALUES (
    '2',
    '답변완료',
    '세금계산서 발행 질문',
    TO_DATE('2026-09-21', 'YYYY-MM-DD'),
    21,
    '전자세금계산서는 언제까지 발행해야 하나요?',
    '2'
);

INSERT INTO QUESTION VALUES (
    '3',
    '답변대기',
    '택배 계약 관련 문의',
    TO_DATE('2026-09-22', 'YYYY-MM-DD'),
    15,
    '소규모 쇼핑몰도 택배사와 계약이 가능한가요?',
    '3'
);

INSERT INTO QUESTION VALUES (
    '4',
    '답변완료',
    '중고거래 세금 문의',
    TO_DATE('2026-09-23', 'YYYY-MM-DD'),
    31,
    '사업자가 중고물품을 판매하는 경우 세금 처리가 궁금합니다.',
    '4'
);

INSERT INTO QUESTION VALUES (
    '5',
    '답변대기',
    '사업장 주소 변경 질문',
    TO_DATE('2026-09-24', 'YYYY-MM-DD'),
    8,
    '사업장 주소 변경 시 별도 신고가 필요한가요?',
    '5'
);


/* =====================================================
   4. ANSWER 더미데이터 5개
   ===================================================== */

INSERT INTO ANSWER (
    ANSWER_NUMBER,
    CONTENTS,
    WRITE_DATE,
    SELECT_STATE,
    QUESTION_NUMBER,
    MEMBER_NUMBER
) VALUES (
    '1',
    '사업자 등록은 관할 세무서 또는 홈택스에서 신청할 수 있습니다.',
    TO_DATE('2026-09-21', 'YYYY-MM-DD'),
    0,
    '1',
    '2'
);

INSERT INTO ANSWER VALUES (
    '2',
    '일반적으로 공급일이 속하는 달의 다음 달 10일까지 발급해야 합니다.',
    TO_DATE('2026-09-22', 'YYYY-MM-DD'),
    1,
    '2',
    '3'
);

INSERT INTO ANSWER VALUES (
    '3',
    '물량이 적어도 택배사 또는 대리점과 계약할 수 있습니다.',
    TO_DATE('2026-09-23', 'YYYY-MM-DD'),
    0,
    '3',
    '4'
);

INSERT INTO ANSWER VALUES (
    '4',
    '사업과 관련하여 지속적으로 판매한다면 매출로 처리될 수 있습니다.',
    TO_DATE('2026-09-24', 'YYYY-MM-DD'),
    1,
    '4',
    '5'
);

INSERT INTO ANSWER VALUES (
    '5',
    '사업장 주소가 변경되면 사업자등록 정정 신고가 필요합니다.',
    TO_DATE('2026-09-25', 'YYYY-MM-DD'),
    0,
    '5',
    '1'
);


/* =====================================================
   5. REPLY 더미데이터 5개
   ===================================================== */

INSERT INTO REPLY VALUES (
    '1',
    '제품 아직 판매 중인가요?',
    TO_DATE('2026-09-25', 'YYYY-MM-DD'),
    '1',
    '2'
);

INSERT INTO REPLY VALUES (
    '2',
    '의자 10개만 구매 가능한가요?',
    TO_DATE('2026-09-25', 'YYYY-MM-DD'),
    '2',
    '3'
);

INSERT INTO REPLY VALUES (
    '3',
    '냉장고 크기가 어떻게 되나요?',
    TO_DATE('2026-09-26', 'YYYY-MM-DD'),
    '3',
    '4'
);

INSERT INTO REPLY VALUES (
    '4',
    '포장박스 사이즈 문의드립니다.',
    TO_DATE('2026-09-27', 'YYYY-MM-DD'),
    '4',
    '5'
);

INSERT INTO REPLY VALUES (
    '5',
    '진열대 직접 수령 가능한가요?',
    TO_DATE('2026-09-28', 'YYYY-MM-DD'),
    '5',
    '1'
);


/* =====================================================
   6. TRADE_VIEW 더미데이터 5개
   ===================================================== */

INSERT INTO TRADE_VIEW VALUES (
    '1', '2', '1'
);

INSERT INTO TRADE_VIEW VALUES (
    '2', '3', '2'
);

INSERT INTO TRADE_VIEW VALUES (
    '3', '4', '3'
);

INSERT INTO TRADE_VIEW VALUES (
    '4', '5', '4'
);

INSERT INTO TRADE_VIEW VALUES (
    '5', '1', '5'
);


/* =====================================================
   7. QUESTION_VIEW 더미데이터 5개
   ===================================================== */

INSERT INTO QUESTION_VIEW VALUES (
    '1', '2', '1'
);

INSERT INTO QUESTION_VIEW VALUES (
    '2', '3', '2'
);

INSERT INTO QUESTION_VIEW VALUES (
    '3', '4', '3'
);

INSERT INTO QUESTION_VIEW VALUES (
    '4', '5', '4'
);

INSERT INTO QUESTION_VIEW VALUES (
    '5', '1', '5'
);

COMMIT;

SELECT * FROM MEMBER;
SELECT * FROM TRADE;
SELECT * FROM QUESTION;
SELECT * FROM ANSWER;
SELECT * FROM REPLY;
SELECT * FROM TRADE_VIEW;
SELECT * FROM QUESTION_VIEW;
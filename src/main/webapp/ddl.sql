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


/* ANSER �� ANSWER ���� */
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

/* seq_anser �� seq_answer ���� */
CREATE SEQUENCE seq_answer;

CREATE SEQUENCE seq_commment;
CREATE SEQUENCE seq_trade_view;
CREATE SEQUENCE seq_question_view;


/* =====================================================
   1. MEMBER ���̵����� 5��
   ===================================================== */

INSERT INTO MEMBER VALUES (
    '1', 'hong01', '1234', 'ȫ����',
    '010-1111-1111', 'hong01', 'naver.com',
    'DOC001', 'ȫ�浿���', 'COMP001',
    '���Ҹž�', 'ȫ�浿',
    '����', '������ ������� 1', '101ȣ'
);

INSERT INTO MEMBER VALUES (
    '2', 'kim02', '1234', '���ǥ',
    '010-2222-2222', 'kim02', 'gmail.com',
    'DOC002', '��ö������', 'COMP002',
    '������', '��ö��',
    '��õ', '������ ���ִ�� 10', '202ȣ'
);

INSERT INTO MEMBER VALUES (
    '3', 'lee03', '1234', '�̻���',
    '010-3333-3333', 'lee03', 'naver.com',
    'DOC003', '����Ǫ��', 'COMP003',
    '��ǰ��', '�̿���',
    '�λ�', '�ؿ�뱸 ���ҷ� 20', '303ȣ'
);

INSERT INTO MEMBER VALUES (
    '4', 'park04', '1234', '�ڴ�ǥ',
    '010-4444-4444', 'park04', 'kakao.com',
    'DOC004', '�ڻ��', 'COMP004',
    '������', '�ڹμ�',
    '����', '���� �л�� 30', '404ȣ'
);

INSERT INTO MEMBER VALUES (
    '5', 'choi05', '1234', '�ֻ���',
    '010-5555-5555', 'choi05', 'gmail.com',
    'DOC005', '������', 'COMP005',
    '�����', '������',
    '�뱸', '������ ���뱸�� 40', '505ȣ'
);


/* =====================================================
   2. TRADE ���̵����� 5��
   ===================================================== */

INSERT INTO TRADE VALUES (
    '1',
    '/images/trade/product01.jpg',
    '�߰� ��Ʈ�� �Ǹ��մϴ�',
    500000,
    '���������� ����ϴ� ��Ʈ���Դϴ�. ���� �����ϴ�.',
    TO_DATE('2026-09-20', 'YYYY-MM-DD'),
    12,
    '1'
);

INSERT INTO TRADE VALUES (
    '2',
    '/images/trade/product02.jpg',
    '�繫�� ���� �뷮 �Ǹ�',
    80000,
    '�繫�� �������� ���� ���ڸ� �����ϰ� �Ǹ��մϴ�.',
    TO_DATE('2026-09-21', 'YYYY-MM-DD'),
    25,
    '2'
);

INSERT INTO TRADE VALUES (
    '3',
    '/images/trade/product03.jpg',
    '���ҿ� ����� �Ǹ�',
    1200000,
    '���Ⱓ 1�� ���� �� ���ҿ� ������Դϴ�.',
    TO_DATE('2026-09-22', 'YYYY-MM-DD'),
    34,
    '3'
);

INSERT INTO TRADE VALUES (
    '4',
    '/images/trade/product04.jpg',
    '���� �ڽ� 1000�� �Ǹ�',
    300000,
    '�̻�� ���� �ڽ��Դϴ�. �ϰ� �Ǹ��մϴ�.',
    TO_DATE('2026-09-23', 'YYYY-MM-DD'),
    18,
    '4'
);

INSERT INTO TRADE VALUES (
    '5',
    '/images/trade/product05.jpg',
    '����� ������ �Ǹ�',
    150000,
    '���忡�� ����ϴ� ö�� �������Դϴ�.',
    TO_DATE('2026-09-24', 'YYYY-MM-DD'),
    41,
    '5'
);


/* =====================================================
   3. QUESTION ���̵����� 5��
   ===================================================== */

INSERT INTO QUESTION VALUES (
    '1',
    '�亯���',
    '����� ��� ���� ����',
    TO_DATE('2026-09-20', 'YYYY-MM-DD'),
    10,
    '���λ���� ����� ó�� �ϴµ� �ʿ��� ������ �ñ��մϴ�.',
    '1'
);

INSERT INTO QUESTION VALUES (
    '2',
    '�亯�Ϸ�',
    '���ݰ�꼭 ���� ����',
    TO_DATE('2026-09-21', 'YYYY-MM-DD'),
    21,
    '���ڼ��ݰ�꼭�� �������� �����ؾ� �ϳ���?',
    '2'
);

INSERT INTO QUESTION VALUES (
    '3',
    '�亯���',
    '�ù� ��� ���� ����',
    TO_DATE('2026-09-22', 'YYYY-MM-DD'),
    15,
    '�ұԸ� ���θ��� �ù��� ����� �����Ѱ���?',
    '3'
);

INSERT INTO QUESTION VALUES (
    '4',
    '�亯�Ϸ�',
    '�߰�ŷ� ���� ����',
    TO_DATE('2026-09-23', 'YYYY-MM-DD'),
    31,
    '����ڰ� �߰�ǰ�� �Ǹ��ϴ� ��� ���� ó���� �ñ��մϴ�.',
    '4'
);

INSERT INTO QUESTION VALUES (
    '5',
    '�亯���',
    '����� �ּ� ���� ����',
    TO_DATE('2026-09-24', 'YYYY-MM-DD'),
    8,
    '����� �ּ� ���� �� ���� �Ű� �ʿ��Ѱ���?',
    '5'
);


/* =====================================================
   4. ANSWER ���̵����� 5��
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
    '����� ����� ���� ������ �Ǵ� Ȩ�ý����� ��û�� �� �ֽ��ϴ�.',
    TO_DATE('2026-09-21', 'YYYY-MM-DD'),
    0,
    '1',
    '2'
);

INSERT INTO ANSWER VALUES (
    '2',
    '�Ϲ������� �������� ���ϴ� ���� ���� �� 10�ϱ��� �߱��ؾ� �մϴ�.',
    TO_DATE('2026-09-22', 'YYYY-MM-DD'),
    1,
    '2',
    '3'
);

INSERT INTO ANSWER VALUES (
    '3',
    '������ ��� �ù�� �Ǵ� �븮���� ����� �� �ֽ��ϴ�.',
    TO_DATE('2026-09-23', 'YYYY-MM-DD'),
    0,
    '3',
    '4'
);

INSERT INTO ANSWER VALUES (
    '4',
    '����� �����Ͽ� ���������� �Ǹ��Ѵٸ� ����� ó���� �� �ֽ��ϴ�.',
    TO_DATE('2026-09-24', 'YYYY-MM-DD'),
    1,
    '4',
    '5'
);

INSERT INTO ANSWER VALUES (
    '5',
    '����� �ּҰ� ����Ǹ� ����ڵ�� ���� �Ű� �ʿ��մϴ�.',
    TO_DATE('2026-09-25', 'YYYY-MM-DD'),
    0,
    '5',
    '1'
);


/* =====================================================
   5. REPLY ���̵����� 5��
   ===================================================== */

INSERT INTO REPLY VALUES (
    '1',
    '��ǰ ���� �Ǹ� ���ΰ���?',
    TO_DATE('2026-09-25', 'YYYY-MM-DD'),
    '1',
    '2'
);

INSERT INTO REPLY VALUES (
    '2',
    '���� 10���� ���� �����Ѱ���?',
    TO_DATE('2026-09-25', 'YYYY-MM-DD'),
    '2',
    '3'
);

INSERT INTO REPLY VALUES (
    '3',
    '����� ũ�Ⱑ ��� �ǳ���?',
    TO_DATE('2026-09-26', 'YYYY-MM-DD'),
    '3',
    '4'
);

INSERT INTO REPLY VALUES (
    '4',
    '����ڽ� ������ ���ǵ帳�ϴ�.',
    TO_DATE('2026-09-27', 'YYYY-MM-DD'),
    '4',
    '5'
);

INSERT INTO REPLY VALUES (
    '5',
    '������ ���� ���� �����Ѱ���?',
    TO_DATE('2026-09-28', 'YYYY-MM-DD'),
    '5',
    '1'
);


/* =====================================================
   6. TRADE_VIEW ���̵����� 5��
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
   7. QUESTION_VIEW ���̵����� 5��
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
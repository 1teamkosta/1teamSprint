--질문 게시글 추가
insert into question(QUESTION_NUMBER,STATEMENT,TITLE,WRITE_DATE,VIEW_COUNT,CONTENT,MEMBER_NUMBER)
VALUES ('Q'|| seq_question.nextval,'답변대기','사업자 등록 관련 질문',sysdate,10,'<p>개인사업자 등록을 처음 하는데 필요한 서류가 궁금합니다.</p>','1');

select*from question;

--질문 답변 등록
insert into ANSWER( ANSWER_NUMBER,CONTENTS,WRITE_DATE,SELECT_STATE,QUESTION_NUMBER,MEMBER_NUMBER)
VALUES ('A'|| seq_answer.nextval,'<p>알려주기싫어요</p>',sysdate, 1,'Q1','1');

select*from ANSWER;

--거래 게시글 추가
insert into TRADE(TRADE_NUMBER,MAIN_IMAGE,TITLE,PRICE,CONTENT,WRITE_DATE,VIEW_COUNT, MEMBER_NUMBER)
values ('T' || seq_trade.nextval, 
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmK-RvpUjSiX3rCJ_t8C1fIGaTuyMCU6t_sf_4SBmbHD_KZg7Q77G1HuE&s',
'소품용 폼폼푸린 인형 팝니다',50000,'<p>가게에서 소품으로 썼던 인형 중고로 팝니다. 상태좋습니다.</p>',sysdate, 2,'1');

select*from TRADE;

-- 거래게시판 댓글추가
insert into REPLY(REPLY_NUMBER,CONTENT,WRITE_DATE,TRADE_NUMBER,MEMBER_NUMBER)
values ('R'|| seq_reply.nextval, '<p>저요저요!<\p>', sysdate, 'T1','1');

select*from REPLY;

--================================================================

-- 거래게시판 조회수 처리
-- >> 조회 테이블의 회원수가 하나가 늘어날때마다 조회수는 늘어난다.

-- ㄴ> 조회한 회원의 수를 체크
select count(tv.member_number) from TRADE_VIEW tv;
-- ㄴ> 특정 게시글의 조회수가 증감
update TRADE t
set t.view_count =t.view_count+1
where t.TRADE_NUMBER = '1';

-- !! count(member_number)> view_count 라면, 특정 게시글의 조회수가 증감해야한다.!!
UPDATE TRADE t
SET t.view_count =
    CASE
        WHEN (
            SELECT COUNT(tv.member_number)
            FROM TRADE_VIEW tv
        ) >= t.view_count
        THEN t.view_count + 1
        ELSE t.view_count
    END
WHERE t.TRADE_NUMBER = '1';

--================================================================
--qna 게시판 조회수 처리
UPDATE question q
SET q.view_count =
    CASE
        WHEN (
            SELECT COUNT(qv.member_number)
            FROM question_view qv
        ) >= q.view_count
        THEN q.view_count + 1
        ELSE q.view_count
    END
WHERE q.question_NUMBER = '1';

--================================================================

select*from question;
select*from question_view;

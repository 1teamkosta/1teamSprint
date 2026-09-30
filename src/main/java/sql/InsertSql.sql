--질문 게시글 추가
insert into question(QUESTION_NUMBER,STATEMENT,TITLE,WRITE_DATE,VIEW_COUNT,CONTENT,MEMBER_NUMBER)
VALUES ('Q'|| seq_question.nextval,'답변대기','사업자 등록 관련 질문',sysdate,10,'<p>개인사업자 등록을 처음 하는데 필요한 서류가 궁금합니다.</p>','1');

select*from question;

--답변등록

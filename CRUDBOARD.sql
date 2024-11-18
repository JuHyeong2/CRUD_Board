---- system 계정으로
--ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
--
--CREATE USER CRUDBOARD IDENTIFIED BY CRUDBOARD;
--GRANT RESOURCE, CONNECT TO CRUDBOARD;
--ALTER USER CRUDBOARD DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

-- 사용자 계정으로
DROP TABLE USER_TB CASCADE CONSTRAINT;
DROP TABLE BOARD_TB CASCADE CONSTRAINT;
DROP TABLE COMMENT_TB CASCADE CONSTRAINT;

CREATE TABLE USER_TB (
    USER_NAME VARCHAR2(20) NOT NULL,
    USER_ID VARCHAR2(20) PRIMARY KEY,
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_PHONE VARCHAR2(20),
    USER_EMAIL VARCHAR2(40),
    USER_DATE DATE DEFAULT SYSDATE,
    ADDRESS VARCHAR2(50)
);

COMMENT ON COLUMN USER_TB.USER_NAME IS '회원 이름';
COMMENT ON COLUMN USER_TB.USER_ID IS '회원 아이디';
COMMENT ON COLUMN USER_TB.USER_PWD IS '회원 비밀번호';
COMMENT ON COLUMN USER_TB.USER_PHONE IS '회원 전화번호';
COMMENT ON COLUMN USER_TB.USER_EMAIL IS '회원 이메일';
COMMENT ON COLUMN USER_TB.USER_DATE IS '회원 가입 일자';
COMMENT ON COLUMN USER_TB.ADDRESS IS '회원 주소';

INSERT INTO USER_TB VALUES('장지용', 'qhem1', 'qwer1', '010-2323-4434', 'jiyong@gmail.com', '2017-10-02', '서울시 마포구');
INSERT INTO USER_TB VALUES('다니엘', 'qhem2', 'qwer2', '010-5834-6231', 'niel@gmail.com', '2017-11-22', '서울시 강남구');
INSERT INTO USER_TB VALUES('안지훈', 'qhem3', 'qwer3', '010-2142-3245', 'jihoon@gmail.com', '2018-08-30', '서울시 중구');
INSERT INTO USER_TB VALUES('한정현', 'qhem4', 'qwer4', '010-2314-2353', 'junghyun@gmail.com', '2019-04-06', '서울시 노원구');
INSERT INTO USER_TB VALUES('김도현', 'qhem5', 'qwer5', '010-2453-4564', 'dohyun@gmail.com', '2020-05-10', '서울시 영등포구');

------------------------------------------------------

DROP SEQUENCE SEQ_BOARDNO;

CREATE SEQUENCE SEQ_BOARDNO;

CREATE TABLE BOARD_TB (
    BOARD_NO INT PRIMARY KEY,
    BOARD_TITLE VARCHAR2(30) NOT NULL,
    BOARD_DETAIL CLOB,
    BOARD_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    USER_ID VARCHAR2(20) NOT NULL,
    BOARD_VIEW INT,
    CONSTRAINT FK_BD FOREIGN KEY (USER_ID) REFERENCES USER_TB(USER_ID) ON DELETE CASCADE
);

COMMENT ON COLUMN BOARD_TB.BOARD_NO IS '게시글 번호';
COMMENT ON COLUMN BOARD_TB.BOARD_TITLE IS '게시글 제목';
COMMENT ON COLUMN BOARD_TB.BOARD_DETAIL IS '게시글 내용';
COMMENT ON COLUMN BOARD_TB.BOARD_TIME IS '게시글 작성 시간';
COMMENT ON COLUMN BOARD_TB.USER_ID IS '게시한 회원 아이디';
COMMENT ON COLUMN BOARD_TB.BOARD_VIEW IS '게시글 조회수';

INSERT INTO BOARD_TB VALUES(SEQ_BOARDNO.NEXTVAL, '테스트', '테스트입니다', DEFAULT, 'qhem1', 1);

------------------------------------------------------

DROP SEQUENCE SEQ_COMMENTNO;

CREATE SEQUENCE SEQ_COMMENTNO;

CREATE TABLE COMMENT_TB (
    COMMENT_NO INT PRIMARY KEY,
    USER_ID VARCHAR2(20) NOT NULL,
    BOARD_NO INT NOT NULL,
    COMMENT_DETAIL CLOB NOT NULL,
    COMMENT_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT FK_CB_USER FOREIGN KEY (USER_ID) REFERENCES USER_TB(USER_ID) ON DELETE CASCADE,
   CONSTRAINT FK_CB_BOARD FOREIGN KEY (BOARD_NO) REFERENCES BOARD_TB(BOARD_NO) ON DELETE CASCADE
);

COMMENT ON COLUMN COMMENT_TB.COMMENT_NO IS '댓글 번호';
COMMENT ON COLUMN COMMENT_TB.USER_ID IS '댓글 작성한 회원 아이디';
COMMENT ON COLUMN COMMENT_TB.BOARD_NO IS '댓글 작성된 게시판';
COMMENT ON COLUMN COMMENT_TB.COMMENT_DETAIL IS '댓글 내용';
COMMENT ON COLUMN COMMENT_TB.COMMENT_TIME IS '댓글 작성 시간';

INSERT INTO COMMENT_TB VALUES(SEQ_COMMENTNO.NEXTVAL, 'qhem2', 1, '댓글 내용입니다.', DEFAULT);

commit;

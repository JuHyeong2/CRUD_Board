# CRUD Board Project
KH 정보교육원 팀프로젝트
Collaborator : 이주형, 권태혁, 손동준, 박성훈
FrontEnd : 이주형
BackEnd : 권태혁, 손동준, 박성훈
## Project description
<b>✔ 프로젝트 명 :</b> CRUD Board </br>
<b>✔ 목적 :</b> 초보 개발자로서 CRUD기능이 있는 게시판을 A-Z까지 만들어보자. </br>
<b>✔ 사용된 기술 :</b> SpringBoot, Oracle DB, React, HTML, CSS, Mybatis 

## Getting Started
### 개발환경
```
- Window 10, 11
- oracle 19c
- oracle SQL Developer
- JDK 21.0.4
- 계속 수정될 예정
```
### CRUD Board ERD

![erd_최종2](https://github.com/user-attachments/assets/bed9449d-2482-4220-a291-d70f912770ff)

---

### CRUD Board Create SQL
1. User 테이블 생성
```
CREATE TABLE USER_TB (
    USER_NAME VARCHAR2(20) NOT NULL,
    USER_ID VARCHAR2(20) PRIMARY KEY,
    USER_PHONE VARCHAR2(20),
    USER_PWD VARCHAR2(20) NOT NULL,
    USER_EMAIL VARCHAR2(40),
    USER_DATE TIMESTAMP,
    ADDRESS VARCHAR2(20)
);
```
2. 게시물 테이블 생성
```
CREATE TABLE BOARD (
    BOARD_NO INT PRIMARY KEY,
    BOARD_TITLE VARCHAR2(30) NOT NULL,
    BOARD_DETAIL CLOB,
    BOARD_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    USER_ID VARCHAR2(20) NOT NULL,
    BOARD_VIEW INT(6),
    CONSTRAINT FK_BD FOREIGN KEY (USER_ID) REFERENCES USER_TB(USER_ID) ON DELETE CASCADE
);
```
3. 댓글 테이블 생성
```
CREATE TABLE COMMENT_TB (
    COMMENT_ID INT PRIMARY KEY,
    USER_ID VARCHAR2(20) NOT NULL,
    BOARD_NO INT NOT NULL,
    COMMENT_DETAIL CLOB NOT NULL,
    COMMENT_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT FK_CB_USER FOREIGN KEY (USER_ID) REFERENCES USER_TB(USER_ID) ON DELETE CASCADE,
   CONSTRAINT FK_CB_BOARD FOREIGN KEY (BOARD_NO) REFERENCES BOARD(BOARD_NO) ON DELETE CASCADE
);
```

CREATE TABLE MVC_BOARD(
BID NUMBER(4) PRIMARY KEY,
BNAME VARCHAR2(20),
BTITLE VARCHAR2(100),
BCONTENT VARCHAR2(300),
BDATE DATE DEFAULT SYSDATE,
BHIT NUMBER(4) DEFAULT 0,
BGROUP NUMBER(4),
BSTEP NUMBER(4),
BINDENT NUMBER(4)
);

COMMIT;

CREATE SEQUENCE MVC_BOARD_SEQ NOCACHE;

COMMIT;

INSERT INTO mvc_board(BID, BNAME, BTITLE, BCONTENT, BHIT, BGROUP, BSTEP, BINDENT) VALUES(MVC_BOARD_SEQ.NEXTVAL, 'KJH', '게시판을 만들어보아요', '재미있는 게시판 만들기 놀이~~~!', 0, MVC_BOARD_SEQ.CURRVAL, 0, 0);

COMMIT;

create table ticket(
consumerId varchar2(20),
countnum number(4),
constraint countnum_check check (countnum between 1 and 4)
);

commit;

create table card(
consumerId varchar2(20),
amount number(4)
);

commit;

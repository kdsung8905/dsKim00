create sequence seq_board_bno;

create table tbl_board(
boardIdx NUMBER,
title varchar2(300) not null,
content varchar2(3000) not null,
creatorId varchar2(50) not null,
hitCnt NUMBER DEFAULT '0',
regDate DATE DEFAULT sysdate, 
updateDate DATE DEFAULT sysdate 
);

comment on table tbl_board is '게시판테이블';

comment on column tbl_board.board_idx is '글번호';
comment on column tbl_board.title is '글제목';
comment on column tbl_board.content is '글내용';
comment on column tbl_board.creator_id is '작성자';
comment on column tbl_board.hit_cnt is '조회수';
comment on column tbl_board.created_datetime is '생성시간';
comment on column tbl_board.updated_datetime is '수정시간';
comment on column tbl_board.deleted_yn is '삭제여부';

select * from tbl_board;

//drop table tbl_board;

insert into tbl_board (boardIdx,title, content,creatorId,regDate) values (seq_board_bno.nextval, '메가커피4','자몽에이드', 'ad1m1in1', sysdate);
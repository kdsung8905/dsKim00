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

comment on table tbl_board is '�Խ������̺�';

comment on column tbl_board.board_idx is '�۹�ȣ';
comment on column tbl_board.title is '������';
comment on column tbl_board.content is '�۳���';
comment on column tbl_board.creator_id is '�ۼ���';
comment on column tbl_board.hit_cnt is '��ȸ��';
comment on column tbl_board.created_datetime is '�����ð�';
comment on column tbl_board.updated_datetime is '�����ð�';
comment on column tbl_board.deleted_yn is '��������';

select * from tbl_board order by boardIdx desc;

//drop table tbl_board;

insert into tbl_board (boardIdx,title, content,creatorId,regDate) values (seq_board_bno.nextval, '�ް�Ŀ��4','�ڸ����̵�', 'ad1m1in1', sysdate);


create sequence seq_file_idx;

//drop table tbl_file;

create table tbl_file(
fileIdx number,
boardIdx number,
originalFileName varchar2(500) not null,
storeFilePath varchar2(500) not null,
fileSize number not null,
creatorId varchar2(50) not null,
regDate DATE default sysdate,
updateDate DATE default sysdate
)

select * from tbl_file;

insert into tbl_file(fileIdx, boardIdx, originalFileName, storeFilePath, fileSize, creatorId, regDate) values (seq_file_idx.nextval, 63, 'originalFileName', 'storeFilePath', 1010, 'ad1m1in1', sysdate);
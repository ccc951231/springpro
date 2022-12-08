create table myboard(
	idx int not null auto_increment, -- 자동증가컬럼
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(), -- 현재시간 날짜정보 함수
	count int default 0, -- 조회수 기본 0
	primary key(idx)
);

insert into myboard(title,content,writer)
values('게시판 연습','게시판 연습','관리자');
insert into myboard(title,content,writer)
values('게시판 연습','게시판 연습','박매일');
insert into myboard(title,content,writer)
values('게시판 연습','게시판 연습','선생님');

select * from myboard order by idx desc;
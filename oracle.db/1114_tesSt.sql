--DB정규화
--한마디로 DB서버의 메모리를 낭비하지 않기 위해서 어떤 테이블을 식별자를 가지는 여러개의 테이블로
--나누는 과정을 정규화
--정규화된 데이터베이스를 중복이 최소화되도록 설계된 DB

--on delete cascade: 외부키로 연결이 되어있어도 부모테이블의 데이터를 삭제하면 
--자식테이블의 데이터까지도 자동 삭제된다.

--첫번째 DB정규화
--시퀀스를 만들고 shop테이블, cart테이블 만들어 조회


--시퀀스
create sequence seq_shop;
--shop 테이블(num:기본키, 상품명, 가격, 제조회사)
create table shop(num number(5) primary key, sangpum varchar2(20), price varchar2(20), company varchar2(20));
--shop테이블에 최소 5개 추가
insert into shop values(seq_shop.nextval,'아이폰','2890000','애플'); 
insert into shop values(seq_shop.nextval,'갤럭시','2599000','삼성'); 
insert into shop values(seq_shop.nextval,'헤드셋','129000','소니'); 
insert into shop values(seq_shop.nextval,'스위치','189000','닌텐도'); 
insert into shop values(seq_shop.nextval,'워치','325000','애플'); 
--cart 테이블(주문번호:기본키, shop의 num:외부키, 갯수, 구입날짜)
create table cart1(idx number(5) primary key, num number(5) constraint cart_fk_num REFERENCES shop(num), cnt number(10), day date);
--cart2 on delete cascade
create table cart2(idx number(5) primary key, num number(5) constraint cart_fk2_num REFERENCES shop(num) on delete cascade, cnt number(10), day date);
--cart1에 상품추가, 1번상품 담기
insert into cart1 values(seq_shop.nextval, 1, 2, sysdate);--1번 상품 추가
insert into cart1 values(seq_shop.nextval, 4, 1, sysdate);
--shop에 없는상품 담아보기
insert into cart1 values(seq_shop.nextval, 6, 1, sysdate);
--cart2에 상품추가, 3번2개 / 4번 3개
insert into cart2 values(seq_shop.nextval, 3,2,sysdate);
insert into cart2 values(seq_shop.nextval, 4,3,sysdate);
--부모테이블의 1번 상품 삭제
delete from shop where num=1; --무결성 제약조건 자식 레코드가 발견되었습니다. 오류 발생
delete from shop where num=5; --5는 카트에 담기기 전이라 삭제 가능
delete from shop where num=3; --cart2에 담긴 제품은 on delete cascade를 했기에 삭제가 가능하다.
--join
--cart2에 데이터 더 추가
insert into cart2 values(seq_shop.nextval, 5,2, sysdate);
insert into cart2 values(seq_shop.nextval, 1, 1, sysdate);
insert into cart2 values(seq_shop.nextval, 2, 2, sysdate);
--cart1에 담긴 상품을 shop과 join해서 자세히 출력
--주문번호 상품번호 상품명 가격 주문갯수 구입날짜
select cart1.idx 상품번호, shop.sangpum 상품명, shop.price 가격, cart1.cnt 수량, cart1.day 구입날짜 from shop, cart1 where shop.num=cart1.num;
select idx  상품번호, sangpum 상품명, price 가격, cnt 수량, day 구입날짜 from shop s, cart2 c where s.num=c.num;


--두번째 테이블은 게시판에 원글을 작성시 댓글을 남기는 경우를 예상해서 작성
--시퀀스(seq_board):원글 댓글 모두 사용
create sequence seq_board;
--원글 : board(기본키, 작성자, 제목, 작성일자)
create table board(bno number(5) CONSTRAINT board_pk_bno primary key,writer varchar2(20), subject varchar2(100), writeday date); 
--5개 이상 데이터 insert
insert into board values(seq_board.nextval, '박성진' , 'easy', '24-11-05');
insert into board values(seq_board.nextval, '강영현' , 'let it be summer', '23-09-04');
insert into board values(seq_board.nextval, '김원필' , '행운을 빌어 줘', '22-02-07');
insert into board values(seq_board.nextval, '윤도운' , '문득', '21-09-27');
insert into board values(seq_board.nextval, 'Day6' , '어떻게 말해', '17-03-06');
--시퀀스 변경
insert into board values(seq_shop.nextval, '박재형', 'eaj', sysdate);
--댓글 테이블 answer_bno를 외부키로 설정
--부모글을 지우면 그글에 달린 댓글도 자동삭제
create table answer(ano number(5) CONSTRAINT answer_pk_ano primary key, bno number(5) REFERENCES board(bno) on delete cascade, nickname varchar2(20), content varchar2(100), writeday date);
--3개 이상 데이터 insert
insert into answer values(seq_board.nextval, 1, '빵댕', '가사에 공감', sysdate);
insert into answer values(seq_board.nextval, 1, '방심', '가을과 어울리는 글', sysdate);
insert into answer values(seq_board.nextval, 2, '0k', '제목부터 여름이야', sysdate);
insert into answer values(seq_board.nextval, 2, 'K0H', '락밴드가 잘 어울리는 목소리', sysdate);
insert into answer values(seq_board.nextval, 2, '케', '너무 좋아요', sysdate);
insert into answer values(seq_board.nextval, 5, '아라여', '쓰레기가사', sysdate);
--시퀀스 변경해서 행추가했어도 댓글 달 수 있음
insert into answer values(seq_board.nextval, 21, 'jea', '돌아와', sysdate);
--join
--글번호, 작성자, 제목, 댓글자, 댓글 내용, 원글작성날짜, 댓글작성날짜
select b.bno 글번호, writer 작성자, subject 제목, nickname 닉네임, content 댓글내용, b.writeday 원글작성날짜, a.writeday 댓글작성날짜 from board b, answer a
where b.bno=a.bno;

--drop table board;--외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다
--자식테이블 먼저 지우기
drop table answer;--자식테이블 먼저 지운후
drop table board;--테이블 삭제 가능하다.


--[조언, 외부키 문제]
--시퀀스 : seq_4 이용해서 기본키에 활용
create SEQUENCE seq_4;
--테이블: foodshop
create table foodshop(fno number(5) primary key, foodname varchar2(20), foodprice number(20), shopname varchar2(30), shoploc varchar2(20));
alter table foodshop modify foodname varchar2(50);
alter table foodshop modify shoploc varchar2(50);
--insert 10개 추가
insert into foodshop values(seq_4.nextval, '로제찜닭', 28000, '두찜', '경기도수원시');
insert into foodshop values(seq_4.nextval, '무뼈국물닭발', 19000, '두리닭발', '서울특별시 사당');
insert into foodshop values(seq_4.nextval, '뿌링클콤보', 23000, 'BHC', '경기도 김포시');
insert into foodshop values(seq_4.nextval, '두바이찹쌀떡', 7800, '한정선', '서울특별시 성수');
insert into foodshop values(seq_4.nextval, '카카오 크룰러', 3200, '아임도넛', '서울특별시 성수');
insert into foodshop values(seq_4.nextval, '딸기피넛버터샌드위치', 9800, '앤드밀', '서울특별시 성수');
insert into foodshop values(seq_4.nextval, '크림새우', 11000, '피슈마라홍탕', '서울특별시 광진구');
insert into foodshop values(seq_4.nextval, '로제떡볶이', 7500, '신전떡볶이', '대구광역시');
insert into foodshop values(seq_4.nextval, '팥붕어빵', 1000, '잉어왕', '경기도 김포시');
insert into foodshop values(seq_4.nextval, '얼른순대국(고기만)', 9500, '도담순대국', '서울특별시 광진구');
--테이블:orderapp
--기본키(onum:seq_4), clientname, fno, clientaddr
create table orderapp(onum number(5) primary key, clientname varchar2(20), fno number(5) REFERENCES foodshop(fno) on delete cascade, clientaddr varchar2(50));
insert into orderapp values (seq_4.nextval, '박성진', 11, '서울특별시 송파구');
insert into orderapp values (seq_4.nextval, '강영현', 11, '서울특별시 잠실');
insert into orderapp values (seq_4.nextval, '김원필', 7, '서울특별시 성수');
insert into orderapp values (seq_4.nextval, '윤도운', 10, '경기도 김포시');
insert into orderapp values (seq_4.nextval, '김민지', 5, '서울특별시 성수');
insert into orderapp values (seq_4.nextval, '영케이', 3, '쌍용교육센터 사당');
insert into orderapp values (seq_4.nextval, '전현무', 4, '00아파트 김포풍무');
insert into orderapp values (seq_4.nextval, '김기범', 5, '서울숲');
insert into orderapp values (seq_4.nextval, '박나래', 6, 'aaa 스튜디오 성수점');
insert into orderapp values (seq_4.nextval, '최민호', 7, 'dd오피스텔 어린이대공원점');
insert into orderapp values (seq_4.nextval, '이이정', 9, '대구대학교');
update orderapp set clientname='김연아' where onum=12;
update orderapp set clientname='손흥민' where onum=13;
update orderapp set clientname='이상화' where onum=14;
update orderapp set clientname='강남' where onum=15;
--최종출력(주문자 이름의 오름차순으로 출력)
--주문번호  주문자성함  음식명  음식가격  가게상호명  가게위치  주문자주소

select o.onum 주문번호, clientname 주문자성함, foodname 음식명, foodprice 가격, shopname 상호명, shoploc 가게위치, clientaddr 주문자주소 from foodshop f, orderapp o
where f.fno=o.fno order by clientname asc;




select * from foodshop;
select * from orderapp;
rollback;
commit;
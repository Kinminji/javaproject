create table MyCarrot(cnum number(5) primary key, csangpum varchar2(20), cprice number(30), cscore number(30), caddr varchar2(50));

insert into MyCarrot values(seq_shop.nextval, '기계식 키보드', 50000, 2, '강남구 역삼동');
insert into MyCarrot values(seq_shop.nextval, '앨범', 35000, 5, '강남구 대치4동');
insert into MyCarrot values(seq_shop.nextval, '인형 키링', 7000, 1, '서울특별시 서초구');
insert into MyCarrot values(seq_shop.nextval, '패딩 토트백', 29000, 6, '개포4동');
insert into MyCarrot values(seq_shop.nextval, '딥디크 향수', 155000, 43, '강남구 개포동');
insert into MyCarrot values(seq_shop.nextval, 'LP판 ', 48000, 7, '성동구 옥수동');
insert into MyCarrot values(seq_shop.nextval, '스탠리 텀블러', 20000, 0, '강남구 청담동');
insert into MyCarrot values(seq_shop.nextval, '요시다 포터', 250000, 13, '성동구 성수동');
insert into MyCarrot values(seq_shop.nextval, '도서상품권', 9000, 1, '광진구 자양동');
insert into MyCarrot values(seq_shop.nextval, '콘서트 티켓', 200000, 10, '강남구 압구정동');

commit;


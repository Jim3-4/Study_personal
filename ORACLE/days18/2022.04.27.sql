트리거 
방아쇠->자동->총알 
어떤 작업 전 또는 후  트리거에 정의한 로직을 실행하는 PL/SQL 의 한 종류 
대상(테이블)에 미리 트리거를 지정하면 
어떤 이벤트(DML)이 발생할떄 자동을 ㅗ지정된 트리거가 작동하도록 한 객체

입고테이블 (대상) 
PK
101 LG냉장고 2022.04.27  insert(dml) 실행 

재고테이블 (자동으로 재고수량을 수정하는 트리거 ) 
lg냉장고 120+10=130  update(dml) 실행 

5.트리거 키워드(예약어) 
ㄱ.작업 전에 자동 처리되는 트리거: before 트리거 
ㄴ.작업 후에 자동 처리되는 트리거 : after 트리거 
ㄷ.for each row : 행 마다 처리되는 트리거 (행 트리거) 
ㄹ. referencing 영향받은 행의 값을 참조 
ㅁ.old 참조 전 열(칼럼)의 값
ㅂ.new 참조 후 열(칼럼)의 값 

【형식】 
	CREATE [OR REPLACE] TRIGGER 트리거명 [BEFORE ? AFTER]
	  trigger_event ON 테이블명
	  [FOR EACH ROW [WHEN TRIGGER 조건]]
	DECLARE
	  선언문
	BEGIN
	  PL/SQL 코드
	END;


트리거 확인 

select *
from user_triggers;

CREATE TABLE tbl_trigger1(
   id NUMBER PRIMARY KEY
   , name VARCHAR2(20)
);
-- Table TBL_TRIGGER1이(가) 생성되었습니다.
CREATE TABLE tbl_trigger2(
  memo VARCHAR2(100)
  , ilja DATE DEFAULT SYSDATE
);
--Table TBL_TRIGGER2이(가) 생성되었습니다.

create or replace trigger ut_exam01 after 
insert on tbl_trigger1  --대상테이블에 insert작업이 일어난 후에 
--for each row  --트리거가 발생되는 갯수가 몇개인지, 한번만 or 발생할때마다 
--declare --변수선언
begin
    insert into tbl_trigger2 (memo) values ('tbl_trigger1 테이블 추가'); 
    --트리거는 자동으로 커밋, 롤백 된다. 
--exception
end; 
 
select * from tbl_trigger1;
select * from tbl_trigger2;

drop trigger ut_exam01;  --트리거에 빨간 x 표시가 나타나서 삭제했다가 다시 만듬 

insert into tbl_trigger1 values (1,'admin');
commit;
--ORA-00001: unique constraint (SCOTT.SYS_C007183) violate
--(유일성) 에러가 발생하면 트리거2에 들어가지 않는다. 
insert into tbl_trigger1 values (1,'hong');

insert into tbl_trigger1 values (2,'hong');

rollback; 


--dml
update tbl_trigger1
set name = 'kim'
where id=2;

delete from tbl_trigger1
where id=2;

--update, delete 에도 트리거를 발생시키고 싶다면? 
create or replace trigger ut_exam01 after 
update on tbl_trigger1  --대상테이블에 insert작업이 일어난 후에 
--for each row  --트리거가 발생되는 갯수가 몇개인지, 한번만 or 발생할때마다 
--declare --변수선언
begin
    insert into tbl_trigger2 (memo) values ('tbl_trigger1 테이블 추가'); 
    --트리거는 자동으로 커밋, 롤백 된다. 
--exception
end; 


create or replace trigger ut_exam01 after 
delete  on tbl_trigger1  --대상테이블에 insert작업이 일어난 후에 
--for each row  --트리거가 발생되는 갯수가 몇개인지, 한번만 or 발생할때마다 
--declare --변수선언
begin
    insert into tbl_trigger2 (memo) values ('tbl_trigger1 테이블 추가'); 
    --트리거는 자동으로 커밋, 롤백 된다. 
--exception
end; 


--이렇게 만들어도 되지만 or 연산자로 연결해서 한번에 선언할 수 있다 .

create or replace trigger ut_exam01 after 
insert or update or delete on tbl_trigger1  --대상테이블에 insert작업이 일어난 후에 
--for each row  --트리거가 발생되는 갯수가 몇개인지, 한번만 or 발생할때마다 
--declare --변수선언
begin
    if inserting then --insert 발생 
    insert into tbl_trigger2 (memo) values ('tbl_trigger1 테이블 추가'); 
    elsif updating then --update 발생
    insert into tbl_trigger2 (memo) values ('tbl_trigger1 테이블 수정'); 
    elsif deleting then  --delete 발생 
    insert into tbl_trigger2 (memo) values ('tbl_trigger1 테이블 삭제'); 
    --트리거는 자동으로 커밋, 롤백 된다. 
    end if;
--exception
end; 

--tbl_trigger1테이블에 근무시간이 아닐때 주말일때는 insert update delete 하면 에러 

--삽입되기 전에 근무/주말인지 체크 후에 삽입 
insert into tbl_trigger1 values (1,'hong');

create or replace trigger ut_exam02 before 
insert or update or delete on tbl_trigger1  --대상테이블에 insert작업이 일어난 후에 
--for each row  --트리거가 발생되는 갯수가 몇개인지, 한번만 or 발생할때마다 
--declare --변수선언
begin
 --근무시간 x or 주말 에러발생 ->u, d,i  (dml)도 취소 
    if  not(to_char(sysdate, 'hh24') between 12 and 18
    or to_char(sysdate, 'dy') in ('토','일')) then  
        --에러발생, (에러코드, 에러메세지) 
        --에러코드번호는 임의로 주면된다.
        raise_application_error(-20000, '지금은 근무시간 외 또는 주말이기에 작업이 안됩니다. ' );
    end if;
--exception
end; 

select sysdate,to_char(sysdate, 'hh24')
    ,to_char(sysdate, 'dy') 
from dual; 

create table tbl_trg1
(
    hak varchar2(10) primary key
  , name varchar2(20)
  , kor number(3)
  , eng number(3)
  , mat number(3)
);
-- Table TBL_TRG1이(가) 생성되었습니다.
create table tbl_trg2
(
  hak varchar2(10) primary key
  , tot number(3)
  , avg number(5,2)
  , constraint fk_test2_hak foreign key(hak)   references tbl_trg1(hak)
);
-- Table TBL_TRG2이(가) 생성되었습니다.

-- 예) 한 학생의 학,이,국,영,수 -> tbl_trg1 에 INSERT
--     자동으로
--     tbl_trg2 테이블에 tot,avg INSERT 되는 트리거 생성 -> 테스트
INSERT INTO tbl_trg1 ( hak, name, kor, eng, mat ) VALUES ( 1, 'hong', 90,78, 99 );


--insert가 된후에 총점 평균 계산하기 때문에 
create or replace trigger ut_trg1DML after 
insert on tbl_trg1
for each row --행 트리거 필수!!
declare
    vtot number(3);
    vavg number(5,2);
begin
    vtot :=  :NEW.kor +:NEW.eng+ :NEW.mat;
    vavg := vtot / 3;
    insert into tbl_trg2 (hak,tot,avg )values (:NEW.hak, vtot, vavg);
  
--exception
end;

INSERT INTO tbl_trg1 ( hak, name, kor, eng, mat ) VALUES ( 1, 'hong', 90,78, 99 );

select *
from tbl_trg2;

select * from tbl_trg1;
select * from tbl_trg2;

학생의 성적을 수정 (update) 하면 자동으로 tbl_trg2 테이블의 총점, 평균 수정 




원래값은 :old
update 되는 새로운 값은 :new 


create or replace trigger ut_trg1DML after 
insert on tbl_trg1
for each row --행 트리거 필수!!
declare
    vtot number(3);
    vavg number(5,2);
begin
    vtot :=  :NEW.kor +:NEW.eng+ :NEW.mat; --새로운 값들 
    vavg := vtot / 3;
    if inserting then
        insert into tbl_trg2 (hak,tot,avg )values (:NEW.hak, vtot, vavg);
    elsif updating then
        update tbl_trg2
        set tot=vtot, avg=vavg
        where hak= :new.hak; --:old.hak 도 가능 학번은 바뀌지 않았기 때문 
    end if;
--exception
end;

update tbl_trg1
set kor=87, eng=67, mat=100
where hak=1;

select *
from tbl_trg1;

select *
from tbl_trg2;

tbl_trg1 테이블에 학번 1인 학생을 삭제를 하면 자동으로 tbl_Trg2 자동으로 
create or replace trigger ut_trg1DML after 
insert on tbl_trg1
for each row --행 트리거 필수!!
declare
    vtot number(3);
    vavg number(5,2);
begin
    vtot :=  :NEW.kor +:NEW.eng+ :NEW.mat; --새로운 값들 
    vavg := vtot / 3;
    if inserting then
        insert into tbl_trg2 (hak,tot,avg )values (:NEW.hak, vtot, vavg);
    elsif updating then
        update tbl_trg2
        set tot=vtot, avg=vavg
        where hak= :new.hak; --:old.hak 도 가능 학번은 바뀌지 않았기 때문 
    elsif deleting then
        delete tbl_trg2
        where hak = :old.hak;
    end if;
--exception
end;

Trigger UT_TRG1DML이(가) 컴파일되었습니다.

delete from tbl_trg1
where hak=1;

커서 + 파라미터를 이용하는 방법 

create or replace procedure up_seldeptEmp
(
    pdeptno dept.deptno%type
    
)
is
    vename emp.ename%type;
    vsal emp.sal%type;
--명시적커서 - open loop~fetch close 
    cursor cemplist(cdeptno dept.deptno%type) is ( select ename, sal from emp where deptno=cdeptno; --파라미터로 들어오는 부서번호 ) 
begin
--처음 pdeptno가 들어오고, 그것을 cemplist에 전달하니 
--cursor에서 cdpetno로 설정되고, 그것이  is 뒷부분 cdeptno로 바꿔야함 
    open cemplist(pdeptno);
    loop 
    fetch cemplist into vename, vsal;
    exit when cemplist%notfound;
    dbms_output.put_line(vename || ',' || vsal);
    end loop;
    close cemplist;
end; 

exec up+seldeptemp(30); 

sys_refcursor = (구버전 ref cursors)
커서를 담을 수 있는 자료형 


create or replace procedure up_selinsa
(
pcursor sys_refcursor 
)
is
vname insa.name%type;
vcity insa.city%type;
vbasicpay insa.basicpay%type;
begin
    loop
    fetch  pcursor into vname,vcity, vbasicpay;
    exit when pcursor%notfound;
    dbms_output.put_line(vname || ',' || vcity || ',' || vbasicpay);
    end loop;
--exception 
end;

위의 프로시저테스트 
create or replace procedure up_test_selinsa
    
is
    vcursor sys_refcursor;
begin
    open vcursor for select name, city, basicpay from insa;

    up_selinsa(vcursor);
    
    close vcursor; 
    

end;
exec up_test_selinsa;


create or replace procedure up_selinsa 
(
--출력용 매개변수 
    pcursor out sys_refcursor 
)
is
begin 
    open vcursor for select name, city, basicpay from insa; 
end; 

--jdbc=java+orale 에서 사용 

exception 예외처리 

create or replace procedure up_exception01 
(
    psal emp.sal%type
)
is 
vename emp.ename%type;
begin
    select ename into vename 
    from emp
    where sal=psal;
    dbms_output.put_line(psal || ':' || vename);

--블럭 안에서 예외가 발생했을 때 처리한다. 
    exception 
    when no_data_found then
        raise_application_error(-20000,'>query data not<');
    when too_many_rows then 
        raise_application_error(-20003,'>query data too many<');
    when others then --그 외의 예외들
        raise_application_error(-20004,'>query other exception found<');
    
end;
--Procedure UP_EXCEPTION01이(가) 컴파일되었습니다.


exec up_exception01(1250);

insert into dept values (40, 'qc' ,'seoul');
--이미 있는 값을 넣으려니 오류 보고 -
ORA-00001: unique constraint (SCOTT.PK_DEPT) violated

insert into emp ( empno,ename, job, mgr, hiredate, sal ,comm,deptno)
values (9999,'admin', 'clerk' , 9000, sysdate, 950, null, 90);
--미리 정의되 ㄴ7가지 예외에 없느 예외 처리  
-- ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found

create or replace procedure up_insemp
(
     pempno    in emp.empno%type,
     pename     IN emp.ename%type,
     pjob      IN emp.job%type,
     pmgr     IN emp.mgr%type,
    phiredate  IN emp.hiredate%TYPE,
     psal     IN emp.sal%type,
     pcomm     IN emp.comm%type,
     pdeptno      IN emp.deptno%type
)
is
--예외객체를 생성 
   --잘못된 부서번호를 주엇다. 
   ve_invalid_deptno exception ; 
   --예외객체 지정(매핑)할때 pragma exception 절 사용
   --에러코드에는 -를 붙인다. 
   pragma exception_init( ve_invalid_deptno , -02291);
begin
    insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno)
    values(pempno,pename,pjob,pmgr,phiredate,psal,pcomm,pdeptno); 
    commit;
    
    exception 
    when  ve_invalid_deptno then 
        RAISE_APPLICATION_ERROR(-20002, '> DEPTNO DEPTNO FK NOT FOUND...');
    when  others then 
        RAISE_APPLICATION_ERROR(-20004, '> query other exception found ');

end;

exec up_insemp(9999,'admin','clerk',9000,sysdate, 950, null,90);

--ORA-20002: > DEPTNO DEPTNO FK NOT FOUND...

create or replace procedure up_updScore
( 
--급여를 입력용으로 입력받음 
psal in emp.sal%type
)
is 
 vempcount number;
 ve_no_emp_returned exception;
 
begin 
    select count(*) into vempcount --사원의 수를 세서 변수에 담음 
    from emp 
    where sal between (psal-100) and (psal+100); --그사람의 sal이 입력받은 psal-100<sla<psal+100
    
    if vempcount=0 then
    --강제로 예외 발생  raise  사용자 예외 객체 (자바는 throw new 예외명)
        raise ve_no_emp_returned;
    else 
        dbms_output.put_line('>처리결과: ' || vempcount);
    end if;
    --예외가 발생하면 exception에 걸린다. 
exception 
        when ve_no_emp_returned then 
         RAISE_APPLICATION_ERROR(-20011, '> query emp count =0....  ');
        when others then 
          RAISE_APPLICATION_ERROR(-20012, '> query other exception found ');
end;

exec up_updscore(500);
--오류 보고 -
ORA-20011: > query emp count =0....







package days03;

/**
 * @author k≡n¡k
 * @date 2022. 5. 4. - 오후 12:34:47
 * @subject
 * @content
 */
public class Ex03 {

	public static void main(String[] args) {
		
		//           http://taeyo.net/
		/*
		 * [ MS SQL ]
		create table cstVSBoard (
				  seq int identity (1, 1) not null primary key clustered,  -- 글번호
				  writer varchar (20) not null , -- 작성자
				  pwd varchar (20) not null ,    -- 비밀번호
				  email varchar (100) null ,      -- 이메일
				  title varchar (200) not null ,  -- 제목
				  writedate smalldatetime not null default (getdate()),  -- 작성일
				  readed int not null default (0),  -- 조회수
				  mode tinyint not null ,  -- 모드  1(html 적용 O) 0(html 적용X)
				  content text null       -- 내용
		)
		
		-- Oracle 테이블 생성 쿼리 수정
		CREATE TABLE TBL_CSTVSBOARD (
		  seq NUMBER NOT NULL PRIMARY KEY, -- 글번호(PK)
		  writer VARCHAR2(20) NOT NULL ,  -- 작성자
		  pwd  VARCHAR2(20) NOT NULL ,  -- 비밀번호
		  email  VARCHAR2(100)  ,  -- 이메일
		  title  VARCHAR2(200) NOT NULL ,  -- 제목
		  writedate DATE DEFAULT SYSDATE, -- 작성일
		  readed NUMBER DEFAULT 0, -- 조회수
		  tag NUMBER(1) DEFAULT 0 ,   -- 0 텍스트모드  1 HTML 모드
		  content CLOB   -- 글내용
		);
		--
		SELECT *
		FROM tbl_cstvsboard;
		
		-- seq(글번호) 에 사용될 시퀀스 
		CREATE SEQUENCE seq_tbl_cstvsboard;
		*/	
			
	} // main

} // class


















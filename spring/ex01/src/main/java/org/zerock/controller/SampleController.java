package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/sample/*")
@Log4j

public class SampleController {
	/*
	 * @RequestMapping("") public void basic() { log.info(">basic....."); }
	 */
	
	//리턴타입이 void 일경우에는  요청url페이지를 자동으로 요청 
	@RequestMapping("basic")
	public void basicGet() {
		log.info("basic");
	}
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(">"+dto);
		return "ex01";  //WEB_INF/VIEW/ex01.jsp 404 오류 
	}
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name")String name ,
			@RequestParam("age") int age) {
		log.info(">"+String.format("name=%s, age=%d", name,age));
		return "ex02";  //WEB_INF/VIEW/ex01.jsp 404 오류 
	}
	
	@GetMapping("/ex02List")
	public String ex02List(
			//@RequestParam("ids") ArrayList<String> ids
			@RequestParam("ids") String[] ids
			) {
		log.info(">"+Arrays.deepToString(ids));
		return "ex02List";  //WEB_INF/VIEW/ex01.jsp 404 오류 
	}
	
	//p133

	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {

		log.info("list dtos: " + list);

		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo);
		return "ex02";
	}


	@GetMapping("/ex04")
	//굳이 모델객체를 선언하지 않더라도,  @ModelAttribute를 사용하면 같은 기능이다. =Model model
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {

		log.info("dto: " + dto);
		log.info("page: " + page);
		
		
		return "/sample/ex04";
	}
	
	//RedirectAttributes
	//스프링MVC에서 리다이렉트될 때 일회성파라미터값을 설정(전달)하는 객체 
	//파라미터값을 한번만 전달한다. 
	//한번만 전달하는 것 =  새로고침을 하면 계속 똑같은 파라미터전달 ->이럴때 한번만 전달하겠다. 
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06..........");

		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");

		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07..........");

		// {"name": "홍길동"}
		String msg = "{\"name\": \"홍길동\"}";

		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		HttpStatus status=HttpStatus.OK; //Status Code:200
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	//파일업로드 
	//p 150
	   @GetMapping("/exUpload")
	   public void exUpload() {
	      log.info("> exUpload.........." ); 
	   }
	   
	   
	 //p 152
	   @PostMapping("/exUploadPost")
	   public void exUploadPost( ArrayList<MultipartFile> files ) {
	      log.info("> exUploadPost.........." ); 
	      files.forEach( file -> {
	         log.info("--------------------" ); 
	         log.info("> name : " + file.getOriginalFilename() ); 
	         log.info("> size : "  + file.getSize() +"(bytes)"); 
	      });
	   }
	   
	   
	   
}

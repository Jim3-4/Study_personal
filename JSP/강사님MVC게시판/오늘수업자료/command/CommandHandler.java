package days08.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
	
	// 로직 처리 메서드
	// 리턴자료형 String  :   "list.jsp",   "write.jsp"
	// 포워딩, 리다이렉트      +   JSP 페이지                               클래스 
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception;

}

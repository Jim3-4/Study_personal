package days08.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {

	//리턴자료형 "list.jsp " "write.jsp"
	//포워딩해야할지 리다이랙트 해야할지 , + jsp페이지 
	//클래스로 줘도된다. 
	public String  process(HttpServletRequest request, HttpServletResponse response)throws Exception;
}

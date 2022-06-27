package days09.guestbook.service;


//사용자 정의 예외 클래스 
//잘못된 비밀번호 일때 예외를 발생시키겠다. 
public class InvalidPasswordException extends ServiceException{
    
    public InvalidPasswordException(String message) {
       super(message);
    }
    
}
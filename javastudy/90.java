package twoInterface;

public class FileinputStream implements AutoCloseable{
private String file;
public FileinputStream(String file) {
	this.file=file;
}
public void read() {
	System.out.println("을 읽습니댜.");
}
public void close() throws Exception{
	System.out.println("을닫습니다 ");
}
}

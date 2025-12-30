package myBoard;

import java.sql.Timestamp;

public class boardDto {

	private String num;
	private String writer;
	private String subject;
	private String content;
	private String path;
	private int widthcount;
	private Timestamp writeday;
	
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	public int getWidthcount() {
		return widthcount;
	}
	public void setWidthcount(int widthcount) {
		this.widthcount = widthcount;
	}
	
	
	
}

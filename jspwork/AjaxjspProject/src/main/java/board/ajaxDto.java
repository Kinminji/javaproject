package board;

import java.sql.Timestamp;

public class ajaxDto {
	private String num;
	private String name;
	private String subject;
	private String content;
	private String emot;
	private Timestamp writeday;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmot() {
		return emot;
	}
	public void setEmot(String emot) {
		this.emot = emot;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
	
}

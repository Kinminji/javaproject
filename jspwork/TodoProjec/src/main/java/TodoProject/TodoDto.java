package TodoProject;

import java.sql.Timestamp;

public class TodoDto {
	private String content;
	private String emot;
	private String num;
	private String scope;
	private Timestamp writeday;
	
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmot() {
		return emot;
	}
	public void setEmot(String emot) {
		this.emot = emot;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
}

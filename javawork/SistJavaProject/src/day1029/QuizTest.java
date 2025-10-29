package day1029;

import java.io.Writer;

class quiz{
	
	//어떤방법으로 해도 가능
	//디폴트 생성자 setter,getter
	//명시적생성자에 3개의 인자를 넣어 가능
	//출력문을 메서드로 만들어서 출력 가능
	
	private String stuName;
	private String gender;
	private String addr;
	
	static String ban="JAVA 4class";
	static int cnt=0;
	
	
	
	public void setstuName(String stu) {
		stuName=stu;
	}
	public void setgender(String gen) {
		gender=gen;
	}
	public void setaddr(String addr) {
		this.addr=addr;
	}
	
	
	public String getstuName() {
		return stuName;
	}
	public String getgender() {
		return gender;
	}
	public String getaddr() {
		return addr;
	}
	
	public void wri() {
		System.out.println("학생이름: "+stuName);
		System.out.println("클래스: "+quiz.ban);
		System.out.println("성별: "+gender);
		System.out.println("지역: "+addr);
	}
	
	
}

public class QuizTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		quiz my=new quiz();
		
		my.setstuName("김민지");
		my.setgender("여성");
		my.setaddr("서울 성동구");
		my.wri();
		
		System.out.println("==========================");
		
		my.setstuName("엄혜지");
		my.setgender("여성");
		my.setaddr("경기도 남양주시");
		my.wri();
		
		
		

		
		
	}

}

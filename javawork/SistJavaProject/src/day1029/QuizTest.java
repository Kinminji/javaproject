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
	
	static String ban;
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
		cnt++;
		System.out.println("**학생 "+cnt+" 정보");
		System.out.println("학생이름: "+stuName);
		System.out.println("클래스: "+quiz.ban);
		System.out.println("성별: "+gender);
		System.out.println("지역: "+addr);
		System.out.println("=========================");
	}
	
	
	//선생님
	
	//멤버 메서드 한번에 set메서드로 만들기_수정용
	public void setStuDate(String name, String gender, String addr)
	{
		stuName=name;
		this.gender=gender;
		this.addr=addr;
	}
	
	//출력용 데이터도 한번에 만들기
	public void getStuDate()
	{
		cnt++;
		System.out.println("**학생 "+cnt+" 정보**");
		System.out.println("이름: "+stuName);
		System.out.println("쌍용 소속학급: "+ban);
		System.out.println("성별: "+this.gender);
		System.out.println("주소: "+addr);
		System.out.println("================================");
	}
	
	
}

public class QuizTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		quiz my=new quiz();

		quiz.ban="JAVA 4class";
		
		my.setstuName("김민지");
		my.setgender("여성");
		my.setaddr("서울 성동구");
		my.wri();
		

		
		my.setstuName("엄혜지");
		my.setgender("여성");
		my.setaddr("경기도 남양주시");
		my.wri();
		
		//선생님 
		quiz my3=new quiz();
		my3.setStuDate("김민지", "여자", "서울시성동구");
		my3.getStuDate();
		
		quiz my2=new quiz();
		my2.setStuDate("강서빈", "남자", "서울시 강남구");
		my2.getStuDate();

		
		
	}

}

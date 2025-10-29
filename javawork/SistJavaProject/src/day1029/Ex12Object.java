package day1029;

class Member
{
	//모든 변수 private
	private String memName;
	private int memAge;
	private String job;
	
	static final String city="세종시";
	
	//setter
	
	public void setmemName(String name) {
		memName=name;
	}
	public void setmemAge(int age) {
		memAge=age;
	}
	public void setjob(String job) {
		this.job=job;
	}
	
	//getter
	public String getmemName() {
		return memName;
	}
	public int getmemAge() {
		return memAge;
	}
	public String getjob() {
		return job;
	}
	
	//출력메서드
	public void writeMember() {
		System.out.println("회원명: "+memName);
		System.out.println("회원나이: "+memAge);
		System.out.println("회원직업: "+job);
	}
	
}

public class Ex12Object {

	public static void main(String[] args) {
		// 디폴트생성자로 생성후 setter이용해서 수정하고
		//getter 이용해서 출력
		
		Member me=new Member();
		
		//메서드 이용해서 출력도 가능
		me.writeMember();
		
		//수정
		me.setmemName("김민지");
		me.setmemAge(28);
		me.setjob("취준생");
		me.writeMember();
		
		//수정
		me.setmemName("유재석");
		me.setmemAge(51);
		me.setjob("연예인");
		//조회메서드를 이용하여 출력
		System.out.println(me.getmemName());
		System.out.println(me.getmemAge());
		System.out.println(me.getjob());
		
	}

}

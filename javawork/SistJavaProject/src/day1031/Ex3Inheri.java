package day1031;

class Person{
	
	String name;
	String buseo;
	
	//메서드
	public void writeSawon()
	{
		System.out.println("부모변수출력");
		System.out.println("이름: "+this.name);
		System.out.println("부서: "+this.buseo);
	}
}


//sub
class MyInfo extends Person{
	
	int age;
	String positoin;
	
	//명시적생성자
	public MyInfo(String name, String bu, int age, String po) {
		this.name=name;
		this.buseo=bu;
		this.age=age;
		this.positoin=po;
	}
	
	//단독으로 부모의 멤버로 메서드 작성이 가능하다
	public void writeMyInfo()
	{
		System.out.println("사원명: "+this.name);
		System.out.println("부서: "+this.buseo);
		System.out.println("나이: "+this.age);
		System.out.println("직위: "+this.positoin);
	}
	
	//오버라이딩 메서드 구현(메서드명은 같아야 한다)
	@Override
	public void writeSawon() {
		// TODO Auto-generated method stub
		super.writeSawon();
		System.out.println("나이: "+this.age);
		System.out.println("직위: "+this.positoin);
	}
}

public class Ex3Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyInfo n=new MyInfo("김민지", "디자인팀", 28, "대리");
		n.writeMyInfo();
		
		System.out.println();
		
		n.writeSawon();
		

	}

}

package day1029;

//객체의 속성은 인스터스 변수로 표현, 객체의 동작은 클래스의 메서드로 표현
//Object:객체(핸드폰, 텀블러, 마우스..)
//Class:객체를 정의해 놓은 틀, 객체를 생성하기 위해 존재
//Instance:클래스에서 만들어진 객체가 그 클래스의 인스턴스

//멤버변수:instance 변수, static 변수(클래스 변수)

public class Ex1Object {

	String name; //instance 변수, 객체생성후 값변경 또는 호출 가능
	static final String MESSAGE="오늘은 클래스 배우는날";
	//상수(변하지 않는것들)여서 쓰는 경우가 많음/final은 못바꿔 라고 고정할경우 씀
	//객체 생성 없이 클래스명으로 접근 가능(같은 클래스 내에서는 클래스명 생략 가능)
	
	public static void main(String[] args) {
		
		System.out.println("static변수는 new로 생성없이 호출가능하다.");
		System.out.println(MESSAGE);
		System.out.println(Ex1Object.MESSAGE);//다른 클래스였으면 앞에 클래스명쓰고 호출
		
//		MESSAGE="nice day"; final을 붙혔기에 값 변경 안됨.
		
//		System.out.println(Ex1Object.name); name과 같은 인스턴스 변수는 객체생성을 해야만 사용가능
		Ex1Object ex1=new Ex1Object(); //ex1을 인스턴스 변수라고 한다
		System.out.println(ex1.name); //클래스에서 초기화 안하면 문자는 null로 자동인식
		
		//초기화
		ex1.name="박성진";
		System.out.println(ex1.name);
		
		//2. 2번째 이름 초기화후 출력
		Ex1Object ex2=new Ex1Object();
		ex2.name="강영현";
		System.out.println(ex2.name);
		
		System.out.println("다같이 사용하는 메세지: "+MESSAGE);
		
	}

}

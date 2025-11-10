package day1110;

class Outer{
	
	String name="김민지";
	int age=28;
	
	//내부클래스 :  외부클래스의 멤버변수사용이 가능하다.
	class Inner1{
		
		public void show() {
			System.out.println("**Inner1 클래스의 내부 클래스**");
			System.out.println("이름: "+name);
			System.out.println("나이: "+age);
		}
		
	}
	
	public void wirte()
	{
		System.out.println("**outer 클래스의 외부메서드**");
		//외부에서 내부클래스 메서드 호출
		Inner1 in=new Inner1();
		in.show();
	}
	
}

public class Ex2InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outer out=new Outer();
		out.wirte();
		
		System.out.println("=====================");
		
		Outer.Inner1 in=out.new Inner1();
		in.show();
		

	}

}

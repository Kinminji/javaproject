package day1110;

import day1110.outerobj.innerobj;

class outerobj{
	
	class innerobj{
		//내부클래스 : 클래스 안에 존재
		//특정 클래스 내에서만 사용하는 클래스가 필요한 경우
		
		public void write()
		{
			System.out.println("내부클래스의 메서드");
		}
	}
	
	 public void show()
	 {
		 System.out.println("외부클래스의 메서드");
		 System.out.println("외부에서 내부클래스의 메서드 호출 가능");
		 
		 innerobj in=new innerobj();
		 in.write();
	 }
	
}


public class Ex1InnerClass {

	public static void main(String[] args) {
		// 외부클래스의 메서드 호출
		
		outerobj out=new outerobj();
		out.show();
		
		System.out.println("---------------------------------");
		
		//내부클래스의 메서드를 메인에서 호출하려면 외부를 통해서만 가능
//		innerobj in=new innerobj(); 오류
		
//		outerobj.innerobj inobj=new outerobj().new innerobj();
		outerobj.innerobj inobj2=out.new innerobj();

		inobj2.write();
		
	}

}

package day1104;

public class Ex1inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1.자식클래스로 선언, 자식클래스로 생성");
		System.out.println();
		
		Ex1Red red=new Ex1Red();
		red.helloColor(); //부모 메서드는 언제든 불러올수 있음.
		red.process();
		
		Ex1Pink pink=new Ex1Pink();
		pink.process();
		
		Ex1Orange orange=new Ex1Orange();
		orange.helloColor();
		orange.process();
		
		System.out.println();
		System.out.println("========================================");
		System.out.println("2. 부모클래스로 선언, 자식클래스로 생성_다형성");
		System.out.println();
		
		Ex1Color color; //선언
		color=new Ex1Red(); //생성1
		color.helloColor(); //부모가 가진 메서드는 호출은 가능 , 자식 클래스 메서드 호출이 불가능(오버라이딩을 하지 않아서)
		color.process();  //부모한테는 없고 자식만 가지고 있는 메서드는 호출이 안됨.
		//메서드가 오버라이딩 된 경우에는 호출 가능.
		
		color=new Ex1Pink(); //생성2
		color.process(); //super의 내용도 sub의 내용도 가져옴
		
		
		color=new Ex1Orange(); //생성3
		color.process();
		
		
		
		
	}

}

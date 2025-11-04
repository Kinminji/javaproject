package day1104;

//super_추상클래스
abstract class Fruit{
	
	//상수
	public static final String MESSAGE="오늘은 추상 클래스 배우는 날";
	
	//일반 메서드
	public void ShowTitle() {
		System.out.println("추상클래스 제목을 출력합니다.");
	}
	
	//추상메서드_오버라이딩이 목적이므로 상속받은 자식클래스에서는 반드시 오버라이딩 해주어야 한다
	abstract public void showMessage(); //추상메서드가 하나라도 있으면 클래스에도 앞에 abstract를 붙여야함, 추상클래스
	
}

//sub1
class Apple extends Fruit{

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("나는 사과입니다.");
	}
	
}

//sub2
class Banana extends Fruit{

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("나는 바나나입니다.");
	}
	
}

//sub3
class Orange extends Fruit{

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("나는 오렌지입니다.");
	}
	
}

public class Ex3Abstract {
	
	public static void main(String[] args) {
		//다형성
		Fruit fru=new Apple();
		fru.ShowTitle();
		fru.showMessage();
		
		fru=new Banana();
		fru.showMessage();
		
		fru=new Orange();
		fru.showMessage();
		
	}
}

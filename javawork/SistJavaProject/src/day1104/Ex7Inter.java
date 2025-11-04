package day1104;

interface myColor{
	String INITCOLOR="white";
	public void paintColor();
}

class Red implements myColor{

	@Override
	public void paintColor() {
		// TODO Auto-generated method stub
		System.out.println("현재 색상은"+INITCOLOR);
		System.out.println("Red 컬러로 도색합니다.");
	}
}

class Blue implements myColor{

	@Override
	public void paintColor() {
		// TODO Auto-generated method stub
		System.out.println("현재 색상은"+INITCOLOR);
		System.out.println("Blue 컬러로 도색합니다.");
	}
	
}

class Green implements myColor{

	@Override
	public void paintColor() {
		// TODO Auto-generated method stub
		System.out.println("현재 색상은"+INITCOLOR);
		System.out.println("Blue 컬러로 도색합니다.");
	}
	
}

public class Ex7Inter {

	public static void main(String[] args) {
		//red, blue, green은 mycolor를 구현하고
		//현재색상은 WHITE
		//레드 컬러로 도색합니다.
		//mycolor로 선언하고 각각의 컬러로 생성
		
		myColor color=new Red();
		color.paintColor();
		
		color=new Blue();
		color.paintColor();
		
		color=new Green();
		color.paintColor();

	}

}

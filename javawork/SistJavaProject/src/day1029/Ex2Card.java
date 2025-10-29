package day1029;

public class Ex2Card {

	String kind;//카드의 종류
	int number;//카드의 숫자
	
	static int width;
	static int heigt;

	public static void main(String[] args) {

		//static변수는 클래스가 로딩될떄 생성 끝날때 소멸
		Ex2Card.width=10;
		heigt=20;
		
		System.out.println(Ex2Card.width);
		System.out.println(Ex2Card.heigt);
		
		//인스턴스 변수 kind,number 생성
		
		Ex2Card c1=new Ex2Card();
		c1.kind="Heart";
		c1.number=5;
		
		Ex2Card c2=new Ex2Card();
		c2.kind="Diamond";
		c2.number=3;
		
		Ex2Card c3=new Ex2Card();
		c3.kind="Clober";
		c3.number=8;
		
		System.out.println(c1.kind+","+c1.number+" 와 "+c2.kind+","+c2.number);
		System.out.println(c3.kind+","+c3.number+" 의 "+ Ex2Card.width+","+heigt);
		
	}
}

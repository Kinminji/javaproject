package day1029;

public class Ex5ConstText {
	
	int num; //0

	//디폴트 생성자
	public Ex5ConstText() {
	
		System.out.println("나는 디폴트 생성자");
		num=10;
		
	}
	
	//명시적 생성자
	public Ex5ConstText(int num) {
		
		System.out.println("나는 명시적 생성자");
		this.num=num; //초기값의 이름 앞에 this를 쓰기
		
	}
	
	public Ex5ConstText(String num) {
		
		System.out.println("나는 명시적 생성자");
		
	}
	
	//메서드 
	public int getNumber()
	{
		num=50;
		return num;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex5ConstText ex1=new Ex5ConstText();
		System.out.println(ex1.num);
		Ex5ConstText ex2=new Ex5ConstText(30); //생성과 동시에 초기화
		System.out.println(ex2.num);
		Ex5ConstText ex3=new Ex5ConstText("생성자");
		
		//메서드
		Ex5ConstText ex4=new Ex5ConstText();
		System.out.println(ex4.getNumber());
		
	}
}

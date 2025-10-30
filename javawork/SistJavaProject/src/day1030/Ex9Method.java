package day1030;



public class Ex9Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("2수의 합: "+add(10, 20));
		System.out.println("제곱: "+square(4.2));
		System.out.println("정수와 실수 더한 합: "+sum(1,2.12));
		System.out.println("실수와 정수 더한 합: "+sum(1,2.12));
		
	}
	
	static int add(int num1,int num2)
	{
		int result=num1+num2;
		return result;
	}
	
	static double square(double num) {
		return num*num;
	}
	
	//이름이 sum인 메서드_1개의 정수와 1개의 실수를 입력받아 더해서 리턴해주는 함수
	static double sum(int a, double b) {
		return a+b;
		
	}
	
	static double sum(double a, int b) {
		return a+b;
		//오버로딩 가능하다.
		//단 인자값이 달라야함.
		//순서다름
	}

}

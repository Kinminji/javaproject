package day1023;

public class DoWhile_11 {

	public static void main(String[] args) {
		// 조건이 참일동안 반복
		//선조건:조건이 먼저옴(while)
		
		int i=1;
		
		System.out.println("while문 결과");
		while(i<5) {
			System.out.println(i++);
		}
		
		//후조건:조건이 나중에옴(do~while)
		
		System.out.println("do~whlie문 결과");
		
		i=1;
		do {
			System.out.println(i++);//출력후 증가
		} while(i<5);
		System.out.println("종료");
	}

}

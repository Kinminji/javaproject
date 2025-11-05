package day1105;

public class Ex3Exception {

	public static void main(String[] args) {

		System.out.println("프로그램 시작!!");
		try
		{ //예외가 발생할 만한 코드
			int num=3/0; //정수를 0으로 나누면 에러 발생
		} catch (Exception e) {
			// 예외 처리
			e.printStackTrace(); //자세한 예외 정보
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 정상종료");

	}

}

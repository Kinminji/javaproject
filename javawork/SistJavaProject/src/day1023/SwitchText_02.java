package day1023;

public class SwitchText_02 {

	public static void main(String[] args) {
		//break가 없으면 끝까지 실행
		
		int n=1;
		
		switch(n) {
		case 1:
			System.out.println("n is 1");
			break; //break 없으면 n=1일 경우 1부터 3까지 다 나오는데 break를 걸면 1에서 끝남
		case 2:
			System.out.println("n is 2");
			break;
		case 3:
			System.out.println("n is 3");
			break;
		default:
		System.out.println("n is > 3");
		}
		
	}
}

package day1024;

import java.util.Random;

public class RandomText_08 {

	public static void main(String[] args) {
		// Random클래스를 생성해서 구하는 방법
		
		Random r=new Random();
		
		System.out.println("0~9사이의 난수 5개발생");
		for(int i=1;i<=5;i++) {
			
			int n=r.nextInt(10); //0~9까지를 발생하기 위해 ()안에 10을 넣음
			System.out.println(n);
		}
		
		System.out.println();
		
		System.out.println("0~99사이의 난수 5개발생");
		for(int i=1;i<=5;i++) {
			
			int n=r.nextInt(100); //0~99까지를 발생하기 위해 ()안에 100을 넣음
			System.out.println(n);
		}
		
		System.out.println();
		
		System.out.println("1~10사이의 난수 5개발생");
		for(int i=1;i<=5;i++) {
			
			int n=r.nextInt(10)+1; //1~10까지를 발생하기 위해 ()안에 10을 넣고 +1
			System.out.println(n);
		}
		
		System.out.println();
		
		System.out.println("A~Z사이의 난수 5개발생");
		for(int i=1;i<=5;i++) {
			
			int n=r.nextInt(26)+65; //A~Z까지를 발생하기 위해 ()안에 a~z까지의 갯수 26과 a를 숫자로 변환하면 65이기에 +65를 추가한다.
			System.out.println((char)n); //문자로 변형하기 위에 char를 추가
		}
		
		System.out.println();
		
		System.out.println("20~30사이의 난수 5개 발생");
		for(int i=1;i<=5;i++) {
			
			int n=r.nextInt(11)+20;// (m+n-1)
			System.out.println(n);
		}
	}

}

package day1023;

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		//호출하여 결과 보기
		
//		quiz1();
//		quiz2();
		quiz3();

	}
	public static void quiz1() {
		//팩토리얼 구할 숫자를 입력
		//5
		//5!=120
		
		
		Scanner sc=new Scanner(System.in);
		int num;
		int a=1;
		
		System.out.println("숫자를 입력하시오.");
		num=sc.nextInt();
		

		for(int i=1;i<=num;i++) {
			a*=i;
		}
		
		System.out.println(num+"!="+a);
		
	}
	
	
	public static void quiz2() {
		//1~100까지 중에서 5의 배수의 합을 구하시오.
		//1~100까지중 5의 배수의 합은 ***입니다.
		
		int sum=0;
		for(int i=1;i<=100;i++) {
			
			if(i%5==0)
				sum+=i;
			else
				continue;
			
		}
		
		System.out.println("1~100까지중 5의 배수의 합은"+sum+"입니다.");
		
	}
	
	
	public static void quiz3() {
		//점수(1~100)를 입력받다가 0을 입력하면 반복문 빠져나온후에
		//총갯수와 총점, 평균 출력하기
		
		Scanner sc=new Scanner(System.in);
		int num;
		int tot=0;
		int sum=0;
		double avg=0;
		
		for(int i=1;i<=100;i++) {
			
			System.out.println("점수를 입력해주세요.");
			num=sc.nextInt();
			
			
			if(num==0)
				break;
			
			tot++;
			sum+=num;
			
		}
		
		avg=(sum/tot);
		System.out.println("총갯수는:"+tot);
		System.out.println("총점은:"+sum);
		System.out.println("평균은"+avg);
		
	}
}

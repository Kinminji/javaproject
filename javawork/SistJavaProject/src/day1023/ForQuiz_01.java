package day1023;

import java.util.Scanner;

public class ForQuiz_01 {
	public static void main(String[] args) {
		//1~20까지를 출력하는데 5의 배수는 제외후 출력하시오
		int i=1;
		for(i=1;i<=20;i++) {
			if(i%5==0)
				continue;
			System.out.print(i+" ");
		}
		System.out.println();

		//1~50까지 출력하는데 3씩 증가하게 출력합니다.

		for(i=1;i<=50;i+=3) {
			System.out.print(i+" ");
		}
		System.out.println();

		//내가 숫자를 입력하면 1부터 입력한 숫자까지의 합계를 구해서 출력해보시오.
		//합계를 구할 숫자는? 5
		//1~5까지의 합은? 15

		Scanner sc=new Scanner(System.in);
		int num;
		int total=0;

		System.out.println("합계를 구할 숫자는?");
		num=sc.nextInt();

		for(i=1;i<=num;i++) {
			total+=i;
		}
		System.out.println("1부터"+num+"까지의 합은"+total);

		System.out.println();


		
		//1~100까지의 숫자중에서 짝수의 합과 홀수의 합을 나누어 출력
		//짝수의 합:***
		//홀수의 합:***
		
		int even=0;
		int odd=0;
		int tot=0;
		
		for(i=1;i<=100;i++) {
			
			tot+=i;
			
			if(i%2==0)
				even+=i;
			else
				odd+=i;
		}
		
		System.out.println("전체의 합:"+tot);
		System.out.println("짝수의 합:"+even);
		System.out.println("홀수의 합:"+odd);
				
	}
}

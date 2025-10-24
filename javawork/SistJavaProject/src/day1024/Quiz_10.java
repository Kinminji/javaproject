package day1024;

import java.util.Scanner;

public class Quiz_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		quiz1();
//		quiz2();
//		quiz3();
//		quiz4();
		quiz5();
	}
	
	public static void quiz1 () {
		//1~10까지중에서 짝수만 출력해 주세요. (for,if)
		//2,4,6,8,10
		
		for(int i=1;i<=10;i++) {
			if(i%2==1)
				continue;
			System.out.printf("%4d",i);
		}
		
	}
	
	public static void quiz2 () {
		//1~100까지의 숫자중 3의 배수의 합과 갯수의 구하시오.
		//3의 배수의 합은=
		//3의 배수의 갯수=
		
		int sum=0;
		int tot=0;
		
		for(int i=1;i<=100;i++) {
			if(i%3==0) {
				sum+=i;
				tot++;
			}
			else
				continue;
		}
		
		System.out.println("3의 배수의 합은="+sum);
		System.out.println("3의 배수의 갯수는="+tot);
		
	}
	
	public static void quiz3 () {
		//1~5까지의 팩토리얼 구하기
		//1!=
		//2!=
		//3!=
		//4!=
		//5!=
		
		int pack=1;
		for(int i=1;i<=5;i++) {
			pack*=i;
			System.out.println(i+"!="+pack);
		}

		
		
	}
	
	public static void quiz4 () {
		//숫자를 입력하다가 0을 입력하면 반복문을 빠져나온 후 (while,break)
		//양수의 갯수: 3개
		//음수의 갯수 : 2개
		
		Scanner sc=new Scanner(System.in);
		int num;
		int plus=0,minus=0;
		
		while(true) {
			System.out.println("숫자를 입력하시오.");
			num=sc.nextInt();
			
			if(num==0) {
				System.out.println("프로그램을 종료합니다.");
				break;	
			}
			
			if(num>=1)
				plus++;
				else
				minus++;
		}
		
			System.out.println("양수의 갯수:"+plus+"개");
			System.out.println("음수의 갯수:"+minus+"개");
		
	}
	
	public static void quiz5 () {
		//구구단을 세로로 출력하는데 2~9단까지의 반복이 3까지만 나오도록 해주세요.
		
		
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				
				if(i>3)
					break;
				
				System.out.print(j+"X"+i+"="+i*j+"\t");
			}
			System.out.println();
		}

	}
	
}

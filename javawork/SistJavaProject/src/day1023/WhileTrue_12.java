package day1023;

import java.util.Scanner;

public class WhileTrue_12 {

	public static void main(String[] args) {

//		test1();
		
//		다음 메서드를 부를땐 이전 메서드는 주석처리로 끄기
		
		test2();

		//text메서드에 있는 내용을 불러온다 라는 뜻
		//변수 겹칠 걱정을 덜기 위해 메서드를 여러개 만드는 경우이다.

	} //main메서드 끝


	public static void test1() {

		// 점수를 입력후 합계를 구하는데
		//1~100점이 아닌 경우 제외
		// 0을 입력할때까지 반복해서 점수를 입력한다.

		Scanner sc=new Scanner(System.in);
		int sum=0;
		int score;

		while(true) {
			System.out.println("점수를 입력하시오.");
			score=sc.nextInt();

			//break문 (안하면 무한루프)
			if(score==0)
				break;

			//제외
			if(score<0 || score>100)
				continue; //다시점수입력

			sum+=score;
		}
		System.out.println("총합계:"+sum+"점");
	}


	public static void test2() {

		//임의의 수를 입력하여 합계와 평균,갯수을 구하시오.	
		//단 0을 입력하면 빠져나간다.
		
		Scanner sc=new Scanner(System.in);
		int sum=0;
		int su;
		double avg=0;
		int cnt=0;
		
		while(true) {
			System.out.println("숫자를 입력하세요.(종료시 0)");
			su=sc.nextInt();
			
			if(su==0)
				break;
			sum+=su;
			cnt++;
		}
		avg=(double)sum/cnt; //실수로 표기하기 위해 doubl을 앞에 써준다.
		System.out.println("합계:"+sum+"평균:"+ avg+"갯수:"+cnt);
		
	}


}

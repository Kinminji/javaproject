package day1024;

import java.util.Scanner;

import day1022.Equal_07;
import day1023.CharAt_05;

public class WhileQuiz_06 {
public static void main(String[] args) {
	
	//점수를 입력하다가 Q or q를 입력하면 while문을 빠져나온후
	//총갯수 총점 평균 구해서 출력하시오.
	
	Scanner sc=new Scanner(System.in);
	String score;
	int sum=0,tot=0;
	double avg;
	
	while(true) {
		
		System.out.println("점수를 입력하시오.");
		score=sc.nextLine();
		
		if(score.equals("Q")|| score.equals("q")) {
			System.out.println("종료합니다.");
			break;
		
//		if(score.charAt(0)=='Q' || score.charAt(0)=='q')
//			break;
		
		}
		
		tot++;
		sum+=Integer.parseInt(score); //정수로 변환후 합계변수에 누적하기
	}
	
	avg=(sum/tot);
	
	System.out.println("총갯수는:"+tot);
	System.out.println("총점은:"+sum);
	System.out.println("평균은:"+avg);
}
}

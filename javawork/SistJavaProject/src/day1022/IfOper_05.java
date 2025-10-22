package day1022;

import java.util.Scanner;

public class IfOper_05 {
	public static void main(String[] args) {
	
		//점수를 입력해서 학점을 알아보고 평가 구하기
		//학점:if  평가:삼항연산자(90점이상:장학생  80점이상:잘함  80점미만:재수강)
		/*
		 * 점수를 입력하시오
		 * 78
		 * 학점:c학점
		 * 평가:재수강
		 */
		
//		Scanner sc=new Scanner(System.in);
//		int x;
//		String grade;
//		
//		System.out.println("점수를 입력하시오.");
//		x=sc.nextInt();
//		
//		if(x>=90)
//		grade="A학점";
//		else if(90>x>=80)
//			grade="B학점";
		
		Scanner sc=new Scanner(System.in);
		
		String grade;
		int x;
		String pmsg;
		
		System.out.println("점수를 입력하시오");
		x=sc.nextInt();
		
		if(x>=90)
			grade="A";
		else if(x>=80)
			grade="B";
		else if(x>=70)
			grade="C";
		else if(x>=60)
			grade="D";
		else
			grade="F";
		
		System.out.println("학점:"+grade);
		
		grade=x>=90?"장학생":x>=80?"잘함":"재수생";
		System.out.println("평가:"+grade);
		
		
		//선생님 예시엔 pmsg를 추가하여 만드심
		pmsg=x>=90?"장학생":x>=80?"잘함":"재수생";
		System.out.println("평가는"+pmsg);
		
		
	
	}
	
	
}

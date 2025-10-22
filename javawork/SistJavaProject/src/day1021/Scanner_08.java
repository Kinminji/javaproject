package day1021;

import java.util.Scanner;

public class Scanner_08 {

	public static void main(String[] args) {
		// 이름과 국,영,수 점수를 입력후 총점,평균 출력해보기
		//import
		Scanner sc=new Scanner(System.in);
		
		//변수
		String name;
		int kor,mat,eng;
		
		//입력
		System.out.println("당신의 이름은?");
		name=sc.nextLine();
		System.out.println("당신의 국어,영어,수학 점수를 차례대로 입력하시오");
		kor=sc.nextInt();
		mat=sc.nextInt();
		eng=sc.nextInt();
		
		//계산
		int total=kor+mat+eng;
		double avg=total/3.0;
		//출력
		System.out.println(name);
		System.out.println("국어점수: "+kor+"점");
		System.out.println("수학점수: "+mat+"점");
		System.out.println("영어점수: "+eng+"점");
		System.out.println("=====================");
		System.out.println("총점: "+total+"점");
		System.out.println("평균: "+avg+"점");
	
	}
	
	
	

}

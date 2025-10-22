package day1021;

import java.util.Scanner;

public class ScanTest_09 {

	public static void main(String[] args) {
		/*점수는 int자료형으로 하십시오~~~
		 * 
		 이름입력: 홍길동
		 점수:  88 
		 학년: 4 
		 ==================================
		 [결과출력]
		 홍길동님은 4학년이며 평점은 88점 입니다*/
		
		//import
		Scanner sc=new Scanner(System.in);
		//변수선언
		String name,grade;
		int score;
		//입력
		System.out.print("이름입력: ");
		name=sc.nextLine();
		System.out.print("점수: ");
		score=Integer.parseInt(sc.nextLine()); //Integer.parseInt("88")=88
		System.out.print("학년: ");
		grade=sc.nextLine();
		//출력
		System.out.println("=================================");
		System.out.println("\t[결과출력]");
		System.out.println(name+"님은 "+grade+"학년이며 평점은 "+score+"점 입니다");

	}

}

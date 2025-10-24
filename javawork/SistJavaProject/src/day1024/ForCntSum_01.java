package day1024;

import java.util.Scanner;

public class ForCntSum_01 {
public static void main(String[] args) {
	//총5개의 점수를 입력받아 합계를 구하려고 한다(반복문)
	//만약 1~100이 아닌 점수는 다시 입력하시오.(continue)
	
	Scanner sc=new Scanner(System.in);
	
	int sum=0;
	int score;
	
	for(int i=1;i<=5;i++) {
		
		System.out.println(i+"번 점수:");
		score=sc.nextInt();
	
		if(score<1 || score>100) {
			System.out.println("\t 다시 입력해주세요.");
			i--; //다시 돌아가 다음순번으로 넘어가기 떄문에 하나를 빼줘야 함.
			continue; //i++로 이동
		}
		
		sum+=score;
	}
	
	System.out.println("총점:"+sum);
	
}
}

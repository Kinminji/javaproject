package day1024;

import java.util.Scanner;

public class AloneQuiz_01 {
public static void main(String[] args) {
	
//	quiz1();
	quiz2();
	
}
	
	public static void quiz1() {
	// 원하는 단을 입력해서 해당 단만 출력해보자.
	//단을 입력하시오 : 5
	//[5단] 5X1=5...5X9=45
	
	Scanner sc=new Scanner(System.in);
	int gu;
	
	while(true)
	{
		System.out.println("단을 입력하시오.");
		gu=sc.nextInt();
		
		if(gu==0) {
			System.out.println("종료합니다.");
			break;
		}
		
		System.out.println("["+gu+"단]");
		
		for(int i=1;i<=9;i++) 
		{
			System.out.println(gu+"X"+i+"="+gu*i);
		}
		break;
	}
	}
	
	//점수를 입력하다가 Q or q를 입력하면 while문을 빠져나온후
	//총갯수 총점 평균 구해서 출력하시오.
	
	public static void quiz2() {
		
	Scanner sc=new Scanner(System.in);	
	String score;
	int tot=0,sum=0;
	double avg;
	
	  while(true)
	  {
		  System.out.println("점수를 입력하시오.");
		  score=sc.nextLine();
		  
		  if(score.equals("q") || score.equals("Q"))
			  break;
		  
		  tot++;
		  sum+=Integer.parseInt(score);
	  }
	  
	avg=sum/tot;
	
	System.out.println("총갯수는?"+tot);
	System.out.println("총점은?"+sum);
	System.out.println("평균은?"+avg);
}
}

package day1023;

import java.util.Scanner;

public class IfReview_01 {
public static void main(String[] args) {
	
	//이름과 자바 스프링 점수를 입력후 총점을 구하시오
	//총점이 180점 이상이면 "통과", 170점 이상이면 "좀더노력할것!", 170점미만은"재시험"
	// 조건은 if, 삼항연산자 상관 없음
	
	Scanner sc=new Scanner(System.in);
	int java,spring,total;
	String name;
	String to;
	
	System.out.println("성함을 입력해주세요.");
	name=sc. nextLine();
	
	System.out.println("자바, 스프링 점수를 입력해주세요.");
	java=sc. nextInt();
	spring=sc. nextInt();
	
	
	total=java+spring;
	
	System.out.println("두 점수의 총합은"+total+"입니다.");
	
	System.out.println("**if문**");
	if (total>=180)
		System.out.println("통과");
	else if (total>=170)
		System.out.println("좀더 노력할것!");
	else
	System.out.println("재시험");
	
	
	System.out.println("**삼항연산자**");
	to=total>=180?"통과":total>=170?"좀더 노력할것!":"재시험";
	System.out.println("평가는"+to);
	
	
	System.out.println("평가"+(total>=180?"통과":total>=170?"좀더 노력할것!":"재시험"));
	
	
}
}

package day1022;

import java.util.Scanner;

public class IfAndOr_06 {
	public static void main(String[] args) {
	//3과목을 입력하여 총점,평균 구하기
	//각과목은 모두 40점 이상이여야 하며, 총점은 60점 이상을 합격기준으로 한다.
		
		Scanner sc=new Scanner(System.in);
		String name;
		int java,oracle,html;
		
		//입력
		System.out.println("수험생이름을 입력하시오.");
		name=sc.nextLine();
		System.out.println("3과목의 점수를 입력하시오.");
		java=sc.nextInt();
		oracle=sc.nextInt();
		html=sc.nextInt();
		
		//계산
		int total=java+oracle+html;
		double avg=total/3.0;
		
		System.out.println("3과목 점수:"+java+","+oracle+","+html);
		System.out.println("총점:"+total+"점");
		System.out.println("평균:"+avg+"점");
		
		//홍길동님은 시험에 불합격 하셨습니다.
		
//		String or;
//		or=avg>=60?"합격":"불합격";
//		System.out.println(name+"님은시험에"+or+"하셨습니다.");
		
		if(java>=40&&oracle>=40&&html>=40&&avg>=60) //모두가 맞아야 t
			System.out.println(name+"님은 시험에 합격하셨습니다.");
		else
			System.out.println(name+"님은 시험에 불합격하셨습니다.");
		
		if(java<40||oracle<40||html<40||avg<60) //하나라도 걸리면 t
			System.out.println(name+"님은 시험에 불합격하셨습니다.");
		else
			System.out.println(name+"님은 시험에 합격하셨습니다.");
		
}
}

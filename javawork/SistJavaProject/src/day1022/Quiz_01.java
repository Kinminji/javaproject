package day1022;

import java.util.Scanner;

public class Quiz_01 {
public static void main(String[] args) {
	
	/*
	 * 오늘 입고된 상품명은?
	 * 갤럭시 폴드
	 * 입고된 수량은?
	 * 5개가 입고 되었습니다.
	 * 단가는?
	 * 1200000
	 * 
	 * 갤럭시 폴드 5개는 총 6000000입니다.
	 * 5개 이상 구매시 10%할인 됨
	 * 할인된 총 금액: 5400000원
	 */
	
	Scanner sc=new Scanner(System.in);
	String name,number,price;
	double x,total;
	
	
	
	System.out.println("오늘 입고된 상품명은?");
	name=sc.nextLine();
	
	System.out.println("입고된 수량은?");
	number=sc.nextLine();
	
	System.out.println("단가는?");
	price=sc.nextLine();
	

	System.out.println("몇개 구매하시겠습니까?");
	x=sc.nextInt();
	
	if(x>=5)
		total=x*1200000*0.9;
	else
		total=x*1200000;
	
	System.out.println("총"+total+"원 입니다.");

	
	
		
	
}
}

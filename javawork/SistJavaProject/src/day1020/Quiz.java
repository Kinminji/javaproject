package day1020;

public class Quiz {

	public static void main(String[] args) {
		// args라는 매개변수 이용할것!!
		//변수는 마음대로 하되 이름에 걸맞게 만들것
		
		/*
		 오늘의 퀴즈
		 ==================
		 상품명: 아이폰17
		 수량: 2개
		 가격: 1500000원
		 총금액: 3000000원*/
		
		//1.변수선언
		String sangName=args[0];
		int su=Integer.parseInt(args[1]);
		int price=Integer.parseInt(args[2]);
		
		//2.계산
		int totalPrice=su*price;
		
		//3.출력
		System.out.println("\t오늘의 퀴즈");
		System.out.println("====================");
		System.out.println("상품명: "+sangName);
		System.out.println("수량: "+su+"개");
		System.out.println("단가: "+price+"원");
		System.out.println("총금액: "+totalPrice+"원");

	}

}

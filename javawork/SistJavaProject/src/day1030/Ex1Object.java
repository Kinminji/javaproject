package day1030;

import javax.print.DocFlavor.STRING;

class TestMethod{
	
	private String sangpum;
	private int price;
	private String made; //한국, 중국 ..
	
	
	//디폴트값을 만들면 3개의 멤버변수를 한꺼번에 변경하는 생성자가 오류나지 않음
	public TestMethod() {
		
	}
	
	//3개의 멤버변수를 한꺼번에 변경하는 생성자
	public TestMethod(String that, String made, int price)
	{
		sangpum=that;
		this.price=price;
		this.made=made;
	}
	
	//3개의 멤버변수를 한꺼번에 변경하는 메서드_set
	
	public void setSangpum(String that, String made, int price)
	{
		sangpum=that;
		this.price=price;
		this.made=made;
	}
	
	//출력용 메서드_get
	
	public void getSangpum()
	{
		System.out.println("입고상품");
		System.out.println("상품명: "+ sangpum);
		System.out.println("가격: "+ price+"원");
		System.out.println("제조사: "+ made);
		System.out.println("=========================");
	}
	
	//3개를 동시에 리턴받는 get메서드 방식
	public String getIpgo()
	{
		String s="상품명: "+sangpum+"\n원산지: "+made+"\n가격: "+price+"원";
		
		return s;
	}
	
	public String sang()
	{
		String a="제품: "+sangpum+"\n금액: "+price+"원"+"\n제조: "+made;
		return a;
	}
	
}

public class Ex1Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestMethod name1=new TestMethod();
		name1.setSangpum("아이폰", "미국", 2850000);
		name1.getSangpum();
		
		TestMethod name2=new TestMethod();
		name2.setSangpum("갤럭시", "한국", 2599000);
		name2.getSangpum();
		
		TestMethod name3=new TestMethod();
		name3.setSangpum("소니", "일본", 1990000);
		System.out.println(name3.getIpgo());
		
		TestMethod name4=new TestMethod();
		name4.setSangpum("알리", "중국", 1099900);
		System.out.println(name4.sang());
		
		TestMethod name5=new TestMethod("파스타", "이탈리아", 12000);
		name5.getSangpum();
	}

}

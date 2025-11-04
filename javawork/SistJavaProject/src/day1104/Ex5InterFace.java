package day1104;

//super_interface_상수와 추상메서드만 가능
interface FoodShop{
	
	String SHOPNAME="돼지국밥"; //final을 두지 않아도 interface에 쓰면 못바꾸는 상수가 됨
	
	public void order(); //abstract생략
	public void beadal();
	
}

//sub_implements는 다중구현이 가능하다
class Food1 implements FoodShop{

	@Override
	public void order() {
		
		System.out.println(SHOPNAME);
//		SHOPNAME="파스타집"; 변경안됨(final이라서)
		System.out.println("음식을 주문합니다.");
	}

	@Override
	public void beadal() {
		
		System.out.println(SHOPNAME);
		System.out.println("음식을 배달합니다.");
	}
	
}

public class Ex5InterFace {

	public static void main(String[] args) {
		FoodShop food=new Food1();
		food.order();
		food.beadal();

	}

}

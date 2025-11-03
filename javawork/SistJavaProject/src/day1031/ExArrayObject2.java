package day1031;

class menu{
	
	private String foodName;
	private int price;
	private String tasty;
	
	private static int cnt;
	
	public void setFood(String food, int price, String tasty) {
		this.foodName=food;
		this.price=price;
		this.tasty=tasty;
	}
	
	public static void showTitle() {
		
		System.out.println("No.\t메뉴명\t가격\t맛평가");
		System.out.println("======================================");
		
	}
	
	public void getFoodMenu() {
		cnt++;

		System.out.println(cnt+".\t"+foodName+"\t"+price+"\t"+tasty);
	}
	
}

public class ExArrayObject2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		menu.showTitle();
		
		menu sc=new menu();
		sc.setFood("막국수", 12000, "추천메뉴");
		sc.getFoodMenu();
		
		menu sc1=new menu();
		sc1.setFood("감자전", 9900, "인기메뉴");
		sc1.getFoodMenu();
		
		menu sc2=new menu();
		sc2.setFood("메밀전병", 9000, "1위메뉴");
		sc2.getFoodMenu();
		
		menu sc3=new menu();
		sc3.setFood("닭갈비", 15000, "흑백요리사");
		sc3.getFoodMenu();
		
		


	}

}

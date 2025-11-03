package day1031;

class Menu{
	
	private String foodName;
	private int price;
	private String tasty;
	
	private static int no; //메뉴번호
	
	
	//명시적생성자
	public Menu(String name,int price,String t) {
		this.foodName=name;
		this.price=price;
		this.tasty=t;
	}
	
	//제목메서드
	public static void showTitle()
	{
		System.out.println("No.\t음식명\t가격\t평가");
		System.out.println("==================================");
	}
	
	//출력
	public void getFoodMenu()
	{
		no++;
		System.out.println(no+"\t"+foodName+"\t"+price+"\t"+tasty);
	}
	
	
}

public class ExArrayObject2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//생성과 동시에 초기화
				Menu [] menu= {
						new Menu("막국수", 11000, "추천메뉴"),
						new Menu("감자전", 9000, "인기메뉴"),
						new Menu("메밀전병", 8000, "1위메뉴"),
						new Menu("닭갈비", 16000, "흑백요리사")
				};
				
				//제목출력
				Menu.showTitle();
				//배열출력
				for(Menu m:menu)
					m.getFoodMenu();

				System.out.println("-------------------------------");
				//제목출력
				Menu.showTitle();
				
				for(int i=0;i<menu.length;i++)
				{
					menu[i].getFoodMenu();
				}

	}

}

package day1031;

class food{

	private String name;
	private int price;

	public static int menu=0;



	public void setFood(String name, int price) {
		this.name=name;
		this.price=price;
	}
	
	public void getWriteMenu() {
		menu++;
		
		System.out.println("[메뉴"+menu+"]");
		System.out.println("메뉴명: "+name);
		System.out.println("가격: "+price);
		System.out.println("-----------------------");
	}

	
}

public class ExArrayObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		food f=new food();
		f.setFood("피자", 25000);
		f.getWriteMenu();
		
		food f1=new food();
		f1.setFood("알리오올리오", 15000);
		f1.getWriteMenu();
		
		food f2=new food();
		f2.setFood("아보카도샌드위치", 10000);
		f2.getWriteMenu();

	}

}

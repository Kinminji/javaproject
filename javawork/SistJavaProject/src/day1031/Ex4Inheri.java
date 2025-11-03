package day1031;

class Shop{
	
	private String sangpum;
	private int su;
	
	//디폴트 생성자
	public Shop() {
		
		//초기값 주기 가능
		sangpum="딸기";
		su=10;
		
	}
	
	//명시적 생성자
	public Shop(String s, int su) {
		this.sangpum=s;
		this.su=su;
	}
	
	
	//메서드
	public void writeShop()
	{
		System.out.println("상품명: "+sangpum);
		System.out.println("수량: "+su);
	}
	
}


//sub_Shop을 상속: 디폴트생성자(초기값 천원) 명시적생성자(price 추가)
class Mymall extends Shop{
	
	private int price;
	
	//디폴트
	public Mymall() {
		
		price=1000;
	}
	
	
	//명시적
	
	public Mymall(String s, int su, int price) {
		super(s, su);
		this.price=price;
	}
	
	
	//오버라이딩
	@Override
	public void writeShop() {
		// TODO Auto-generated method stub
		super.writeShop();
		System.out.println("가격: "+price);
	}
	
	
	
}

public class Ex4Inheri {

	public static void main(String[] args) {
		// 디폴트 생성자로 추가 후 메서드 출력
		Mymall m=new Mymall();
		m.writeShop();
		
		System.out.println();
		
		//명시적 생성자로 추가 후 메서드 출력 
		
		Mymall m1=new Mymall("오렌지", 20, 40000);
		m1.writeShop();

	}

}

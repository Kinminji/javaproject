package day1029;

public class Ex11Object {

	private String sangpum;
	int su;
	int price;
	static final String SHOPNAME="이마트";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex11Object ob=new Ex11Object();
		ob.sangpum="꼬북칩";
		ob.su=10;
		ob.price=15000;
		
		System.out.println("상점명: "+SHOPNAME);
		System.out.println("상품명: "+ob.sangpum);
		System.out.println("수량: "+ob.su);
		System.out.println("가격: "+ob.price);
		
	}

}

package day1030;

class MyShop{
	
	private String name;
	private int price;
	private String company;
	
	
	//생성과 동시에 초기화
	
	public MyShop(String n, int p, String c) {
		// TODO Auto-generated constructor stub
		
		this.name=n;
		this.price=p;
		this.company=c;
		
	}
	
	
	//제목메서드
		public static void title()
	{
		System.out.println("상품명\t가격\t회사명");
		System.out.println("==========================");
	}
	
	
	//출력문
		public void getSangpum()
		{
			System.out.println(name+"\t"+price+"만원\t"+company);
		}
		
		
}

public class Ex6ArrayObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//4개를 생성후 출력
		MyShop[] sh=new MyShop[4];
		
		sh[0]=new MyShop("아이폰", 275, "애플");
		sh[1]=new MyShop("삼성", 249, "삼성");
		sh[2]=new MyShop("에어팟", 37, "애플");
		sh[3]=new MyShop("버즈", 25, "삼성");
		
		
		//제목출력
		MyShop.title();
		
		
		//출력
		
		for(int i=0;i<sh.length;i++) {
			sh[i].getSangpum();
		}
		
		for(MyShop s:sh) {
			s.getSangpum();
		}
		
	}

}

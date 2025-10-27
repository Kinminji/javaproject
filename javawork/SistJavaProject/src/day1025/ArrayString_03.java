package day1025;

public class ArrayString_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] str;
		str=new String[4]; //생성
		
		//초기값
		str[0]="김밥";
		str[1]="떡볶이";
		str[2]="쫄면";
		str[3]="돈까스";
		
		System.out.println("출력_#1");
		for(int i=0;i<str.length;i++) {
			System.out.println((i+1)+":"+str[i]);
		}
		
		System.out.println();
		
		System.out.println("출력_#2");
		for(String s:str) {
			System.out.println(s);
		}
		
		System.out.println();
		
		System.out.println("선언과 동시에 초기값을 지정하기도 한다_주로이렇게 많이함");
		String[] menu= {"파스타","피자","샐러드","스프"};
		
		System.out.println("menu 갯수:" +menu.length);
		
		//menu1==>파스타
		
		for(int j=0;j<menu.length;j++) {
			System.out.println("menu"+(j+1)+"==>"+menu[j]);
		}
		
		System.out.println("for~each로 가로로 메뉴출력");
		for(String m:menu) {
			System.out.println("메뉴==>"+m);
		}
		
		String[] me= {"피자","치킨","햄버거"};
		
		System.out.println(me.length+"개중 선호도 조사");
		
		for(int i=0;i<me.length;i++) {
			System.out.println("menu"+(i+1)+"==>"+me[i]);
		}

		for(String e:me) {
			System.out.println("메뉴==>"+e);
		}
		
	}
}

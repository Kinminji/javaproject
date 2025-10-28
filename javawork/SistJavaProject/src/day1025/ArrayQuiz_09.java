package day1025;

import java.util.Scanner;

public class ArrayQuiz_09 {

	public static void main(String[] args) {
		// 메뉴명을 입력하여 '해당메뉴틑 2번째에 있습니다' 	Q or q를 입력시 프로그램 종료
		//티본스테이크 처럼 없는 메뉴 입력하면 '해당메뉴는 본 메뉴에 없습니다.'

		Scanner sc=new Scanner(System.in);
		
		String[] menu= {"아보카도샌드위치","에그샌드위치","콥샐러드","치아바타샌드위치","스테이크샌드위치","연어샌드위치"};
		
		
		String me;
		boolean flag;
		
		while(true) {
			System.out.println("메뉴명을 입력하세요.");
			me=sc.nextLine();
			
			if(me.equalsIgnoreCase("q"))
				break;
			
			flag=false;
			
			for(int i=0;i<menu.length;i++) {
				if(me.equals(menu[i])) {
					flag=true;
					System.out.println(i+1+"번째에 메뉴가 있습니다.");	
				}
			}
			
			if(!flag) {
				System.out.println("해당 메뉴는 없습니다.");
			}
			
		}
		
	}
	
}

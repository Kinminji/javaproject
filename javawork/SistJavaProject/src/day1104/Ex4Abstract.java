package day1104;

import java.util.Scanner;

//super
abstract class Board{
	
	public abstract void process(); //미완성 메서드 의미
	
}

//sub1
class insert extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 작성합니다.");
	}
	
}

//sub2
class select extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 출력합니다.");
	}
	
}

//sub3
class update extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 수정합니다.");
	}
	
}
//sub4
class delete extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 삭제합니다.");
	}
	
}

public class Ex4Abstract {

	public static void main(String[] args) {
		//다형성으로 생성하되 반복문으로 진행...
		//몇번 출력할래 라고 입력할꺼니까 scanner
		
//		Board board=new Board(); 추상클래스는 부모클래스로 new객체로 생성 안됨
		
		Scanner sc=new Scanner(System.in);
		int num;
		Board board=null; //선언만 부모로 해둠
		
		while(true) {
			System.out.println("1.입력  2.출력  3.수정  4.삭제  9.종료");
			num=sc.nextInt();
			
			switch(num) 
			{
			case 1:
				board=new insert();
				break;
			case 2:
				board=new select();
				break;
			case 3:
				board=new update();
				break;
			case 4:
				board=new delete();
				break;
			default:
				System.out.println("종료합니다.");
				System.exit(0); //강제종료(swith문 아예 종료)
			}
			
			board.process();
		}
		

	}

}

package day1105;

import java.util.Scanner;

interface Command {
	public void write();
}

//4개의 클래스는 모두 command를 구현 할 예정
class insert implements Command
{

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 작성합니다.");
		
	}
	
}
class update implements Command
{

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 업로드합니다.");
		
	}
	
}
class delete implements Command
{

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 삭제합니다.");
		
	}
	
}
class select implements Command
{

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 수정합니다.");
		
	}
	
}

public class Ex2InterCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		Command com=null;
		int num;
		
		while(true)
		{
			System.out.println("[메뉴]  1.작성  2.업로드  3.삭제  4.수정  5.종료");
			System.out.println("==========================================");
			
			num=sc.nextInt();
			
			if(num==1) {
				com=new insert();
				com.write();
			}
			else if(num==2)
			{
				com=new update();
				com.write();
			}
			else if(num==3)
			{
				com=new delete();
				com.write();
			}
			else if(num==4) {
				com=new select();
				com.write();
			}
			else {
				System.out.println("종료합니다.");
				break;
			}
		}
		
	}

}

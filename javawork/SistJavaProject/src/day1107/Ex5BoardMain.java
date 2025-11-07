package day1107;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex5BoardMain {
	
	//list를 클래스유형으로 지정, 데이터를 꺼내고 받을때도 클래스유형
	List<Ex5Board> list=new Vector<Ex5Board>();
	
	//입력
	public void inputDate()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("작성자명");
		String name=sc.nextLine();
		System.out.println("제목");
		String subject=sc.nextLine();
		System.out.println("내용");
		String content=sc.nextLine();
		
		//생성이 되면서 생성된 값이 list로 추가
//		Ex5Board data=new Ex5Board(name, subject, content);
//		list.add(data);
		
		list.add(new Ex5Board(name, subject, content));
		System.out.println("현재 데이터 갯수: "+list.size() );
	}
	
	//출력
	public void writeDate()
	{
		System.out.println("***\t게시판 출력\t***");
		System.out.println("=================================");
		
		for(int i=0;i<list.size();i++) 
		{
			Ex5Board b=list.get(i); //리스트내에서 지정된 위치에 있는 요소값을 돌려준다
			System.out.println((i+1)+".작성자: "+b.getWriter());
			System.out.println("제목: "+b.getSubject());
			System.out.println("내용: "+b.getContent());
		}
		
	}

	public static void main(String[] args) {
		
		Ex5BoardMain ex=new Ex5BoardMain();
		
		Scanner sc=new Scanner(System.in);
		int n;
		
		while(true)
		{
			System.out.println("1.추가     2.출력     9.종료");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1) {
				ex.inputDate();
			}else if(n==2) {
				ex.writeDate();
			}else {
				System.out.println("프로그램 종료");
				break;
			}
		}

	}

}

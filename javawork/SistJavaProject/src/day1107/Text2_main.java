package day1107;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Text2_main {
	
	Scanner sc=new Scanner(System.in);
	List<Text2_sub> list=new Vector<Text2_sub>();
	
	public int input() {
		int in=0;
		System.out.println("1.입력     2.출력     3.종료");
		in=Integer.parseInt(sc.nextLine());
		return in;
	}
	
	public void write()
	{
		System.out.println("이름");
		String name=sc.nextLine();
		System.out.println("나이");
		int age=Integer.parseInt(sc.nextLine());
		System.out.println("주소");
		String addr=sc.nextLine();
		
		Text2_sub sub=new Text2_sub();
		
		sub.setName(name);
		sub.setAge(age);
		sub.setAddr(addr);
		
		list.add(sub);
		System.out.println("데이터 갯수: "+list.size());
	}
	
	public void output() {
		System.out.println("=========================================");
		System.out.println("번호\t이름\t나이\t주소");
		System.out.println("=========================================");

		int num=0;
		
		for(int i=0;i<list.size();i++)
		{
			Text2_sub sub=list.get(i);
			System.out.println(++num+".\t"+sub.getName()+"\t"+sub.getAge()+"\t"+sub.getAddr());
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		Text2_main ts=new Text2_main();
		
		while(true)
		{
			int n=ts.input();
			
			if(n==1) {
				ts.write();
			} else if(n==2) {
				ts.output();
			} else {
				System.out.println("종료");
				break;
			} 
		}
		
	}

}

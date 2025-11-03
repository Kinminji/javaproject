package day1031;

import java.util.Scanner;

public class EmpMain {

	public static void getEmpPay(Emp e)
	{
		System.out.println(e.getName()+"\t"+e.getPay()+"\t"+e.getSudang()+"\t"+e.getNetPay());
	}
	
	public static void main(String[] args) {
		// 회사명, 사원명, 급여, 수당 입력후 Emp테이블 생성후 set메서드를 이용하여 초기값을 입력한다
		//최종적으로 getEmpPay를 호출하여 급여명세서를 사원수만큼 출력한다
		
		Scanner sc=new Scanner(System.in);
		int inwon;
		String empName;
		Emp[] emp;
		
		System.out.println("회사이름 입력");
		empName=sc.nextLine();
		
		//회사이름을 static 멤버변수에 저장(초기화)
		Emp.setEmpName(empName);
		
		System.out.println("총 사원수 입력");
		inwon=Integer.parseInt(sc.nextLine()); //다음 질문이 문자가 오기 때문에 integer을 씀
		
		//inwon수 만큼 Emp배열이 할당이 됨
		emp=new Emp[inwon];
		
		//입력
		for(int i=0;i<inwon;i++)
		{
			emp[i]=new Emp(); //객체 생성
			System.out.println("사원명을 입력해주세요.");
			String name=sc.nextLine();
			System.out.println("월 급여를 입력해주세요.");
			int pay=Integer.parseInt(sc.nextLine());
			System.out.println("이번달 수당을 입력해주세요.");
			int sudang=Integer.parseInt(sc.nextLine()); //다시 맨처음인 문자로 돌아가기 때문에 integer
			
			//Emp객체에 값 저장하기_초기화
			emp[i].setName(name);
			emp[i].setPay(pay);
			emp[i].setSudang(sudang);
		}
		
		//출력
		System.out.println("회사명: "+Emp.getEmpName());
		System.out.println();
		
		System.out.println("사원명\t급여\t수당\t총급여");
		System.out.println("=================================");
		
		for(Emp e:emp)
			getEmpPay(e);
	}

}

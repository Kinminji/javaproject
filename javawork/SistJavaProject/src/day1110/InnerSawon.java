package day1110;

import java.util.Scanner;

class SawonOuter{
	
	private String sawonName;
	private int gibonPay,familySu,timeSu;
	
	//내부클래스 생성
	InputInner in=new InputInner();
	SudangInner su=new SudangInner();
	
	//내부클래스 처리하는 메서드
	public void process()
	{
		//데이터 입력
		in.inputDate();
		
		//데이터출력
		su.getSawon();
	}
	
	class InputInner{
		
		//사원 데이터 입력
		public void inputDate()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("사원 이름을 적어주세요.");
			sawonName=sc.nextLine();
			System.out.println("사원 기본급을 적어주세요.");
			gibonPay=sc.nextInt();
			System.out.println("초과 시간을 적어주세요.");
			timeSu=sc.nextInt();
			System.out.println("직계가족 수를 적어주세요.");
			familySu=sc.nextInt();
		}
		
	}
	
	class SudangInner{
		
		//시간외 수당
		public int getTotTimesu()
		{	
			return timeSu*20000;
		}
		//가족 수당
		public int getFamilysu()
		{
			if(familySu<=3)
				return 200000;
			else
				return 300000;
		}
		//실제급여
		public int totlaPay()
		{
			return gibonPay+getTotTimesu()+getFamilysu();
		}
		//전체출력
		public void getSawon()
		{
			System.out.println("사원명\t기본급\t초과시간수\t시간수당\t가족수\t가족수당\t실수령액");
			System.out.println("=====================================================================");
			
			System.out.println(sawonName+"\t"+gibonPay+"\t"+timeSu+"\t"+getTotTimesu()+"\t"+familySu+"\t"+getFamilysu()+"\t"+totlaPay());
		}
	}
	
}

public class InnerSawon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//내부클래스를 외부에서 생성후 메서드로 만들어서 호출
		SawonOuter sawon=new SawonOuter();
//		sawon.process();
		
		//외부클래스 통해서 내부클래스로 이동후 각각의 메서드 호출
		SawonOuter.InputInner in=sawon.new InputInner();
		SawonOuter.SudangInner su=sawon.new SudangInner();
		in.inputDate();
		su.getSawon();
		

	}

}

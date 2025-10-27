package day1025;

import java.util.Scanner;

public class ArrayBooleanWijle_08 {

	public static void main(String[] args) {
		//숫자배열을 생성과 동시에 초기화
		//해당숫자가 몇번째 있는지 출력, 숫자가 없으면 없다라고 출력
		//찾는 숫자를 입력하여 해당숫자의 유무, 순번 등을 출력...
		//반복문을 입력하여 0을 입력할때까지 계속할 수 있다.

		int[] numData= {98,3,12,95,10,25,93,01,26};

		Scanner sc=new Scanner(System.in);
		boolean flag;
		int su;
		
		while(true) {
			System.out.println("검색할 숫자는?");
			su=sc.nextInt();
			
			if(su==0)
				break;
			
			flag=false; //찾아서 있을때 true라고 변경할 예정
			
			for(int i=0;i<numData.length;i++) {
				if(su==numData[i])
				{
					flag=true;
					System.out.println(i+1+"번째에서 검색되었습니다.");
				}
			}
		
			if(!flag)//flag==flase 
			{
				System.out.println("입력하신 숫자는 데이터에 없습니다.");
			}
			
		}
		
	}

}

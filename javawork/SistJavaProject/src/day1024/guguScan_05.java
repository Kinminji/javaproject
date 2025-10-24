package day1024;

import java.util.Scanner;

public class guguScan_05 {

	public static void main(String[] args) {
		// 원하는 단을 입력해서 해당 단만 출력해보자.
		//단을 입력하시오 : 5
		//[5단] 5X1=5...5X9=45

		Scanner sc=new Scanner(System.in);

		int gu;

		while(true) {

			System.out.println("단을 입력하시오.(0이면 종료)");
			gu=sc.nextInt();
			
			//종료조건
			if(gu==0)
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			//2~9사이의 숫자만 넣어주세요.
			if(gu<2 || gu>9) {
				System.out.println("2~9사이의 숫자만 넣어주세요.");
				continue;
			}
			
			System.out.println("["+gu+"단]");

			for(int i=1;i<=9;i++) {
				System.out.println(gu+"X"+i+"="+gu*i);
			}
			
			System.out.println();
		}
	}

}

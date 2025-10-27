package day1025;

import java.util.Scanner;

public class ArrayIntScan_04 {

	public static void main(String[] args) {
		// 정수를 입력받아 입력받은 그 수를 출력, 합계도 구해보자
		//입력도 출력도 모두 배열의 반복문 이용할것
		
		Scanner sc=new Scanner(System.in);
		
		int[] arrNum;
		int sum=0;
		arrNum=new int[5];
		
		//값입력
		
		for(int i=0;i<arrNum.length;i++) {
			System.out.print(i+"번째 값: ");
			arrNum[i]=sc.nextInt(); //배열은 무조건 순번이 있어야 하기에 [i]를 쓴다.
			
			//총합계

			sum+=arrNum[i];

		}
		
		//출력
		
		System.out.println("**입력한값 출력**_1:10");
		
		for(int j=0;j<arrNum.length;j++) {
			System.out.println((j+1)+":"+arrNum[j]);
		}
		
		System.out.println("총합계:"+sum);

		
		System.out.println("=========================================");
		
		// 정수를 입력받아 입력받은 그 수를 출력, 합계도 구해보자
		//입력도 출력도 모두 배열의 반복문 이용할것
		
		int[] num;
		int sume=0;
		num=new int[4];
		
		for(int i=0;i<num.length;i++) {
			System.out.print(i+"번째 값: ");
			num[i]=sc.nextInt();
			
			sume+=num[i];
		}
		
		for(int i=0;i<num.length;i++) {
			System.out.println((i+1)+":"+num[i]);
		}
		
		System.out.println("총합계:"+sume);
		
	}

}

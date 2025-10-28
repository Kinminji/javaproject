package day1028;

import java.util.Scanner;

public class ArrayLottoQuiz_03 {

	public static void main(String[] args) {
		// 몇장을 구입할지 입력 후 로또를 출력할것--중복체크, 오름차순
		//몇장구입을 원하시나요?
		//2
		//1회 : ...
		//2회: ...
		
		main1();
//		main2();
		
	}

	public static void main1() {
		
		Scanner sc=new Scanner(System.in);
		
		int[] lotto=new int[6];
		int buysu;
		
		System.out.println("몇장을 구입하실건가요?");
		buysu=sc.nextInt();
		
		for(int b=0;b<buysu;b++) {
			
			for(int i=0;i<lotto.length;i++) {
				lotto[i]=(int)(Math.random()*45)+1;

				//중복처리
				for(int j=0;j<i;j++) {
					if(lotto[i]==lotto[j]) {
						i--;
						break;
					}
				}
			}

			//오름차순
			for(int i=0;i<lotto.length-1;i++) {
				for(int j=i+1;j<lotto.length;j++) {
					if(lotto[i]>lotto[j]) {
						int temp=lotto[i];
						lotto[i]=lotto[j];
						lotto[j]=temp;
					}
				}
			}

			for(int i=0;i<lotto.length;i++) {
				System.out.println(i+1+"번째 번호: "+lotto[i]);
			}
		}
		
		
	}
	public static void main2() {
		Scanner sc=new Scanner(System.in);

		int what;
		int[] lotto=new int[6];
		
		System.out.println("몇장을 구입하실건가요?");
		what=sc.nextInt();
		
		for(int a=0; a<what;a++) {
			System.out.print(a+1+"회");
			
			for(int i=0;i<lotto.length;i++) {
				lotto[i]=(int)(Math.random()*45)+1;

				//중복처리
				for(int j=0;j<i;j++) {
					if(lotto[i]==lotto[j]) {
						i--;
						break;
					}
				}
			}

			//오름차순
			for(int i=0;i<lotto.length-1;i++) {
				for(int j=i+1;j<lotto.length;j++) {
					if(lotto[i]>lotto[j]) {
						int temp=lotto[i];
						lotto[i]=lotto[j];
						lotto[j]=temp;
					}
				}
			}

			for(int i=0;i<lotto.length;i++) {
				System.out.println(i+1+"번째 번호: "+lotto[i]);
			}
		}
	}
}


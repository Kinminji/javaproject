package day1023;

import java.util.Scanner;

public class ForSum_09 {

	public static void main(String[] args) {
		// 1~10까지 
		
		int sum=0;
		
		for(int i=1;i<=10;i++) {
			sum+=i; //sum=sum+i
		}
		System.out.println("1부터 10까지의 합은"+sum+"입니다.");
		
		
		//1~10까지 합계 while
		int a=1; //초기값
		int tot=0; //합계
		
		while(a<=10) {
//			tot=tot+a; //합계변수에 a를 누적 시킨다.
			tot+=a;
			a++;
		}
		System.out.println("while문 1부터 10까지의 합은"+tot+"입니다.");
		
		
		//1~10까지 2씩 증가하며 더해보자.
		
		int hol=0;
		
		for(int i=1;i<=10;i+=2) {
			hol+=i;
		}
		System.out.println("1부터 10까지 2씩증가한 합은"+hol+"입니다.");
			
		System.out.println();
		
		int total=0;
		for(int n=1;n<=10;n+=2) {
			total+=n;
		}
		System.out.println("총합계는"+total);
		
		//팩토리얼
		//1!=1
		//2!=2
		//3!=3*2=6
		//4!=4*3*2=24
		
		//1~10까지의 팩토리얼 구하기
		
		int result=1;
		for(int j=1; j<=10; j++) {
			result*=j;//
			System.out.println(j+"!="+result);
		}
		
		//입력한 숫자의 팩토리얼을 구하시오
		Scanner sc=new Scanner(System.in);
		int name;
		int b=1;
		
		System.out.println("숫자를 입력하시오.");
		name=sc. nextInt();
		
		int j=1;
		for(;j<=name;j++) {
			b*=j;
		}
		System.out.println((j-1)+"!"+b);
		
		//빠져 나와서 써야 반복문에서 벗어나니까 원하는 숫자의 결과값만 나타내기 위해선 for문{}밖에서 쓰기
		
		
		
	}

}

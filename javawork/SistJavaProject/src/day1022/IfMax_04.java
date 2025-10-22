package day1022;

import java.util.Scanner;

public class IfMax_04 {
	public static void main(String[] args) {
		//3개의 숫자를 입력하여 max값 min값을 구해보세요
		//if문이용
		//3개의 숫자중 가장 큰 수는 **입니다.
		
		Scanner sc=new Scanner(System.in);
		int x,y,z,max,min;
		
		System.out.println("3개의 숫자를 입력하시오");
		x=sc.nextInt();
		y=sc.nextInt();
		z=sc.nextInt();
		
		System.out.println("입력한 세 수는"+x+","+y+","+z+"입니다.");
		
		//if
		System.out.println("**if문**");
//		if(x>y&&z>y)
//		max=y;
//		else if

		if(x>y && x>z)
			max=x;
		else if(y>x && y>z)
			max=y;
		else
			max=z;
		System.out.println("Max값은"+max);
			
		System.out.println("**삼항연산자**");
		max=x>y&&x>z?x:y>x&&y>z?y:z;
		System.out.println("Max="+max);
		
		//if or 삼항연산자 이용하여 min값 구하기
		
		System.out.println("*if문*");
		if(x<y && x<z)
			min=x;
		else if(y<z && y<x)
			min=y;
		else
			min=z;
		System.out.println("Min값은"+min);
		
		System.out.println("*삼향연산자*");
		min=x<y&&x<z?x:y<x&&y<z?y:z;
		System.out.println("Min="+min);
		
		
		
	}

}

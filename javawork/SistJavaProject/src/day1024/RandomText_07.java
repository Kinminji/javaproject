package day1024;

public class RandomText_07 {
public static void main(String[] args) {
	//자바에서 난수를 구하는 방법2가지
	//1. Math.random() 메서드 활용
	//2. Random 클래스를 생성해서 구하는 방법
	
	//10개의 난수를 발생
	System.out.println("10개의 난수를 발생");
	
	for(int i=1;i<=10;i++) 
	{
		double n=Math.random();//0.0~1.0 미만
		System.out.println(n);
	}
	
	System.out.println();
	
	System.out.println("0~9까지 정수를 발생");
	
	for(int i=1;i<=10;i++)
	{
		double n=(int)(Math.random()*10); //int형으로 만들기 위해 앞에 (int)를 넣고 정수로 만들기 위해 *10을 함
		System.out.println(n);
	}
	
	System.out.println();
	
	System.out.println("0~99까지 난수를 발생");
	
	for(int i=1;i<=10;i++)
	{
		double n=(int)(Math.random()*100);
		System.out.println(n);
	}
	
	System.out.println();
	
	System.out.println("1~10까지의 난수를 발생");
	
	for(int i=1;i<=10;i++)
	{
		double n=(int)(Math.random()*10+1);
		System.out.println(n);
	}

	System.out.println();
	
	System.out.println("0~100까지 난수를 발생");
	
	for(int i=0;i<=10;i++)
	{
		double n=(int)(Math.random()*100+1);
		System.out.println(n);
	}
	
	System.out.println();
	
	System.out.println("1~45까지 난수를 발생");
	
	for(int i=1;i<=10;i++)
	{
		double n=(int)(Math.random()*45);
		System.out.println(n);
	}
	
}
}

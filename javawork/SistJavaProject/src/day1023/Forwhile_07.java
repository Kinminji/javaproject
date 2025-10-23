package day1023;

public class Forwhile_07 {
public static void main(String[] args) {
	//1~10까지 반복출력_for
	
	for(int i=1; i<=10; i++)
	{
		System.out.print(i+" ");
	}
	System.out.println();
	
	//1~10까지 반복출력_for
	
	int n=0;
	 while(n<10)
	 {
		 n++;
		 System.out.println(n); //1~
	 }
	 System.out.println();
	 
	 int a=1;
	 while(a<=10) {
		 System.out.printf("%4d",a++);//printf(%nd)는 4자리 만큼 띄워서 정렬
	 }
	 System.out.println();
	//int 다음에 n을 0으로 둘때는 10보다 작다
//	 n을 1로 둘때는 10보다 작거나 같다
	 
	 for(int i=10;i>=1;i--)
	{
		 System.out.printf("%5d",i);
	}
	 System.out.println();
	 //while(true)조건비교가 true일 동안
	 //반드시 비교문을 while문 안에 넣어서 빠져나와야 한다
	 //break문으로 빠져나오기도 가능
	 
	 int b=1;
	 while(true)
	 {
		 System.out.printf("%4d",b++);
		 if(b>10)
			 break;//무한루프
	 }
	 
	 System.out.println();
	 
	 //for문으로 1.4.7.10출력
	 
	 for(int i=1; i<=10;i+=3)
	 {
		 System.out.printf("%4d",i);
	 }
	 System.out.println();
	 
	 //5,4,3,2,1
	 
	 for(int i=5; i>=1; i--) {
		 System.out.printf("%4d",i);
	 }
	 System.out.println();
	 
	 //5,4,3,2,1 while
	 
	 int s=5;
	 while(s>0)
	 {
		 System.out.printf("%4d",s--);
	 }
	 System.out.println();
	 //hello 를 가로방향으로 5번 출력하시오_for
	 
	 for(int i=1;i<=5;i++)
	 {
		 System.out.printf("hello"+i);
	 }
	 
	 System.out.println();
	 
	 
}
}

package day1023;

public class ForWhile_08 {
public static void main(String[] args) {
	//조건에 안맞으면 한번도 반복안함
	
	for(int i=5;i<=1;i++)
	{
		System.out.println(i);
	}//i가 1보다 작을때 인데 1씩 증가하고 i는 5이므로 조건이 맞지 않아 반복안함
	
	//for문밖에서 i값을 출력하고 싶을때
	
	int i;
	for(i=10;i<=50;i+=5) {
		System.out.println(i); //10부터 5씩 증가하면서 50까지 나타남
	}
	System.out.println("/n빠져나온후의 i값:"+i);
	
	//int를 위에 한번 쓰고 for 안에 int는 쓰지 않는다.
	
	int d=10;
	for(;d<=50;d+=5) {
		System.out.println(d); //10부터 5씩 증가하면서 50까지 나타남
	}
	System.out.println("/n빠져나온후의 d값:"+d);
	//int에 i=10을 이미 썼을 경우는 for안에는 없애긴 하는데 빈공간이라도 있다 생각하여 ;은 써야함
	
	//1~10까지중에서 짝수만 출력하기
	for(int n=1;n<=10;n++)
	{
		if(n%2==0)
			System.out.printf("%4d",n);
	}
	System.out.println();
	
	//1~10까지 중에서 홀수만 출력하기
	
	for(int n=1; n<=10; n++)
	{
		if(n%2==1)
			System.out.printf("%4d",n);
	}
	System.out.println();
	
	//1~10 뒤에 hello붙혀서 출력
	for(int a=1; a<=10; a++)
	{
		System.out.println(a+"hell0");
	}
	System.out.println("for문을 빠져나와 종료!");
	
}
}

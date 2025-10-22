package day1021;

public class OperTest_10 {

	public static void main(String[] args) {
		// 증감연산자 ++,--

		int a,b;
		a=b=5;
		
		//단항일경우 앞에붙히나 뒤에붙히나 같다
		++a; //원래 a값에서 1증가
		b++; //b=b+1
		
		System.out.println("a="+a+",b="+b);
		
		//수식에서 사용할때는 전치,후치 결과값이 틀리다
		int m,n;
		n=m=0;
		a=b=5;
		
		m=a++; //후치일경우는 먼저 대입후 증가
		System.out.println("m="+m+", a="+a);  //m=5, a=6
		
		n=++b; //전치일경우는 먼저 증가후 대입
		System.out.println("n="+n+", b="+b); //n=6, b=6
		
		
	}

}

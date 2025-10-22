package day1021;

public class DataType_02 {

	public static void main(String[] args) {
		// 강제 형변환(cast연산자) 
		
		int x=7;
		int y=4;
		
		System.out.println(x/y); //1 :정수형끼리의 계산결과는 무조건 정수int
		System.out.println((double)x/y); //계산시 x를 double로 변환해서계산:결과는 double
		System.out.println(x/(double)y); //수식중에 한개라도 double있을경우 결과는 double
		
		double d=100.0;
		int i=100;
		int result=(int)d+i;
		double result2=d+i;
		//double result2=(double)d+i;
		
		System.out.println("result="+result);
		System.out.println("result2="+result2);
		
		
		
	}

}

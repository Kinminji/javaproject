package day1021;

public class DataType_03 {

	public static void main(String[] args) {
		// 묵시적 형변환: 자동으로 결정되는 타입
		
		//String+int=String
		//double+int=double
		//long+short=long
		//char+int=int
		
		char a='A';//65    a=97
		
		System.out.println(a);
		System.out.println(a+32); //97
		System.out.println(a+2);
		System.out.println((char)(a+32));
		System.out.println((char)(a+2));
		
		System.out.println("A"+(5+6));
		System.out.println('A'+3);
		System.out.println(2+'b');
		System.out.println('a'+'b'); //97+98=195

	}

}

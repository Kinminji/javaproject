package day1105;

public class Ex5ArrayException {

	public static void main(String[] args) {
		// 배열범위에 관한 익셉션
		
		String [] str= {"Apple","Banana","Orange","Kiwi","Mellon"};
		
		System.out.println("차례대로 출력");
		
		for(int i=0;i<=str.length;i++)
		{
			try
			{
			System.out.println(str[i]);
			} catch (Exception e) {
				System.out.println("배열요구: "+e.getMessage());
			}
		}
		
		System.out.println("거꾸로 출력");
		for(int i=str.length;i>=0;i--) {
			try
			{
			System.out.println(str[i]);
			} catch (Exception e) {
				System.out.println("거꾸로 배열출력중 오류: "+ e.getMessage());
			}
		}
		
		System.out.println("프로그램종료.");

	}

}

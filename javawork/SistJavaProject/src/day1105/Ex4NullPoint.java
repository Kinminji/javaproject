package day1105;

import java.util.Date;

public class Ex4NullPoint {

	Date date; //선언
	
	public void writeday()
	{
		int y,m,d;
		
		try
		{
		y=date.getYear()-1990;
		m=date.getMonth()+1;
		d=date.getDate();
		
		System.out.println(y+"년"+m+"월"+d+"일 입니다.");
		} catch (NullPointerException e) {
			System.out.println("객체생성을 하지 않았습니다." + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		Ex4NullPoint day=new Ex4NullPoint();
		day.writeday();
		
		System.out.println("정상종료");

	}

}

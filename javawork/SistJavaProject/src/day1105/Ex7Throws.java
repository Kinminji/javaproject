package day1105;

import java.util.Scanner;

//throws:호출한 영역으로 예외처리 던짐
//throw:강제로 예외를 발생시킬때

public class Ex7Throws {
	
	//메서드
	public static void scoreInput() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int score=0;
		
		//점수가 1~100점사이 아니면 익셉션 발생
		System.out.println("점수를 입력해주세요.");
		score=sc.nextInt();
		
		if(score<1 || score>100)
		{
			throw new Exception("점수가 잘못입력되었습니다.");
		}
		else {
			System.out.println("나의 점수: "+score+"점");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			scoreInput();
		} catch (Exception e) {

//			e.printStackTrace();
			System.out.println("오류발생: "+e.getMessage());
		}
		System.out.println("종료");

	}

}

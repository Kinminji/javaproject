package day1021;

public class ArgsQuiz_06 {

	public static void main(String[] args) {
		// 변수는 알아서 ..국어,영어,수학 점수를 매개변수(args)로 입력후 
		//총점과 평균을 구하시오
		//단 평균은 소수점 2자리로 구할것
		/*
		 이름: 홍길동
		 국어점수:**점
		 수학점수:**점
		 영어점수:**점
		 총점:***점
		 평균:**.**점
		 */
		
		//변수선언
		String name=args[0];
		System.out.println(args[1]+args[2]+args[3]);
		
		int kor=Integer.parseInt(args[1]);
		int mat=Integer.parseInt(args[2]);
		int eng=Integer.parseInt(args[3]);
		
		//계산
		int tot=kor+mat+eng;
		double avg=tot/3.0;
		
		//출력
		System.out.println("이름: "+name);
		System.out.println("국어점수: "+kor);
		System.out.println("수학점수: "+mat);
		System.out.println("영어점수: "+eng);
		System.out.println("총점: "+tot+"점");
		System.out.println("평균: "+avg+"점");
		
		System.out.printf("평균: %.2f점",avg);
		

	}

}

package day1030;

class Student{
	
	private String name;
	private String Phone;
	private int score;
	
	
	//명시적생성자(3개를 한번에 메서드)
		public Student(String name, String ph, int score) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.Phone=ph;
		this.score=score;
		}
	
		
	//출력메서드
		public void getStudentScore()
	{
		System.out.println("이름: "+name);
		System.out.println("핸드폰: "+this.Phone);
		System.out.println("점수: "+this.score);
	}
}

public class Ex5ArrayObject {

	public static void main(String[] args) {
		// 배열로 생성해서 출력!!
		
		
		//배열없이
		Student st=new Student("김민지", "010-****-****", 89);
		st.getStudentScore();
		Student st1=new Student("강지수", "010-****-****", 95);
		st1.getStudentScore();
		Student st2=new Student("최서우", "010-****-****", 72);
		st2.getStudentScore();

		System.out.println();
		
		System.out.println("반복문으로 출력 메서드 호출");
		
		//배열
		//1. 먼저 배열선언으로 갯수를 할당받고 그 갯수 만큼 초기화
		//2. 배열선언과 동시에 초기화
		
//		Student[] stu=new Student[3];
//		stu[0]=new Student("김민지", "010-****-****", 89);
//		stu[1]=new Student("강지수", "010-****-****", 95);
//		stu[2]=new Student("최서우", "010-****-****", 72);
		
		Student[] stud= {
				new Student("홍길동", "010-5555-5555", 89),
				new Student("이미영", "010-5555-5555", 95),
				new Student("김구라", "010-5555-5555", 72)
		};
		
		//반복문 출력
		for(int i=0; i<stud.length;i++) 
		{
			stud[i].getStudentScore();
		}
		
		
		
		System.out.println();
		System.out.println("for~each로도 출력가능");
		
		for(Student s:stud)
		{
			s.getStudentScore();
		}
		
		
	}

}

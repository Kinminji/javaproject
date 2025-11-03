package day1031;

class School{
	
	private String addr;
	private int countStu;
	private int countteacher;
	
	public static final String SCHOOLNAME="쌍용고등학교";



//멤버 하나하나를 수정 또는 출력하고 싶을 수 있으니까
	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public int getCountStu() {
		return countStu;
	}


	public void setCountStu(int countStu) {
		this.countStu = countStu;
	}
	
	
	public int getCountteacher() {
		return countteacher;
	}



	public void setCountteacher(int countteacher) {
		this.countteacher = countteacher;
	}


	
	

	public School() {
		
		addr="서울특별시 강남구 대치동";
		countStu=250;
		countteacher=10;
		
	}
	
	public School(String addr, int cntstu, int cnttea) {
		
		this.addr=addr;
		this.countStu=cntstu;
		this.countteacher=cnttea;
		
	}
	
	public void writeDate()
	{
		System.out.println("학교주소: "+ addr);
		System.out.println("학생수: "+countStu);
		System.out.println("교사수: "+countteacher);
	}
	
	
	
}


class Student extends School{
	
	String studentName;
	int grade;
	
	public Student() {
		
		studentName="김민지";
		grade=1;
		
	}
	
	public Student(String a, int stu, int tea, String stuname, int grade) {

		super(a, stu, tea);
		this.studentName=stuname;
		this.grade=grade;
		
	}
	
	@Override
	public void writeDate() {
		// TODO Auto-generated method stub
		super.writeDate();
		System.out.println("학생이름: "+ studentName);
		System.out.println(grade+"학년");
	}

	
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	}

public class Ex5Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. 디폴트 생성자로 생성후 메서드 호출
		
		//2. 명시적 생성자로 생성후 메서드 호출
		
		//3. 1번째의 학생명과 점수만 변경후 메서드 호출
		
		
		
		Student st1=new Student();
		st1.writeDate();
		
		System.out.println();
		
		Student st2=new Student("서울특별시 광진구 자양동", 220, 7, "김지수", 3);
		st2.writeDate();
		
		System.out.println();
		
		Student st3=new Student();
		st3.setStudentName("엄혜지");
		st3.setGrade(2);
		st3.writeDate();
		
		
	}

}

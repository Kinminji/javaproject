package day1029;

public class Ex3Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex3Student.schoolName="쌍용교육센터";
		
		//학생 두명의 정보를 초기화
		Ex3Student a1=new Ex3Student();
		a1.name="박성진";
		a1.age=33;
		
		Ex3Student a2=new Ex3Student();
		a2.name="강영현";
		a2.age=33;
		
		System.out.println("학교명: "+Ex3Student.schoolName);
		System.out.println("이름: "+a1.name+", 나이: "+a1.age);
		System.out.println("이름: "+a2.name+", 나이: "+a2.age);
		
	}

}

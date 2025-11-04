package day1104;

//241~244pg
abstract class Student{
	
	String name;
	int score;
	
	Student(String name, int score)
	{
		this.name=name;
		this.score=score;
	}
	 
	//추상메서드 선언
	abstract void examTake();
	abstract void examSolve();
	abstract void examSubmit();
}

//sub
class highStudent extends Student{
	
	highStudent(String name, int score)
	{
		super(name,score);
	}
	
	void examTake()
	{
		System.out.println(name+"가 교실에서 시험지를 받는다.");
	}
	
	void examSolve()
	{
		System.out.println(name+"가 교실에서 문제를 푼다.");
	}
	
	void examSubmit()
	{
		System.out.println(name+"가 교실에서 시험지를 제출한다.");
	}
	
}

public class Book_241 {

	public static void main(String[] args) {
		
		highStudent kim=new highStudent("김민지", 87);
		kim.examTake();
		kim.examSolve();
		kim.examSubmit();
	}

}

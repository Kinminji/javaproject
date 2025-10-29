package day1029;

public class Ex9Test {

	private String stuName;
	private int grade;
	static String schoolName;
	
	public void setName(String stuName)
	{
		this.stuName=stuName;
	}
	public void setgrade(int grade) {
		this.grade=grade;
	}
	
	
	public String getName()
	{
		return stuName;
	}
	public int getgrade() {
		return grade;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		schoolName="쌍용고등학교";
		
		Ex9Test name=new Ex9Test();
		name.stuName="박성진";
		name.grade=4;
		
		System.out.println(Ex9Test.schoolName);
		System.out.println(name.grade+"학년");
		System.out.println("학생이름: "+ name.stuName);


	}

}

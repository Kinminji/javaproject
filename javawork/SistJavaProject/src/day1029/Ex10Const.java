package day1029;

class StuInfo
{
	private String stuName;
	private String major;
	private int grade;
	
	//명시적 생성자
	public StuInfo(String sname, String mj, int grade) {
		
		stuName=sname;
		major=mj;
		this.grade=grade;
			
	}
	//getter메서드
	public String getstuName()
	{
		return stuName;
	}
	public String getmajor()
	{
		return major;
	}
	public int getgrade()
	{
		return grade;
	}
}

///////////////////////
public class Ex10Const {

	public static void main(String[] args) {
		//생성과 동시에 초기화해주었으므로
		//setter메서드의 역할까지 해준것
		
		StuInfo stu1=new StuInfo("강영현", "경영학과", 3);
		
		String sname=stu1.getstuName();
		String mj=stu1.getmajor();
		int grade=stu1.getgrade();
		
		System.out.println(sname+" "+mj+" "+grade+"학년");

	}

}

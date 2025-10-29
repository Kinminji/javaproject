package day1029;


/////////////////////////////////
public class Quiz {

	static String schoolName;
	private String name;
	private String major;
	private int grade;
	
	public void setname(String name)
	{
		this.name=name;
	}
	public void setmajor(String major)
	{
		this.major=major;
	}
	public void setgrade(int grade)
	{
		this.grade=grade;
	}
	
	
	public String getname() {
		return name;
	}
	public String getmajor() {
		return major;
	}
	public int getgrade() {
		return grade;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Quiz.schoolName="명지대학교";
		
		Quiz my=new Quiz();
		my.name="김민지";
		my.major="식품영양학과";
		my.grade=3;
		
		String sname=my.name;
		String smj=my.major;
		int sgr=my.grade;
		
		System.out.println(schoolName+smj+sname+sgr);
		
	}

}

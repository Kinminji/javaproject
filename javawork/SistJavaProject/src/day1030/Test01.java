package day1030;

class test{
	
	private String stuName;
	private int java;
	private int oracle;
	
	static final String title="자바오라클 중간시험";

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}

	public static String getTitle() {
		return title;
	}
	
	public int getsum() {
		int sum=this.java+this.oracle;
		return sum;
	}
	
	public double getavg() {
		double avg=getsum()/2;
		return avg;
	}
	
	
	
	
	
	private String writer;
	private String subject;
	
	private static String comment="계시판 작성하는 날";

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public static String getComment() {
		return comment;
	}

	public static void setComment(String comment) {
		test.comment = comment;
	}
	
	
	
	
}

public class Test01 {
	
	public static void name(test n) {
		
		System.out.println("**Board 클래스 출력**");
		System.out.println(n.getWriter());
		System.out.println(n.getSubject());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		test s=new test();
		s.setStuName("김민지");
		s.setJava(89);
		s.setOracle(75);
		int sum=s.getsum();
		double avg=s.getavg();
		
		System.out.println("이름: "+s.getStuName());
		System.out.println("자바점수: "+s.getJava());
		System.out.println("오라클점수: "+s.getOracle());
		System.out.println("합계: "+ sum);
		System.out.println("평균: "+avg);
		
		System.out.println();
		
		test b=new test();
		System.out.println(b.getComment());
		
		b.setWriter("조예은");
		b.setSubject("입속의 지느러미");
		
		name(b);
		

	}

}

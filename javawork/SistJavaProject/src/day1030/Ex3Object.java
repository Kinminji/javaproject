package day1030;

class StuScore{
	
	private String stuName;
	private int java;
	private int oracle;
	
	static final String title="자바오라클 중간시험";
	
	//각각의 setter, getter

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
	

	//합계
	
	static int sum=0;
	
	
	//선생님버전
	public int getTot() {
		int s=this.java+this.oracle;
		return s;
	}
	
	//평균
	
	static double avg=0;
	
	
	//선생님버전
	public double getAvg() {
		double d=this.getTot()/2;
		return d;
	}
	
}

public class Ex3Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StuScore my=new StuScore();
		my.setStuName("박호준");
		my.setJava(87);
		my.setOracle(99);
		my.sum=my.getJava()+my.getOracle();
		my.avg=my.sum/2;
		
		//선생님버전
		int sum=my.getTot();
		double avg=my.getAvg();
		
		System.out.println("자바 오라클 중간시험");
		System.out.println("이름: "+my.getStuName());
		System.out.println("자바점수: "+my.getJava()+"점");
		System.out.println("오라클점수: "+my.getOracle()+"점");
		System.out.println("합계: "+my.sum+"점");
		System.out.println("평균: "+my.avg+"점");
		System.out.println();
		
		//선생님버전
		System.out.println("==선생님 버전==");
		System.out.println("합계: "+sum+"점");
		System.out.println("평균: "+avg+"점");

	}

}

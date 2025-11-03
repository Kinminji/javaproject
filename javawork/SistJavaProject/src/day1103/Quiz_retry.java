package day1103;

import java.util.Scanner;

class StudentInf{
	private String name;
	private int java;
	private int html;
	
	public static String schoolname="쌍용고등학교";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}
	
	public int getTotal() {
		int sum=this.java+this.html;
		return sum;
	}
	public double getAvarage() {
		double avg=getTotal()/2;
		return avg;
	}
	
	public String getPungga() {
		if(getAvarage()>=90)
			return "장학생";
		else if(getAvarage()>=80)
			return "합격";
		else
			return "불합격";
	}
	
}

public class Quiz_retry {
	
	public static void Student(StudentInf s) {
		System.out.println(s.getName()+"\t"+s.getJava()+"\t"+s.getHtml()+"\t"+s.getTotal()+"\t"+s.getAvarage()+"\t"+s.getPungga());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name;
		int java;
		int html;
		int inwon;
		StudentInf[] stu;
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("학생수를 입력하세요.");
		inwon=Integer.parseInt(sc.nextLine());
		
		stu=new StudentInf[inwon];
		
		for(int i=0;i<inwon;i++) {
			stu[i]=new StudentInf();
			System.out.println(i+"학생이름");
			name=sc.nextLine();
			System.out.println("자바와 HTML 점수 입력해주세요.");
			java=Integer.parseInt(sc.nextLine());
			html=Integer.parseInt(sc.nextLine());
			
			stu[i].setName(name);
			stu[i].setJava(java);
			stu[i].setHtml(html);
			
			int sum=stu[i].getTotal();
			double avg=stu[i].getAvarage();
			String pung=stu[i].getPungga();
			
		}
		
		System.out.println("============결과 출력============");
		System.out.println("학교명:"+StudentInf.schoolname);
		System.out.println("학생명\tJAVA\tHTML\t총점\t평균\t평가");
		System.out.println("---------------------------------------------------");
		
		for(StudentInf s:stu) {
			Student(s);
		}

	}

}

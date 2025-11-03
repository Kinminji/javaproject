package day1103;

import java.util.Scanner;

class StudentInfo{
	private String name;
	private int java;
	private int html;
	
	static String schoolName="청담고등학교";

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
	
//	int sum=0;
//	double avg=0;
	
	public int getTotla() {
		int s=this.java+this.html;
		return s;
	}
	
	public double getAverage() {
		double avg=getTotla()/2;
		return avg;
	}

	public String getPungga() {
		if(getAverage()>=90) {
			return "장학생";
		}
		else if(getAverage()>=80) {
			return "합격";
		}
		else {
			return "불합격";
		}
	
	}


	
}

public class Quiz {
	
	public static void EmpStuden (StudentInfo e) {
		System.out.println(e.getName()+"\t"+e.getJava()+"\t"+e.getHtml()+"\t"+e.getTotla()+"\t"+e.getAverage()+"\t"+e.getPungga());
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name;
		int java;
		int html;
		int inwon;
		StudentInfo[] emp;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("학생수를 입력하시오.");
		inwon=Integer.parseInt(sc.nextLine());
		
		emp=new StudentInfo[inwon];
		
		for(int i=0;i<inwon;i++) {
			emp[i]=new StudentInfo();
			System.out.println(i+"번 학생이름");
			name=sc.nextLine();
			System.out.println("자바점수와 HTML 점수 입력");
			java=Integer.parseInt(sc.nextLine());
			html=Integer.parseInt(sc.nextLine());
			
			emp[i].setName(name);
			emp[i].setJava(java);
			emp[i].setHtml(html);
			
			int sum=emp[i].getTotla();
			double avg=emp[i].getAverage();
			String pung=emp[i].getPungga();
			
		}
		
		
		System.out.println("======결과출력======");
		System.out.println("학교명:"+StudentInfo.schoolName);
		System.out.println("학생명\tJAVA\tTHML\t총점\t평균\t평가");
		System.out.println("---------------------------------------------");
		
		for(StudentInfo e:emp) {
			EmpStuden(e);
		}

		
	}


}

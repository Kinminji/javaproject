package day1103;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

class Studentin{
	
	private String name;
	private int java;
	private int html;
	
	public static String schoolName="쌍용고등학교";

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
	public double getAverage() {
		double avg=getTotal()/2;
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

public class Quiz_reretry {
	
	public static void Student(Studentin s) {
		System.out.println(s.getName()+"\t"+s.getJava()+"\t"+s.getHtml()+"\t"+s.getTotal()+"\t"+s.getAverage()+"\t"+s.getPungga());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name;
		int java;
		int html;
		int inwon;
		Studentin[] stu;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("학생수를 입력해주세요.");
		inwon=Integer.parseInt(sc.nextLine());
		
		stu=new Studentin[inwon];
		
		for(int i=0;i<inwon;i++) {
			stu[i]=new Studentin();
			
			System.out.println(i+1+"번째 학생 이름을 적어주세요");
			name=sc.nextLine();
			System.out.println("JAVA와 HTML의 점수를 입력해주세요");
			java=Integer.parseInt(sc.nextLine());
			html=Integer.parseInt(sc.nextLine());
			
			stu[i].setName(name);
			stu[i].setJava(java);
			stu[i].setHtml(html);
			
			int sum=stu[i].getTotal();
			double avg=stu[i].getAverage();
			String pung=stu[i].getPungga();
		}
		
		System.out.println("==================결과 출력==================");
		System.out.println("학교명: "+Studentin.schoolName);
		System.out.println("학생명\tJAVA\tHTML\t총점\t평균\t평가");
		System.out.println("--------------------------------------------");
		
		for(Studentin s:stu) {
			Student(s);
		}

	}

}

package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex4FileWriteRead {

	static final String FILENAME="C:\\sist1017\\work\\file\\sungjuk.txt";
	FileWriter fw;
	FileReader fr;
	BufferedReader br;

	Scanner sc=new Scanner(System.in);

	public int getMenu()
	{
		int num=0;
		System.out.println("1.추가	2.전체출력		9.종료");
		num=Integer.parseInt(sc.nextLine());
		return num;
	}

	//정보입력해서 저장
	public void sungjukInput()
	{
		//이름과 점수만 입력
		System.out.println("학생 이름을 입력해주세요.");
		String name=sc.nextLine();
		System.out.println("점수를 입력해주세요.");
		int score=Integer.parseInt(sc.nextLine());

		try {
			fw=new FileWriter(FILENAME,true); //true는 누적시킨다는 뜻

			fw.write(name+"\n");
			fw.write(score+"\n");

			System.out.println("***학생정보 저장됨***");
			System.out.println();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//학생정보 출력
	public void sungjukOutput()
	{
		//제목
		System.out.println("***\t학생정보\t***");
		System.out.println("번호\t이름\t점수\t학점\t평가");
		System.out.println("------------------------------------");

		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);

			int num=0;

			while(true)
			{
				String name=br.readLine();

				if(name==null)
					break;
				
				int score=Integer.parseInt(br.readLine());
				
				char grade=getGrade(score);
				String pg=getpungga(score);
				
				System.out.println(++num+"\t"+name+"\t"+score+"\t"+grade+"\t"+pg);
			}
			
			System.out.println("***\t출력 완료\t***");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	//학점반환해 주는 메서드
	public char getGrade(int score)
	{
		char ch = 0;

		if(score>=90) {
			ch='A';
		}
		else if(score>=80) {
			ch='B';
		}
		else if(score>=70) {
			ch='C';
		}
		else if(score>=60) {
			ch='D';
		}
		else {
			ch='F';
		}

		return ch;
	}
	
	public String getpungga(int s)
	{
		String p=null;
		
		if(s>=90)
		{
			p="장학생";
		} else if(s>=80) {
			p="통과";
		} else {
			p="재수강";
		}
		
		return p;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4FileWriteRead frw=new Ex4FileWriteRead();

		//frw.getMenu();
		//		int num=frw.getMenu();

		//		if(num==1)
		//		{
		//			System.out.println();
		//			System.out.println("학생정보 입력");
		//			frw.sungjukInput();
		//		}

		while(true)
		{
			int num=frw.getMenu();

			switch(num)
			{
			case 1:
				System.out.println();
				System.out.println("학생정보 입력");
				frw.sungjukInput();
				break;
				
			case 2:
				System.out.println("전체학생 출력");
				frw.sungjukOutput();
				break;

			case 9:
				System.out.println("프로그램 종료");
				System.exit(0); //강제종료
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
		
	}

}

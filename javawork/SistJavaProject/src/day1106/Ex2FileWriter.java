package day1106;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

public class Ex2FileWriter {
	
	public static void fileWrite()
	{
		FileWriter fw=null;
		String fileName="C:\\sist1017\\work\\file\\test.txt";
		
		try {
			fw=new FileWriter(fileName); //파일새로생성(같은이름이 있더라도 새로생성)
			
			//파일에 내용추가
			fw.write("Have a Nice Day\n");
			fw.write(new Date(0).toString()); //문자열이 아닌것에 toString을 붙혀 문자열로 받겠다.
			
			System.out.println("**파일 저장 성공**");
			
		} catch (IOException e) {
			
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void fileWrite2() {
		
		FileWriter fw=null;
		String fileName2="C:\\sist1017\\work\\file\\test2.txt";
		
		try {
			fw=new FileWriter(fileName2, true);
			
			fw.write("내이름은 김민지 입니다.\n");
			fw.write("------------------------\n");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fileWrite();
		fileWrite2();
	}

}

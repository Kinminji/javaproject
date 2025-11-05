package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex8FileException {

	public static void read()
	{
		// 경로는 / 혹은 \\
		String fileName="C:\\sist1017\\work\\file\\start.txt";
		BufferedReader br=null;
		FileReader fr=null; //문자단위

		//읽기위해서 파일열기...생성
		try {
			fr=new FileReader(fileName);
			System.out.println("파일을 열었습니다.");

			br=new BufferedReader(fr);

			//여러줄을 읽을수있으므로 while(true)문으로 읽는다.
			while(true)
			{
				//메모장에서 내용을 한줄씩 읽는다
				String s=br.readLine();

				//마지막줄일경우 null값을 읽는다, null일경우 빠져나가기
				if(s==null)
					break;

				System.out.println(s);
			}
		}
		catch (FileNotFoundException e) {
			
		}catch (IOException e) {
			// INPUT OUTPUT 넣어주거나 빼와야 할 처리를 못읽지 못하게
		}finally {
			//익셉션이 발생을 하던 안하던 무조건 실행되는 영역
			//파일이나 DB자원을 반납
			//오픈한 순서의 거꾸로 닫는다.
			
			try {
				br.close();
				fr.close();
				System.out.println("파일에 대한 자원을 모두 닫았습니다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {

		read();
		System.out.println("**종료**");
		

	}

}

package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3ScanWriter {

	Scanner sc;
	FileWriter fw;
	static final String FILENAME="C:\\sist1017\\work\\file\\member2.txt";

	public Ex3ScanWriter() {
		sc=new Scanner(System.in);
	}

	public void fileWrite() {

		try {
			fw=new FileWriter(FILENAME,true);

			System.out.println("이름입력");
			String name=sc.nextLine();
			System.out.println("주소입력");
			String addr=sc.nextLine();
			System.out.println("핸드폰 입력");
			String hp=sc.nextLine();

			System.out.println("파일저장확인");

			fw.write(name+"\n");
			fw.write(addr+"\n");
			fw.write(hp+"\n");


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

	public void fileRead()
	{
		System.out.println("**member2 정보");
		System.out.println("이름\t주소\t핸드폰");
		System.out.println("===========================");

		FileReader fr=null;
		BufferedReader br=null;

		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);

			int num=0;

			while(true) {
				String name=br.readLine();

				if(name==null) {
					break;
				}
				String addr=br.readLine();
				String hp=br.readLine();

				System.out.println(++num+"\t"+name+"\t"+addr+"\t"+hp);
			}

			System.out.println("**출력 끝**");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3ScanWriter ex=new Ex3ScanWriter();

		//		ex.fileWrite();
		ex.fileRead();
	}

}

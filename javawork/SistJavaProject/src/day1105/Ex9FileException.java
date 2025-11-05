package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex9FileException {


	public static void ScoreRead() throws IOException,FileNotFoundException
	{
		String fileName="C:\\sist1017\\work\\file\\number.txt";
		FileReader fr=null;
		BufferedReader br=null;
		int cnt=0;
		int total=0;
		double avg=0;
		
		fr=new FileReader(fileName);
		br=new BufferedReader(fr);
		
		while(true)
		{
			String s=br.readLine();
			if(s==null)
				break;
			
			System.out.println(s);
			
			cnt++;
			total+=Integer.parseInt(s);
		}
		
		avg=total/cnt;
		
		System.out.println("총갯수: "+cnt);
		System.out.println("총점: "+total+"점");
		System.out.printf("평균:%.2f ",avg);
		
		
		br.close();
		fr.close();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ScoreRead();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

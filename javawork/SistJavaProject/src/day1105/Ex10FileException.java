package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex10FileException {
	
	public static void fileRead() throws IOException, FileNotFoundException
	{
		String fileName="C:\\sist1017\\work\\file\\menu.txt";
		FileReader fr=null;
		BufferedReader br=null;
		
		fr=new FileReader(fileName);
		br=new BufferedReader(fr);
		
		System.out.println("메뉴명\t가격\t맛평가");
		System.out.println("=======================");
		
		while(true)
		{
			String menu=br.readLine();
			if(menu==null)
				break;
			
			//split으로 분리
//			String[] foodData=menu.split(",");
			//배열 갯수만큼 반복해서 출력
//			System.out.println(foodData[0]+"\t"+foodData[1]+"\t"+foodData[2]);
			
			//StringTokenizer
			StringTokenizer st=new StringTokenizer(menu, ",");
			System.out.println(st.nextToken()+"\t"+st.nextToken()+"\t"+st.nextToken());
		}
		
		br.close();
		fr.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			fileRead();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex1sawonRead {
	
	public static void sawonRead()
	{
		String sawontxt="C:\\sist1017\\work\\file\\sawon.txt";
		BufferedReader br=null;
		FileReader fr=null;
		int num=1;
		
		try {
			fr=new FileReader(sawontxt);
			br=new BufferedReader(fr);
			
			System.out.println("***\t사원급여\t***");
			System.out.println("번호\t사원명\t기본급\t가족수\t초과근무시간\t가족수당\t시간수당\t총급여");
			System.out.println("-----------------------------------------------------------------------------");
			
			while(true)
			{
				String s=br.readLine();
				
				if(s==null) {
					break;
				}
				
				StringTokenizer st=new StringTokenizer(s,",");
				String name=st.nextToken();
				int gibonpay=Integer.parseInt(st.nextToken());
				int famsu=Integer.parseInt(st.nextToken());
				int timesu=Integer.parseInt(st.nextToken());
				
				int famSudang=famsu*30000;
				int timeSudang=timesu*20000;
				int totalPay=gibonpay+timeSudang+famSudang;
				
				num++;
				
				System.out.print(num+"번\t"+name+"\t"+gibonpay+"원\t");
				System.out.print(famsu+"\t"+timesu+"\t"+famSudang+"원\t");
				System.out.println(timeSudang+"\t"+totalPay);
				
			}
			
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {

			}
			
		}
		
		
		
	}

	public static void main(String[] args) {
		
		sawonRead();
	}

}

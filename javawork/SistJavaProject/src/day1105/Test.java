package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	
	public static void read(){
		String file="C:\\sist1017\\work\\file\\start.txt";
		BufferedReader br=null;
		FileReader fr=null;
		
		try {
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			
			while(true) {
				String s=br.readLine();
				
				if(s==null)
					break;
				
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {

		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		read();
		System.out.println("종료");
	}

}

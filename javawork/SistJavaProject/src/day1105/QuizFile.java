package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuizFile {

	public static void ipgoRead()
	{
		//번호 상품명 수량 가격 총금액
		//split 혹은 toknizer를 활용해서 출력

		String ipgo="C:\\sist1017\\work\\file\\sangpum.txt";
		FileReader fr=null;
		BufferedReader br=null;
		int no=1;

		try {
			fr=new FileReader(ipgo);
			br=new BufferedReader(fr);

			System.out.println("번호\t상품명\t수량\t금액\t총금액");
			System.out.println("===============================================");

			while(true)
			{
				String s=br.readLine();

				if(s==null)
					break;

				String[] ipgoData=s.split(":");
				
				int num=Integer.parseInt(ipgoData[1]);
				int tot=Integer.parseInt(ipgoData[2]);
				int sum=num*tot;
				
				System.out.println(no+"번"+"\t"+ipgoData[0]+"\t"+ipgoData[1]+"\t"+ipgoData[2]+"\t"+"총금액: "+sum+"원");

				no++;
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
		ipgoRead();


	}

}

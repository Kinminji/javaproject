package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex5QuizWriteRead {

	Scanner sc=new Scanner(System.in);
	static final String FILENAME="C:\\sist1017\\work\\file\\shop.txt";
	FileWriter fw;
	FileReader fr=null;
	BufferedReader br=null;

	//상품선택하는 메서드
	public int getProcess()
	{
		int num=0;
		System.out.println("***[메뉴] 	1.상품추가		 2.상품재고편황		 9.종료 ***");
		num=Integer.parseInt(sc.nextLine());

		return num;
	}

	//입력후 파일에 저장		아이폰12,5,1200000
	public void sangpumAdd()
	{
		System.out.println("상품명 입력");
		String sang=sc.nextLine();
		System.out.println("입고된 수량");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("입고된 가격");
		int dan=Integer.parseInt(sc.nextLine());
		

		//파일입력 생성
		try {
			fw=new FileWriter(FILENAME,true);

			//내용저장
			fw.write(sang+","+su+","+dan+"\n");

			System.out.println("**추가되었습니다.**");

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
	
	//출력
	//할인가격은 따로 메서도 만들어서 호출
	public void sangpumWrite()
	{
		//수량이 10개 이상이면 10프로 할인
		//번호	상품명	입고수량	가격		할인가격		총가격
		
		System.out.println("번호\t상품명\t입고수량\t가격\t할인가격\t총가격");
		System.out.println("=======================================================");
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			int n=0;
			
			while(true) {
				String sang=br.readLine();
				
				if(sang==null) {
					break;
				}
				String [] s=sang.split(",");
				String d=s[0];
				int su=Integer.parseInt(s[1]);
				int dan=Integer.parseInt(s[2]);
				int price=dan*su;
				int dcprice=getPersent(price, su);
				int netPrice=price-dcprice;
				n++;
				
				System.out.println(n+"\t"+d+"\t"+su+"\t"+dan+"\t"+dcprice+"\t"+netPrice);
			}
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
	
	
	public int getPersent(int price,int su)
	{
		int dc=0;
		
		if(su>=10) {
			dc=price/10;
		}
		
		return dc;
	}


	public static void main(String[] args) {
		Ex5QuizWriteRead ex=new Ex5QuizWriteRead();
		
		while(true)
		{
			int num=ex.getProcess();
			
			switch(num)
			{
			case 1:
				System.out.println("상품 정보 입력");
				ex.sangpumAdd();
				break;
			case 2:
				System.out.println("상품 정보 출력");
				ex.sangpumWrite();
				break;
			case 9:
				System.out.println("종료");
				System.exit(0);
			default:
				System.out.println("다시입력해주세요.");
				break;
			}
		}

	}

}

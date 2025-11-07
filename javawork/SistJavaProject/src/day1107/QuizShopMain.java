package day1107;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class QuizShopMain {
	
	List<QuizShop> list=new Vector<QuizShop>();
	
	//입력
	//상품,색상,제조사,수량,금액에 대해서 값을 입력받는다.
	//입력한 상품의 갯수를 출력해 본다.
	public void inPut() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("상품명");
		String name=sc.nextLine();
		System.out.println("색상");
		String color=sc.nextLine();
		System.out.println("제조사");
		String company=sc.nextLine();
		System.out.println("수량");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("금액");
		int price=Integer.parseInt(sc.nextLine());
		
		QuizShop shop=new QuizShop();
		shop.setSangpumName(name);
		shop.setColor(color);
		shop.setMadeCompany(company);
		shop.setSu(su);
		shop.setPrice(price);
		
		list.add(shop);
		System.out.println("저장된 데이터 갯수: "+list.size());
		
	}
	
	
	//출력
	//번호     상품명    색상    제조사    수량    가격    총금액
	public void outPut() {
		
		System.out.println("번호\t상품명\t색생\t제조사\t수량\t가격\t총금액");
		System.out.println("=================================");
		
		int num=0;
		for(int i=0;i<list.size();i++) {
			QuizShop q=list.get(i);
			int su=q.getSu();
			int price=q.getPrice();
			int tot=su*price;
			
			System.out.println(++num+"\t"+q.getSangpumName()+"\t"+q.getColor()+"\t"+q.getMadeCompany()+"\t"+su+"\t"+price+"\t"+tot);
			
		}
		
	}
	
	public int getTot(int su,int price) {
		int tot=0;
		tot=su*price;
		return tot;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuizShopMain qs=new QuizShopMain();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("1.입력     2.출력     3.종료");
			int num=Integer.parseInt(sc.nextLine());
			
			if(num==1) {
				qs.inPut();
			} else if(num==2) {
				qs.outPut();
			} else if(num==3) {
				System.out.println("종료");
				break;
			}
		}
	}

}

package day1107;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class QuizShopMain {
	
	List<QuizShop> list=new Vector<QuizShop>();
	Scanner sc=new Scanner(System.in);
	
	
	//입력
	//상품,색상,제조사,수량,금액에 대해서 값을 입력받는다.
	//입력한 상품의 갯수를 출력해 본다.
	public void inPut() {
		
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
	
	public void shopSearch()
	{
		//상품을 입력하면(이름의 일부도 가능..equals,stratsWith,contains)모두 출력
		//없을경우 "해당제품을 찾지 못하였습니다"
		System.out.println("검색할 상품명을 입력해주세요.");
		String sangpum=sc.nextLine();
		
		boolean find=false; //없을경우 대비
		System.out.println("****검색결과****");
		
		for(QuizShop s:list)
		{
			if(s.getSangpumName().equals(sangpum))
//			if(q.getSangpumName().startsWith(sangpum));
//			if(q.getSangpumName().contains(sangpum));
			{
				find=true;
				
				int su=s.getSu();
				int price=s.getPrice();
				int tot=su*price;
				System.out.println(s.getSangpumName()+"\t"+s.getColor()+"\t"+s.getMadeCompany()+"\t"+su+"\t"+price+"\t"+tot);
			}
		}
		if(!find) //find==false
		{
			System.out.println("해당 상품은 찾지 못했습니다.");
		}
	}
	
	public void deleteSangpum()
	{
		//삭제할 상품명을 입력해주세요.
		//삭제할 상품명이 없습니다.
		System.out.println("삭제할 상품명을 입력해주세요.");
		String d=sc.nextLine();
		
		boolean find=false;
		System.out.println("****삭제결과****");
		
		for(int i=0;i<list.size();i++)
		{
			QuizShop s=list.get(i);
			if(s.getSangpumName().equals(d))
			{
				list.remove(i);
				find = true;
				System.out.println("상품이 삭제 되었습니다.");
			}
		}
		if(!find)
		{
			System.out.println("해당 상품이 없습니다.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuizShopMain qs=new QuizShopMain();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("1.입력     2.출력     3.찾기     4. 삭제");
			int num=Integer.parseInt(sc.nextLine());
			
			if(num==1) {
				qs.inPut();
			} else if(num==2) {
				qs.outPut();
			} else if(num==3) {
				qs.shopSearch();
			} else if(num==4) {
				qs.deleteSangpum();;
			}else
			{
				System.out.println("종료");
				break;
			}
		}
	}

}

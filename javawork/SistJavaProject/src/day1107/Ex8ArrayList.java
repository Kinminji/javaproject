package day1107;

import java.util.ArrayList;
import java.util.List;

public class Ex8ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] stuName= {"조성진","김민지","김성주","나지예","김현능"};
		
		//ArrayList: 객체들을 삽입, 삭제, 검색할수있는 컨테이너
//		List<String> namelist=new ArrayList<String>();
		ArrayList<String> nameList=new ArrayList<String>();
		
		//데이터 담기
		//stuName을 list에 삽입한다.
		for(String s:stuName)
			nameList.add(s);
		
		System.out.println(nameList.size()+"개");
			
			
		//list를 출력해 본다
		System.out.println("출력#1_for");
		for(int i=0;i<nameList.size();i++) {
			String s=nameList.get(i);
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("출력#2_for~each");
		for(String n:nameList)
		{
			System.out.println(n);
		}
		System.out.println();
		

	}

}

package day1107;

import java.util.List;
import java.util.Vector;

public class Ex4ListInterface {

	public static void write(String title, List<String> list)
	{
		System.out.println("***\t"+title+"\t***");
		for(int i=0;i<list.size();i++) {
			System.out.println(i+":"+list.get(i));
			System.out.println();
		}
	}
		
	public static void main(String[] args) {
		String [] data= {"수박","배","샤인머스켓"};
		
		//배열의 데이터를 list에 넣기
		List<String> list=new Vector<String>();
		for(String d:data)
			list.add(d);
		
		write("초기배열데이터 출력", list);
		
		
		
		//삭제
		list.remove(1);
		
		write("1번 인덱스 삭제", list);

		
		
		//추가
		list.add("멜론");
		
		write("인덱스 추가", list);
		
		
		
		//변경
		list.set(1, "귤");
		
		write("인덱스 변경", list);
		
		
		
		//전체삭제 후 사이즈
		list.clear();
		System.out.println("***\t데이터 전체 삭제: "+list.size()+"\t***");
		
	}

}

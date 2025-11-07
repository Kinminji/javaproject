package day1107;

import java.util.Iterator;
import java.util.Vector;

//List 인터페이스
//순차적으로 데이터가 들어간다(인덱스)
//중복데이터 허용
//처음생성시 일정한 갯수로 생성,그 이상의 데이터를 넣으면 공간이 자동으로 늘어난다(가변적)
//생성자(5,3)_할당크기가 5이고 혹시 넘치면 3씩 증가
public class Ex3Vector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		List<String> list=new Vector<String>(); //list의 부모가 인터페이스로 부터 탄생한 경우라 list를 쓰는 경우가 많음(다형성)
		Vector<String> list2=new Vector<String>();
		
		System.out.println("초기할당크기: "+list2.capacity());
		System.out.println("초기데이터 갯수: "+list2.size());
		
		list2.add("사과");
		list2.add("배");
		list2.add("샤인머크캣");
		list2.add("귤");
		list2.add("배");
		list2.add("수박");
		
		System.out.println("데이터 갯수: "+list2.size());
		System.out.println("데이터 할당 크기: "+list2.capacity()); //10개가 넘치면 다시 10개 생김
		
		System.out.println("출력#1_for");
		for(int i=0;i<list2.size();i++) {
			String s=list2.get(i);
			System.out.println(s);
		}
		
		System.out.println("출력#2_for~each");
		for(String s:list2) {
			System.out.println(s);
		}
		
		System.out.println("출력#3_Iterater");
		Iterator<String> iter=list2.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("출력#4_toArray");
		Object [] ob=list2.toArray();
		for(int i=0;i<ob.length;i++) {
			System.out.println(ob[i]);
		}

	}

}

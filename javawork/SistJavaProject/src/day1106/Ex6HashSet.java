package day1106;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//set: 순서유지없다, 중복허용안함
//Set: 인터페이스 HashSet:set을 구현한 클래스
//Set<제네릭타입> 참조변수명=new HashSet<제네릭타입>();
public class Ex6HashSet {

	public static void main(String[] args) {
		// set안에 String이라는 자료형의 데이터만 담겠다
		Set<String> set1=new HashSet<String>();
		
		//추가,삭제 가능 (배열과의 차이점_가변적이다)
		set1.add("사과");
		set1.add("배");
		set1.add("샤인머스켓");
		set1.add("사과");
		set1.add("메론");
		set1.add("배");
		set1.add("사과");

		//데이터 갯수
		System.out.println("데이터 갯수: "+set1.size());
		
		System.out.println("#출력1_for");
		for(String s:set1)
			System.out.println(s);
		
		System.out.println("#출력2_iterator");
		Iterator<String> iter=set1.iterator(); //반복적으로 출력한다. 데이터가 더이상 없을때까지
		while(iter.hasNext())
		{
			String s=iter.next();
			System.out.println(s);
		}
		
		System.out.println("#출력3_");
		Object [] ob=set1.toArray(); //배열값처럼 늘어트릴수 있는거,toArray는 순번을 가지고 있음(따라서 for문 가능)
		for(int i=0;i<ob.length;i++) {
			System.out.println(ob[i]);
		}
		
		//모든데이터 삭제
		set1.clear();
		
		//isEmpty()
		if(set1.isEmpty())
			System.out.println("Set 타입안에 데이터가 없다.");
		else
			System.out.println("Set 타입안에 데이터가 있다.");
	}

}

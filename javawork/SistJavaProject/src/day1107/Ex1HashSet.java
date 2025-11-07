package day1107;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set1=new HashSet<Integer>();
		HashSet<Integer> set2=new HashSet<Integer>();
		
		//추가
		set1.add(10);
//		set1.add("11"); 문자라 불가능
		set1.add(98);
		set1.add(54);
		set1.add(98);
		
		System.out.println("갯수: "+set1.size()); //중복은 안됨
		
		System.out.println("출력#1_for~each");
		for(int n:set1)
			System.out.printf("%5d",n);
		System.out.println();
		
		System.out.println("출력#2_Iterator");
		Iterator<Integer> iter=set1.iterator();
		while(iter.hasNext())
		{
			System.out.printf("%5d",iter.next());
			
		}
		System.out.println();
		
		System.out.println("출력#3_toArray()");
		Object [] ob=set1.toArray();
		for(int i=0;i<ob.length;i++) {
			System.out.printf("%5d",ob[i]);
		}
		
	}

}

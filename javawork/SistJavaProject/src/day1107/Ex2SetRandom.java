package day1107;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ex2SetRandom {

	public static void main(String[] args) {
		// 1~45사이의 랜덤수 6개 출력
		Random rnd=new Random();
		Set<Integer> set=new HashSet<Integer>();
		
		while(true)
		{
			int n=rnd.nextInt(45)+1;
			set.add(n);
			
			if(set.size()==6)
				break;
		}
		
		for(int num:set)
			System.out.printf("%5d",num);
		System.out.println();
		
		
		
		System.out.println("***정렬 후 출력***");
		
		Object [] ob=set.toArray();
		//오름차순정렬
		Arrays.sort(ob);
		for(int i=0;i<ob.length;i++) {
			System.out.printf("%5d",ob[i]);
		}

	}

}

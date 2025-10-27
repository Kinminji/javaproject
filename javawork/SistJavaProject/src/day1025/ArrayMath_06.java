package day1025;

import java.sql.DatabaseMetaData;

public class ArrayMath_06 {

	public static void main(String[] args) {
		// 배열 최대값 구하기
		
		int[] data= {19,98,3,12,6,35,42,75,99,82};
		
		System.out.println("갯수: "+data.length);
		
		//첫데이터를 무조건 최대값이라 가정 저장함.
		int max=data[0];
		int min=data[0];
		
		//두번째 데이터부터 끝까지 max값과 비교
		
		for(int i=1;i<data.length;i++) {
			if(max<data[i])
				max=data[i];
		}
		System.out.println("최대값: "+max);

		for(int i=1;i<data.length;i++) {
			if(min>data[i])
				min=data[i];
		}
		System.out.println("최소값: "+min);
		
	}

}

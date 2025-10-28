package day1028;

import java.util.Arrays;

public class ArrayTemp_01 {

	public static void main(String[] args) {
		//순서바꾸기 연습
		
		int a=10,b=20;
		System.out.println("a="+a+", b="+b);
		
		int temp=a;
		a=b;
		b=temp;
		
		System.out.println("a="+a+", b="+b);
		System.out.println("==============================");
		// 2.배열순서
		
		int[] arrNums= {1,2,3};
		
		for(int an:arrNums)
			System.out.print(an+"  ");
			System.out.println();
			
		System.out.println("0번과 2번을 교환후 출력");
		
		int temp1=arrNums[0];
		arrNums[0]=arrNums[2];
		arrNums[2]=temp1;		
		
		for(int an:arrNums)
			System.out.print(an+"  ");
			System.out.println();
			
			System.out.println("==============================");
		
		// 3.배열변수의 순서바꾸기
		System.out.println();
		int [] arr= {1,3,12,98,95,10,25,26};
		
		//출력
		
		System.out.println("원데이터 출력");
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		
		System.out.println();
		
		System.out.println("데이터 거꾸로 출력");
		
		for(int i=0;i<arr.length/2;i++) {
			int temp2=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp2;
		} //순서 바꾸기
		
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		
		System.out.println();
		System.out.println("데이터 오름차순 정렬");
		
		//오름차순 정렬로직(가장작은숫자를 앞으로 보내자_선택정렬)
		//기준데이터는 0번부터 끝에서 두번째 까지
//		for(int i=0;i<arr.length-1;i++) {
//			//비교하는 데이터는 기준 다음값부터 끝까지
//			for(int j=i+1;j<arr.length;j++) {
//				if(arr[i]>arr[j]) {
//					int temp3=arr[i];
//					arr[i]=arr[j];
//					arr[j]=temp3;
//				}
//			}
//			
//		}
		
		Arrays.sort(arr); //오름차순 
		
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}

	}

}

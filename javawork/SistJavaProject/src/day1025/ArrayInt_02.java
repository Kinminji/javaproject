package day1025;

public class ArrayInt_02 {
public static void main(String[] args) {
	//배열선언
	//기본형배열은 객체로 인식
	
	int []arr1,arr2; //배열선언
	arr1=new int[3]; //생성...메모리 할당
	arr2=new int[4]; //할당만 해도 값은0으로 초기화
	
	arr2[0]=10;
	arr2[1]=20;
	arr2[2]=30;
	
	//arr1:할당만 하고 초기값 지정없이 출력가능
	for(int i=0;i<arr1.length;i++)
	{
		System.out.println(arr1[i]);
	}
	
	System.out.println("=======================");
	
	//arr2출력(초기화 안한 인덱스만 0으로 출력)
	for(int i=0;i<arr2.length;i++)
	{
		System.out.println(arr2[i]);
	}
	System.out.println("=================================");
	
	//for~each문..i값없이 모든값을 일괄적으로 출력하고 싶다면 for~each도 자주쓴다.
	for(int a1:arr1) //for(자료형 참조변수명:배열명)
	{
		System.out.print(a1+"  ");
	}
	
	System.out.println();
	
	//arr2도 for~each이용해서 가로로 출력
	for(int a2:arr2)
	{
		System.out.print(a2+"   ");
	}

	//정수형 배열변수를 선언과 동시에 저장한다
	System.out.println("정수형 배열변수를 선언과 동시에 저장한다");
	int num[]= {5,7,9,100,32,45,77};
	
	//출력#1
	System.out.println("출력#1  _  0==>5");
	for(int i=0;i<num.length;i++) {
		System.out.println(i+"==>"+num[i]);
	}
	
	System.out.println("출력#2  _  num의 모든값을 가로로 출력");
	
	for(int an:num) {
		System.out.print(an+"  ");
	}
	
	System.out.println();
//	
//	for(int j=0;j<num.length;j++) {
//		System.out.println(j+"==>"+num[j]);
//	}
//	for(int n:num) {
//		System.out.println("==>"+n);
//	}
	
	
}
}

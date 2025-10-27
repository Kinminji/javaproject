package day1025;

public class ExString_01 {

	public static void main(String[] args) {
		// 문자열에 관한 함수_String객체의 메서드
		
		String strl1="may i be happy";
		String strl2="May I Be Happy";
		String strl3="매일 웃고 싶어요";
		String strl4="    걱정 없고 싶어요    ";
		
		//길이
		System.out.println("strl3의 길이: "+strl3.length());
		System.out.println("strl4의 길이: "+strl4.length());
		//strl4의 공백을 제거후 길이
		System.out.println("strl4 공백제거후 길이: "+strl4.trim().length()); //앞뒤 공백만 제거, 중간 공백은 제거x
		
		//인덱스
		System.out.println("strl3에서 웃의 인덱스: "+strl3.indexOf("웃"));
		System.out.println("strl4에서 고의 인덱스: "+strl4.indexOf('고'));
		
		//strl4의 걱정 추출
		System.out.println("strl4에서 걱정 인덱스: "+strl4.substring(4, 6));
		
		//equals..같으면 true 다르면 false
		System.out.println("문자열 비교: "+strl1.equals(strl2));
		
		System.out.println("문자열 비교: "+strl1.equalsIgnoreCase(strl2));
		
		//a.compareTo(b)
		//a와 b가 같을 경우 결과값 0
		//a가 작을경우 -(음수)값
		//a가 클 경우 +(양수)값
		
		System.out.println(strl1.compareTo(strl2)); //a(97)pple A(65)pple를 비교해서 97-65=32
		System.out.println(strl1.compareTo(strl1));
		System.out.println("kiwi".compareTo("orange"));
		System.out.println("김".compareTo("윤"));
	
		
		//endsWith
		System.out.println(strl1.startsWith("h"));
		System.out.println(strl2.endsWith("Happy"));
		
		//문자열 분리: split
		//배열선언
		
		String strl5="이태주,김민지,조성진,허현";
		
		System.out.println("strl5를 컴마로 분리해서 출력");
		String[] arr=strl5.split(",");
		System.out.println("분리된 이름갯수: "+arr.length);
		//출력
		for(int i=0;i<arr.length;i++) {
			System.out.print(i+"   ");
			System.out.println(i+"="+arr[i]);
		}
		
		
		
	}

}

package day1023;

public class StringIndex_06 {
	public static void main(String[] args) {
	
	String str="나는 지금 쌍용교육센터에서 IT교육중입니다.";
	
	char ch=str.charAt(6);
	String word1=str.substring(6); //6번부터 끝까지
	String word2=str.substring(6, 12); //6번부터 12번까지
	int i=str.length(); //길이를 숫자로 반환
	
	
	System.out.println(ch); //쌍
	System.out.println(word1); //쌍용교육센터에서 IT교육중입니다.
	System.out.println(word2); //쌍용교육센터
	System.out.println("str의 길이:"+i); //글자의 길이를 숫자로 표기해줌
	
	}
}

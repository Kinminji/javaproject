package day1023;

public class CharAt_05 {
public static void main(String[] args) {
	
	//주민번호 *****-*******
	//7번째에서 가져온 숫자로 남여 판별하기
	
	String jumin="980312-2260716";
	char seventh=jumin.charAt(7);
	
	if(seventh=='1')
		System.out.println("남자입니다.");
	else if(seventh=='2')
		System.out.println("여자입니다.");
	else if(seventh=='3')
		System.out.println("2000년생 이후 남자 입니다.");
	else if(seventh=='4')
		System.out.println("2000년생 이후 여자 입니다.");
	else
		System.out.println("잘못 기입하셨습니다.");
	
}
}

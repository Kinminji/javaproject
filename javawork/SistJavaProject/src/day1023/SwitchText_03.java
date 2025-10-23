package day1023;

public class SwitchText_03 {

	public static void main(String[] args) {
		//학점을 switch 로 구해보기
		
		int score=65;
		char grade;
		
		switch(score/10) {
		case 10: case 9: grade='A'; break;
		case 8 : grade='B'; break;
		case 7: grade='C'; break;
		case 6: grade='D'; break;
		default: grade='F';
		
		}
		
		System.out.println(score+"==>"+grade);
	}
	
}

package day1029;

public class Ex4ConstText {
	
	//인스턴스 변수와 static 변수 비교테스트
	int count=0;
	static int cnt=0;
	
	
	//생성자를 끄집어 내기
//	public Ex4ConstText(int num) {
//		// TODO Auto-generated constructor stub
//	}//명시적 생성자
//	
	public Ex4ConstText() {
		// TODO Auto-generated constructor stub
		
		count++;
		System.out.println(count);
		
		cnt++;
		System.out.println(cnt);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex4ConstText con=new Ex4ConstText();
		Ex4ConstText con2=new Ex4ConstText();
		
		//인스턴스는 서로 다른 메모리를 가지고 있으므로 생성을 각각 하더라도
		//카운트가 증가하지 않는다.
		//static은 서로 메모리를 공유하므로 생성을 또해도 1,2,3... 증가한다.
		
	}

}

package day1110;

//익명내부클래스: 클래스 선언과 객체생성을 동시에 하는 이름없는 클래스 라고 한다(일회성)
//이벤트를 발생시켰다가 끝나면 메모리에서 제거-->메모리의 효율적 관리 좋음
abstract class AbstEx{
	
	abstract public void show();

}

class OuterEx{
	
	//익명내부클래스
	AbstEx abst=new AbstEx() {
		
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("익명내부 클래스");
		}
	};
}

public class Ex3AnnonyAbstract {

	public static void main(String[] args) {
		// 생성은 외부클래스만 하고 / 참조변수.익명참조명.메서드 로 호출
		OuterEx ex=new OuterEx();
		ex.abst.show();
		
		
	}

}

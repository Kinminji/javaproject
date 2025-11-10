package day1110;

abstract class AstEx1{
	abstract public void display();
	abstract public void show();
}

public class Ex4Annony {

	//익명내부클래스로 추상메서드 2개 오버라이딩
	
	AstEx1 ast=new AstEx1() {
		
		@Override
		public void show() {
			System.out.println("보여줄게");
			
		}
		
		@Override
		public void display() {
			System.out.println("완전히 달라진 나");
			
		}
	};
	
	
	public static void main(String[] args) {
		Ex4Annony anno=new Ex4Annony();
		anno.ast.show();
		anno.ast.display();

	}

}

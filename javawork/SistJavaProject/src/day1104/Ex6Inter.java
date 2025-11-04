package day1104;

interface InterA{
	public void work();
	public void play();
}

//같은 종류끼리는 extends 가능
interface InterB{
	public void write();
}

//2개의 인터페이스를 구현하는 클래스
class InterImpl implements InterA,InterB{

	@Override
	public void work() {
		System.out.println("일을 합니다.");
		
	}

	@Override
	public void play() {
		System.out.println("취미생활을 합니다.");
		
	}

	@Override
	public void write() {
		System.out.println("글을 작성합니다.");
		
	}
	
}

public class Ex6Inter {

	public static void main(String[] args) {
		//자식 클래스로 생성
		InterImpl in=new InterImpl();
		in.work();
		in.play();
		in.write();
		
		System.out.println();
		
		//다형성
		InterA a=new InterImpl();
		a.work();
		a.play();
		
		InterB b=new InterImpl();
		b.write();
	}

}

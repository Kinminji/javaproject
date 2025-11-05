package day1105;

interface GameA 
{
	void play();
}

interface GameB
{
	public void stop();
}

//interface를 구현 할 클래스
class MyGame implements GameA, GameB
{

	@Override
	public void stop() {
		System.out.println("게임을 중지합니다.");
		
	}

	@Override
	public void play() {
		System.out.println("게임을 시작합니다.");
		
	}
	
	
	
}

public class Ex1Interface {

	public static void main(String[] args) {
		//인터페이스를 구현한 클래스로 생성
		MyGame game=new MyGame();
		
		game.play();
		game.stop();
		System.out.println();
		
		//인터페이스로 선언 구현한 클래스로 생성(다형성)
		GameA g=new MyGame();
		g.play();
		
		GameB g1=new MyGame();
		g1.stop();
		

	}

}

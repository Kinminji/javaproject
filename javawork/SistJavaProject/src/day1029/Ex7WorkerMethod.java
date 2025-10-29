package day1029;

class MyInfo{
	
	String name; //private 캡슐화
	int age;
	String city;
	
}

///////////////////////////
public class Ex7WorkerMethod {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//MyInfo 초기화 후 출력
		//디폴트 인스턴스 변수는 생성후 참조변수를 통해서 변수명을 불러올 수 있다.
		//참조 변수명.변수명
		
		MyInfo my1=new MyInfo();
		my1.name="박성진";
		my1.age=33;
		my1.city="부산";
		
		System.out.println(my1.name+","+my1.age+"세,"+my1.city);
		
		//인스턴스 변수가 private이면 생성을 해도 변수가 그대로 접근할수 없다.
		//반드시 메서드를 통해서 가져가야 한다
		
	}

}

package day1031;

public class Ex2Main {

	public static void main(String[] args) {
		// 객체생성은 자동으로 부모->자식 순서이다
		//그래야 자식이 부모의 멤버를 사용할수 있기 때문이다
		//디폴트 생성자는 자동호출된다
		
		Ex2Manager n=new Ex2Manager("이효리", 260000, "개발팀");
		System.out.println(n.getEmp());

	}

}

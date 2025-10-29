package day1029;

class MyJeongbo{
	
	private String name;
	private int age;
	private String city;
	
	//변수앞에 private을 붙히면 다른클래스에서 생성을 하더라도 변수명에 접근할수 없다
	//반드시 메서드를 만들어서 그 메서드를 호출하여 사용한다
	//setter 메서드: 수정용    getter메서드: 조회용   
	//이 두개를 합쳐서 woker mathod라고 부른다.
	//캡슐화 라고도 한다
	
	//수정용메서드_set
	//수정용은 void (반환타입 없음,인지값 있음)
	public void setName(String name) 
	{
		this.name=name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public void setCity(String city) {
		this.city=city;
	}
	
	//조회용메서드_get
	//무조건 반환타입존재함,인자값 없음
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String getCity()
	{
		return city;
	}
	
	
}
 ///////////////////////////
public class Ex8WorkerMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyJeongbo jb1=new MyJeongbo();
		jb1.setName("박성진");
		
		String name=jb1.getName();
		System.out.println("이름: "+name);
		

		jb1.setAge(33);
		
		int age=jb1.getAge();
		System.out.println("나이: "+age+"세");
		

		jb1.setCity("부산");
		
		String city=jb1.getCity();
		System.out.println("지역: "+city);
		
	}

}

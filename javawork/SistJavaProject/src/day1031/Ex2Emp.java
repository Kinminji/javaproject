package day1031;


//super
public class Ex2Emp {

	String empName;
	int salery;
	
	//생성자
	
	public Ex2Emp(String name, int sal) {
		// TODO Auto-generated constructor stub
		
		this.empName=name;
		this.salery=sal;
	}
	
	//출력메서드
	
	public String getEmp() {
		String s=empName+","+salery;
		return s;
	}
	
	

	
}

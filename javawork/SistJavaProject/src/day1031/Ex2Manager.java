package day1031;

//sub
public class Ex2Manager extends Ex2Emp{

	String dept; //부서 
	
	
	public Ex2Manager(String name, int sal, String d) {
		super(name, sal);
		
		this.dept=d;
	}
	
	@Override //부모에서 추가 하고 싶을때
	public String getEmp() {
		
		return super.getEmp()+","+dept; // 자식을 추가하고 싶을때 +해서 추가
	}

	
	
}

package day1031;

public class Emp {

	private String name;
	private int pay;
	private int sudang;
	
	private static String empName; //회사명
	
	
	//setter(수정용_초기화)&getter(조회용)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getSudang() {
		return sudang;
	}

	public void setSudang(int sudang) {
		this.sudang = sudang;
	}

	public static String getEmpName() {
		return empName;
	}

	public static void setEmpName(String empName) {
		Emp.empName = empName;
	}
	
	
	//실수령액
	public int getNetPay() {
		int money=(int)((pay+sudang)*0.9);  //실수를 int로 받고 싶으면 앞에 (int)를 붙인다.
		
		return money;
	}
	
	
}

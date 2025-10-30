package day1030;

class myCar{
	
	//멤버 변수
	private String carName;
	private String carColor;
	private int carPrice;
	private String carCompany;
	
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	
	
	
}

public class Ex2Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		myCar car=new myCar();
		car.setCarName("그랜져");
		car.setCarColor("black");
		car.setCarPrice(4000);
		car.setCarCompany("현대");
		
		System.out.println("**나의 차 정보**");
		System.out.println(car.getCarName());
		System.out.println(car.getCarColor());
		System.out.println(car.getCarPrice());
		System.out.println(car.getCarCompany());
		
		
		
		System.out.println("**변경 후 차 정보**");
		
		car.setCarName("제네시스");
		car.setCarColor("blue");
		car.setCarPrice(3500);
		car.setCarCompany("현대");
		
		System.out.println(car.getCarName());
		System.out.println(car.getCarColor());
		System.out.println(car.getCarPrice());
		System.out.println(car.getCarCompany());

	}

}

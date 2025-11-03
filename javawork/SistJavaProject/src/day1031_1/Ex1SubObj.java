package day1031_1;

import day1031.Ex1SuperObj;

public class Ex1SubObj extends Ex1SuperObj{

	private String addr;
	
	public Ex1SubObj(String name, int age, String addr) {
		super(name, age);
		// 부모로 부터 상속받아 옴
		//부모로부터 받은건 첫번째로 와야함 (반드시 첫줄)
		
		this.addr=addr;
	}

	
	//메서드
	public void writeDate() {
		System.out.println("이름: "+this.name); //이미 부모로부터 상속을 받았기에 super가 아닌 this로 가능
		System.out.println("나이: "+this.age);
		System.out.println("지역: "+this.addr);
	}
	
	
}

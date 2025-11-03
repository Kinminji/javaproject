package day1031_1;

public class Ex1Main {

	public static void main(String[] args) {
		// super는 이미 sub에 상속을 받았기에 sub만 상속 받아도 둘다 받게 되는거
		
		Ex1SubObj ob1=new Ex1SubObj("박성진", 33, "부산광역시");
		ob1.writeDate();

	}

}

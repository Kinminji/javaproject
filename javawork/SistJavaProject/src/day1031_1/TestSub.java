package day1031_1;

public class TestSub extends TestSuper{

	String addr;
	
	public TestSub(String name, int age, String addr) {
		super(name, age);
		
		this.addr=addr;
	}
	
	@Override
	public void Write() {
		// TODO Auto-generated method stub
		super.Write();
		System.out.println("사는곳: "+addr);
	}


}

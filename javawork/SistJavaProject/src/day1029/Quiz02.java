package day1029;

class set
{
	private String name;
	private int grade;
	
	public  set(String sna,int sgr){
		name=sna;
		grade=sgr;
	}
	
	public String getname(){
		return name;
	}
	public int getgrade() {
		return grade;
	}
}

public class Quiz02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		set my=new set("김민지", 3);
		
		String na=my.getname();
		int gr=my.getgrade();
		
		System.out.println(na+gr);

	}

}

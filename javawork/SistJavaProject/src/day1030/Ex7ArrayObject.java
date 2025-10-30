package day1030;

class MyInfo{
	
	private String name;
	private int age;
	private String mbti;
	
	
	public MyInfo(String n, int a, String m) {
		// TODO Auto-generated constructor stub
		this.name=n;
		this.age=a;
		this.mbti=m;
	}
	
	public static void title() {
		System.out.println("이름\t나이\tMBTI\t");
		System.out.println("=======================");
	}
	
	public void getinfo() {
		System.out.println(name+"\t"+age+"\t"+mbti);
	}
}

public class Ex7ArrayObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyInfo.title();
		
		MyInfo[] in=new MyInfo[3];
		in[0]=new MyInfo("김민희", 22, "ENFP");
		in[1]=new MyInfo("김희애", 28, "ISTJ");
		in[2]=new MyInfo("이효리", 26, "ESFJ");
		
		for(int i=0; i<in.length;i++) {
			in[i].getinfo();
		}
		
		
		System.out.println();
		MyInfo.title();
		
		for(MyInfo n:in) {
			n.getinfo();
		}

	}

}

package day1030;

class info{
	
	private String name;
	private int price;
	private int people;
	private int time;
	
	static int sumtime=0;
	static int sumpeople=0;
	static int sumprice=0;
	
	
	public info(String n,int p, int pi, int t) {
		// TODO Auto-generated constructor stub
		name=n;
		price=p;
		people=pi;
		time=t;
	}
	
	public void getinfo() {
		System.out.println(name+"\t"+price+"만원\t"+people+"\t"+time);
	}
	
	public static void title() {
		System.out.println("=========================================================");
		System.out.println("사원명\t급여\t가족수\t초과근무시간\t가족수당\t총급여");
		System.out.println("=========================================================");
	}
	
}

public class Ex10test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		info.title();
		
		info[] n1=new info[4];
		n1[0]=new info("홍길동", 260, 4, 6);
		n1[1]=new info("심청이", 300, 2, 10);
		n1[2]=new info("흥부", 240, 10, 15);
		n1[3]=new info("놀부", 320, 3, 0);
		
		for(info n:n1) {
			n.getinfo();
		}
		
		
		
		

	}

	public static double ntime(int n,double time) {
		
		n=info.sumtime;
		return n*price;
	}
	
	public static double npeople(int n,double people) {
		n=info.sumpeople;
		return n*people;
	}
	public static int nprice(int price, int sumprice, int sumpeople) {
		return price+sumprice+sumpeople;
	}
	
}

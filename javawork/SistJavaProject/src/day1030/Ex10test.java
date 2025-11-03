package day1030;

class info{
	
	private String name;
	private int pay;
	private int familySu;
	private int timeSu;
	
	public info(String n,int p, int pi, int t) {
		// TODO Auto-generated constructor stub
		name=n;
		pay=p;
		familySu=pi;
		timeSu=t;
	}
	
	
	//가족수당
	
	public int getFamilySudang() {
		int fs=0;
		if(familySu>=4)
			fs=200000;
		
		else
			fs=familySu*50000;
		
		return fs;
	}
	
	//시간외 수당
	public int getTimeSudang() {
		int ts=0;
		if(timeSu>=10)
			ts=300000;
		else
			ts=timeSu*30000;
		return ts;
	}
	
	//총급여
	public int getTotalPay() {
		int tp=pay+getFamilySudang()+getTimeSudang();
		
		return tp;
	}


}

public class Ex10test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		
		
		

	}
}



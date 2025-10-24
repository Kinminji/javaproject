package day1024;

public class MultiFor_02 {

	public static void main(String[] args) {
		// i가 1일때 j가 4번 반복
		// 다시 i가 2일떄 j가 4번 반복
		//이중으로 반복되는 구조를 다중for

		for(int i=1;i<=3;i++) {
			
			System.out.println(i+": may i");
			for(int j=1;j<=4;j++) {
				
				System.out.println("\t"+j+"be happy");
				
			}
			
			System.out.println();
			
		}
		
	}

}

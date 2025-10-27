package day1025;

import java.util.Scanner;

public class Quiz_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//숫자배열을 생성과 동시에 초기화
		//해당숫자가 몇번째 있는지 출력, 숫자가 없으면 없다라고 출력
		//찾는 숫자를 입력하여 해당숫자의 유무, 순번 등을 출력...
		//반복문을 입력하여 0을 입력할때까지 계속할 수 있다.

		Scanner sc=new Scanner(System.in);
		
		int[] number={98,88,75,61,52,48,41,32,22,10,2};
		boolean flag;
		int num;
		
		while(true) {
			System.out.println("검색할 숫자를 입력하시오");
			num=sc.nextInt();
			
			if(num==0)
				break;
			
			flag=false;
			
			for(int i=0;i<number.length;i++) {
				
				if(num==number[i]) {
					flag=true;
				System.out.println(i+1+"번째에 해당 숫자가 있습니다.");
				}
				
			}
			if(!flag)
				System.out.println("해당숫자가 없습니다.");
			
			
		}
		
		
		
		//각 학생들 점수에 대한 총점, 평균, 등수 출력
		//번호  학생명  자바  오라클  총점  평균  등수
		//1   박성진   88   75    ...
		
		String[] stuName= {"박성진","강영현","김원필","윤도운"};
		int[] java= {88,100,65,23};
		int[] oracle= {75,95,72,45};
		int [] tot=new int[4];
		int [] rank=new int[4];
		double [] avg=new double[4];
		
		
		for(int i=0;i<stuName.length;i++) {
			tot[i]=java[i]+oracle[i];
			avg[i]=tot[i]/2;
		}
		
		for(int i=0;i<stuName.length;i++) {
			rank[i]=1;
			
			for(int j=0;j<stuName.length;j++) {
				if(tot[i]<tot[j])
					rank[i]++;
			}
		}
		
		System.out.println("번호\t학생명\t자바\t오라클\t총점\t평균\t등수");
		System.out.println("===================================================");
		
		for(int i=0;i<stuName.length;i++) {
			System.out.println((i+1)+"번\t"+stuName[i]+"\t"+java[i]+"\t"+oracle[i]+"\t"+tot[i]+"\t"+avg[i]+"\t"+rank[i]);
			System.out.println();
		}
		
		
	}

}

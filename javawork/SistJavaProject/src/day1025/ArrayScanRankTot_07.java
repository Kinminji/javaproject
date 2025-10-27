package day1025;

import java.util.Scanner;

public class ArrayScanRankTot_07 {
public static void main(String[] args) {
	String[] stuName= {"박성진","강영현","김원필","윤도운"};
	int[] java= {88,100,65,23};
	int[] oracle= {75,95,72,45};
	int [] tot=new int[4];
	int [] rank=new int[4];
	double [] avg=new double[4];
	
	//각 학생들 점수에 대한 총점, 평균, 등수 출력
	//번호  학생명  자바  오라클  총점  평균  등수
	//1   박성진   88   75    ...

	
	Scanner sc=new Scanner(System.in);
	
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
	System.out.println("=====================================================");
	
	for(int i=0;i<stuName.length;i++) {
		System.out.println((i+1)+"번\t"+stuName[i]+"\t"+java[i]+"\t"+oracle[i]+"\t"+tot[i]+"\t"+avg[i]+"\t"+rank[i]);
		System.out.println();
	}

}
}

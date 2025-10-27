package day1025;

import java.util.Scanner;

public class ArrayScanTotAvg_06 {

	public static void main(String[] args) {
		//인원수를 먼저 입력후 그 인원수만큼 이름과 점수를 입력후에 총점,평균을 구하시오. 
		
		int iw; //입력할 인원수
		String[] name;
		int [] score;
		int tot=0;
		double avg=0;
		int[] rank;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("몇명의 학생들을 입력하실건가요?");
		iw=Integer.parseInt(sc.nextLine()); //다음에 이름(문자)를 입력하기 위해 형변환
		
		//인원수만큼 배열할당
		name=new String[iw];
		score=new int[iw];
		rank=new int[iw];
		
		//학생수만큼 데이터 입력
		
		for(int i=0;i<iw;i++) {
			System.out.println((i+1)+"번지 학생명");
			name[i]=sc.nextLine();
			System.out.println((i+1)+"번지 점수");
			score[i]=Integer.parseInt(sc.nextLine());
			
			//총점
			tot+=score[i];
			}
		
		//등수구하기(다중 for문)
		for(int i=0;i<iw;i++) {
			rank[i]=1;
			
			for(int j=0;j<iw;j++) {
				if(score[i]<score[j])
					rank[i]++;
			}
		}
		
		avg=(double)tot/iw;
		
		
		//출력
		System.out.println("==============================");
		System.out.println("번호\t학생명\t점수\t등수");
		System.out.println("==============================");
		
		for(int i=0;i<iw;i++) {
			System.out.println((i+1)+"\t"+name[i]+"\t"+score[i]+"\t"+rank[i]);
		}
		
		System.out.println("==============================");
		System.out.println("총점:"+tot+"점");
		System.out.println("평균"+avg+"점");
		
		
		
		//인원수를 먼저 입력후 그 인원수만큼 이름과 점수를 입력후에 총점,평균을 구하시오. 
//		int p;
//		String nam[];
//		int sco[];
//		int sume=0;
//		double avge=0;
//		int[] rank;
//		
//		System.out.println("인원을 적어주세요.");
//		p=Integer.parseInt(sc.nextLine());
//		
//		nam=new String[p];
//		sco=new int[p];
//		rank=new int[p];
//		
//		for(int i=0;i<p;i++) {
//			System.out.println((i+1)+"번째 학생명");
//			nam[i]=sc.nextLine();
//			System.out.println((i+1)+"번째 학생의 점수");
//			sco[i]=Integer.parseInt(sc.nextLine());
//					
//			sume+=sco[i];
//		}
//		
//		avge=sume/p;
//		
//		
//		
//		System.out.println("번호\t학생명\t점수");
//		
//		for(int i=0;i<p;i++) {
//			System.out.println((i+1)+"\t"+nam[i]+"\t"+sco[i]);
//		}
//		
//		System.out.println("총점:"+sume);
//		System.out.println("평균:"+avge);
//		
//		System.out.println();
	}

}

package day1028;

import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int[][] puzzle=new int[3][3];
		int binggo;
		
		while(true) {
			System.out.println("**같은 숫자가 가로,세로,대각선 어디라도 나오면 빙고!**");
			
			for(int i=0;i<puzzle.length;i++) {
				for(int j=0;j<puzzle[i].length;j++) {
					puzzle[i][j]=(int)(Math.random()*3+1);
				}
			}
			
			for(int i=0;i<puzzle.length;i++) {
				for(int j=0;j<puzzle[i].length;j++) {
					System.out.printf("%4d",puzzle[i][j]);
				}
				System.out.println();
			}
			
			System.out.println("엔터를 누르면 다음 빙고가 추출됩니다.");
			String ent=sc.nextLine();
			
			if(ent.equalsIgnoreCase("q"))
				break;
			
			binggo=0;
			
			
			
		}
		
	}

}

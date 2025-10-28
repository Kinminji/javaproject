import java.util.Scanner;

public class BingoGame_07 {

	public static void main(String[] args) {
		// 3행3열의 테이블안에 1~3까지의 랜덤수를 발생시켜서 빙고게임 진행
		//8개의 빙고가 나오면 최고활률
		
		Scanner sc=new Scanner(System.in);
		int [][] puzzle=new int[3][3];
		int binngo;
		
		while(true) {
			System.out.println("**같은 숫자가 가로,세로,대각선 어디라도 나오면 빙고!**");
			
			//랜덤수
			for(int i=0;i<puzzle.length;i++) {
				for(int j=0;j<puzzle[i].length;j++) {
					puzzle[i][j]=(int)(Math.random()*3+1);
				}
			}
			
			
			//출력
			
			for(int i=0;i<puzzle.length;i++) {
				for(int j=0;j<puzzle[i].length;j++) {
					System.out.printf("%4d",puzzle[i][j]);
				}
				System.out.println();
			}
			
			//빙고의 조건
			//가로선
			
			binngo=0;
			
			for(int i=0;i<3;i++) {
				if(puzzle[i][0]==puzzle[i][1] && puzzle[i][1]==puzzle[i][2])
				binngo++;
			}
			
			//세로선
			for(int i=0;i<3;i++) {
				if(puzzle[0][i]==puzzle[1][i] && puzzle[1][i]==puzzle[2][i])
				binngo++;
			}
			//대각선 \
			
			
				if(puzzle[0][0]==puzzle[1][1] && puzzle[1][1]==puzzle[2][2])
				binngo++;
		
			
			//대각선 /
			
			
				if(puzzle[0][2]==puzzle[1][1] && puzzle[1][1]==puzzle[2][0])
				binngo++;
			
			
			System.out.println(binngo+"개");
			
			//종료조건
			System.out.println("엔터를 누르면 다음 난수가 나온다.(종료시 : q)");
			String ent=sc.nextLine();
			
			if(ent.equalsIgnoreCase("q")) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			
		}
	}

}

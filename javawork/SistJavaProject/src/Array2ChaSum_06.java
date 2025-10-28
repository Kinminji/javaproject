
public class Array2ChaSum_06 {
public static void main(String[] args) {
	
	String [] stuName= {"박성진","강영현","김원필"};
	int [][] score= {{85,99,72,0},{98,95,100,0},{73,56,87,0}}; //맨뒤 0은 sum할 자리수를 일단 잡는거
	
	//총점 구하기
	
	for(int i=0;i<score.length;i++) {
		for(int j=0;j<3;j++) {
			score[i][3]+=score[i][j];
		}
	}
	
	//출력
	
	System.out.println("이름\t자바점수\t오라클\t스프링\t총점");
	System.out.println("======================================");
	
	for(int i=0;i<stuName.length;i++) {
		System.out.print(stuName[i]+"\t");
		
		//점수와 총점은 열갯수 만큼 반복해서 출력
		for(int j=0;j<score[i].length;j++) {
			System.out.print(score[i][j]+"\t");
		}
		System.out.println();
	}
	
}
}

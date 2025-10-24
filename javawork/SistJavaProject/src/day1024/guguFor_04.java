package day1024;

public class guguFor_04 {

	public static void main(String[] args) {
		// 2~9단(세로)

		for(int i=2; i<=9;i++) {

			for(int j=1; j<=9;j++) {

				if(j==7)
					break;

				System.out.println(i+"X"+j+"="+(i*j));

			}

			System.out.println();

		}

		
		//자신이 속한 반복문이 아닌 최상단 반복문 빠져나가기
		//이름(라벨)을 주어서 빠져나가는것 가능
		System.out.println("========================================");
		min:for(int i=2; i<=9;i++) {

			for(int j=1; j<=9;j++) {

				if(j==7)
					break min;

				System.out.println(i+"X"+j+"="+(i*j));

			}

			System.out.println();

		}

		System.out.println("**구구단 가로 방향**");

		for(int i=2;i<=9;i++) {

			System.out.print("["+i+"단]\t");

		}

		System.out.println();

		for(int j=1;j<=9;j++) {

			for(int i=2;i<=9;i++) {

				System.out.print(i+"X"+j+"="+(j*i)+"\t");

			}

			System.out.println();

		}

	}

}

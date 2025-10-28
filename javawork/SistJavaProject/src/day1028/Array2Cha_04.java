package day1028;

public class Array2Cha_04 {

	public static void main(String[] args) {
		// 이차월배열: 행,열
		
		int[][]arr;
		arr=new int[2][3]; //2행 3열
		
		arr[0][0]=10;
		arr[0][1]=20;
		arr[0][2]=30;
		
		arr[1][0]=40;
		arr[1][1]=50;
		arr[1][2]=60;
		
		
		System.out.println("행의 갯수 : "+arr.length);
		
		System.out.println("0행의 열갯수 : "+arr[0].length);
		System.out.println("1행의 열갯수 : "+arr[1].length);

		System.out.println("**데이터출력**");
		for(int i=0;i<arr.length;i++) //행의 갯수
		{
			for(int j=0;j<arr[i].length;j++)
			{
//				System.out.print(arr[i][j]+"\t");
				System.out.printf("%d,%d=%2d\t",i,j,arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("2차원 배열에 초기값 변경 후 다시출력");
		
		arr[0][0]=100;
		arr[1][1]=200;
		arr[0][2]=300;
		
		for(int i=0;i<arr.length;i++) //행의 갯수
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"\t");
//				System.out.printf("%d,%d=%2d\t",i,j,arr[i][j]);
			}
			System.out.println();
		}
		
		
		
	}

}

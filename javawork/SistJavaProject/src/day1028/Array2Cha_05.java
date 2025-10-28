package day1028;

public class Array2Cha_05 {

	public static void main(String[] args) {
		// 2차원 배열도 배열선언과 동시에 초기값 주기를 더 많이 사용한다.
		
		int[][] arr= {
				{98,3},{12,95,8},{25,93,1,16}
				};
		
		System.out.println("행의 갯수:" +arr.length);
		
		System.out.println("0번행의 열갯수:" +arr[0].length);
		System.out.println("1번행의 열갯수:" +arr[1].length);
		System.out.println("2번행의 열갯수:" +arr[2].length);
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("for~each로도 출력");
		
		for(int[] a:arr)
		{
			for(int num:a)
			{
				System.out.print(num+"\t");
			}
			System.out.println();
		}

	}

}

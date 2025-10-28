package day1028;

public class ArrayRandomLotto_02 {

	public static void main(String[] args) {
		// 로또 6개 출력 (1~45까지 랜덤수)
		// 단 같은수가 나오면 안됨; 다시 추출
		
		int[] lotto=new int[6];
		//랜덤수를 로또 변수에 발생시켜 넣는다
		
		for(int i=0;i<lotto.length;i++) {
			lotto[i]=(int)(Math.random()*45)+1;
			
			//중복처리
			//중복제거: 현재 index (i)와 (0~i-1)까지를 비교해서 중복된 숫자가 존재하면 i--
			
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}

		}
		
		//오름차순 정렬
		for(int i=0;i<lotto.length-1;i++) {
			for(int j=i+1;j<lotto.length;j++) {
				if(lotto[i]>lotto[j]) {
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		//출력
		for(int i=0;i<lotto.length;i++) {
			System.out.println(i+1+"번째 숫자: "+lotto[i]);	
		}
		
	}

}

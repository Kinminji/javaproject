package day1105;

import java.io.IOException;
import java.io.InputStream;

//문자스트림 : Reader, Writer 대부분 문자단위로 처리
//바이트스트림 : InputStream, OutputStream _대부분 바이트단위로 처리
public class Ex6StreamException {

	public static void main(String[] args) {
		
		InputStream is=System.in;
		int a=0;
		
		System.out.println("한글자 입력: ");
		try {
			a=is.read(); // read()는 1바이트 밖에 못읽는다, 즉 한글 못읽음
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("오류: "+e.getMessage());
		}
		
		System.out.println("3초 뒤에 출력합니다.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println("입력값: "+a);
		System.out.println("입력값: "+(char)a);
	}

}

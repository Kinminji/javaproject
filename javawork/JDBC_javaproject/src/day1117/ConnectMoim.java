package day1117;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectMoim {
	
	//url
		static final String Oracle_url="jdbc:oracle:thin:@localhost:1521:XE";
	//조회	
	
		public void getConnetMoim()
		{
			System.out.println("회원번호 \t 회원명 \t 회원주소 \t 연락처 \t 직업 \t 가입일");
			System.out.println("========================================================");
			
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			
			String sql="select no, name, addr, hp, job, gaipday from moim order by name";
			
			try {
				conn=DriverManager.getConnection(Oracle_url, "test", "a1234");
				
				System.out.println("연결 성공");
				
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				
				while(rs.next())
				{
					System.out.println(rs.getInt("no")+"\t"+rs.getString("name")+"\t"+rs.getString("addr")+"\t"+rs.getString("hp")+"\t"+rs.getString("job")+"\t"+rs.getDate("gaipday"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	//삭제
		public void getDeleteMoim()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("삭제할 회원번호를 입력해주세요.");
			int num=Integer.parseInt(sc.nextLine());
			
			String sql="delete from moim where no="+num;
			
			//db연결
			Connection conn=null;
			Statement stmt=null;
			
			try {
				conn=DriverManager.getConnection(Oracle_url, "test", "a1234");
				
				//sql문 전달
				stmt=conn.createStatement();
				
				//서버의 업데이트
				stmt.execute(sql);
				
				System.out.println("삭제되었습니다.");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	

	public static void main(String[] args) {
		// 조회, 삭제를 선택해서 사용
		
		ConnectMoim moim=new ConnectMoim();
		
		Scanner sc=new Scanner(System.in);
		int n;
		
		while(true)
		{
			System.out.println("***Oracle db 연습문제_TEST계정의 moim테이블***");
			System.out.println("1.조회     2.삭제     3.종료");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1) {
				moim.getConnetMoim();
			} else if(n==2) {
				moim.getDeleteMoim();
			} else if(n==3) {
				System.out.println("프로그램 종료");
				break;
			}
		}
			
	}

}

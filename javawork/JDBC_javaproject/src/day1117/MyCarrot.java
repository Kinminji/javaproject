package day1117;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyCarrot {
	
	static final String Oracle_url="jdbc:oracle:thin:@localhost:1521:XE";
	
	public void getSelectMyCarrot()
	{
		
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select cnum, csangpum, cprice, cscore, caddr from mycarrot order by cnum";
		
		try {
			conn=DriverManager.getConnection(Oracle_url, "test", "a1234");
			
			System.out.println("연결 성공");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("*** 당근 거래 물품 내역 ***");
			System.out.printf("%-5s %-15s %-10s %-8s %-20s\n",
			        "회원번호", "판매상품", "가격", "좋아요", "지역");
			System.out.println("===============================================================");
			
			while(rs.next())
			{
				System.out.printf("%-5s %-15s %-10s %-8s %-20s\n",rs.getInt("cnum"),rs.getString("csangpum"),rs.getInt("cprice"),rs.getInt("cscore"),rs.getString("caddr"));
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
	
	public void getDeleteMyCarrot()
	{
		Connection conn=null;
		Statement stmt=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("삭제할 상품의 번호를 입력해주세요.");
		int n=Integer.parseInt(sc.nextLine());
		
		String sql="delete from mycarrot where cnum="+n;
		
		try {
			conn=DriverManager.getConnection(Oracle_url, "test", "a1234");
			
			stmt=conn.createStatement();
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
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		MyCarrot ca=new MyCarrot();
		
		
		while(true) {
			
			System.out.println("1.조회     2.삭제     3.종료");
			int num=Integer.parseInt(sc.nextLine());
			
			if(num==1) {
				ca.getSelectMyCarrot();
			} else if(num==2) {
				ca.getDeleteMyCarrot();
			} else if(num==3) {
				System.out.println("종료합니다.");
				break;
			}
		}

	}

}

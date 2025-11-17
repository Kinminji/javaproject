package day1117;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.StatementEvent;

public class ConnectTest_02 {
	
	//url
	static final String Oracle_url="jdbc:oracle:thin:@localhost:1521:XE";
	
	public void getConnetFoodshop()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(Oracle_url, "test", "a1234");
			
			System.out.println("서버 연결 성공");
			
			String sql="select * from foodshop order by fno";
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("**메뉴판**");
			System.out.println("번호 \t 음식명 \t 가격 \t 상호명 \t 가게위치");
			System.out.println("================================================");
			
			while(rs.next())
			{
				int num=rs.getInt("fno");
				String foodname=rs.getString("foodname");
				int price=rs.getInt("foodprice");
				String shopname=rs.getString("shopname");
				String shoploc=rs.getString("shoploc");
				
				System.out.println(num +"\t"+foodname+"\t"+price+"\t"+shopname+"\t"+shoploc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.cancel();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	//Q.성별 인원수와 평균나이
	public void getConnectperson()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(Oracle_url,"test","a1234");
			
			System.out.println("test 서버 연결 성공");
			
			String sql="select gender, count(gender) , avg(age) from person group by gender";
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("**값 구하기**");
			System.out.println("성별 \t 인원수 \t 평균나이");
			System.out.println("==========================");
			
			while(rs.next())
			{
				System.out.println(rs.getString("gender")+"\t"+rs.getInt("count(gender)")+"\t"+rs.getInt("avg(age)"));
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
	
	//직급별 최고금액, 최저금액_평균급여 천단위 구분기호 붙힐것
	public void getConnectProcessor()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(Oracle_url, "min", "a1234");
			
			String sql="select position, to_char(max(pay*10000),'FM9,999,999') max, to_char(min(pay*10000),'FM9,999,999') min from professor group by position";
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("** 교수님 직급별 급여**");
			System.out.println("직급 \t 최고금액 \t 최소금액");
			System.out.println("==========================");
			
			while(rs.next())
			{
				System.out.println(rs.getString("position")+"\t"+rs.getString("max")+"\t"+rs.getString ("min"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectTest_02 con=new ConnectTest_02();
		con.getConnetFoodshop();
		con.getConnectperson();
		con.getConnectProcessor();
	}

}

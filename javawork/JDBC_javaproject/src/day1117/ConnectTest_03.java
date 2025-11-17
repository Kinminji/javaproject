package day1117;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest_03 {

	//url
	static final String Oracle_url="jdbc:oracle:thin:@localhost:1521:XE";
	//부서별 인원수와 평균급여, 최소급여, 최고급여 
	public void getGroupSawon()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;

		String sql="select buseo, count(buseo), to_char(avg(pay),'FM9,999,999,999') avg,"
				+ "to_char(min(pay),'FM9,999,999,999') min, to_char(max(pay),'FM9,999,999,999') max from sawon group by buseo";

		try {
			conn=DriverManager.getConnection(Oracle_url, "test", "a1234");

			System.out.println("연결되었습니다.");

			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);

			System.out.println("**부서별 정보**");
			System.out.println("부서\t인원수\t평균급여\t최소급여\t최대급여\t");
			System.out.println("===============================================");

			while(rs.next())
			{
				System.out.println(rs.getString("buseo")+"\t"+rs.getInt("count(buseo)")+"\t"+rs.getString("avg")+"\t"+rs.getString("min")+"\t"+rs.getString("max"));
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

	public void getMyBaedal()
	{
		//주문번호 주문자명 주문음식명 가격 상호명 가게위치 배달지주소
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select onum, clientname, foodname, foodprice, shopname, shoploc, clientaddr from foodshop, orderapp where foodshop.fno=orderapp.fno";
		
		try {
			conn=DriverManager.getConnection(Oracle_url, "test", "a1234");
			
			System.out.println("연결 성공");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("** 주문 영수증 **");
			System.out.println("주문번호 \t 주문자명 \t 주문음식명 \t 가격 \t 상호명 \t 가게위치 \t 배달지주소");
			System.out.println("==========================================================================");
			
			while(rs.next())
			{
				String onum=rs.getString("onum");
				String client=rs.getString("clientname");
				String food=rs.getString("foodname");
				int price=rs.getInt("foodprice");
				String shop=rs.getString("shopname");
				String loc=rs.getString("shoploc");
				String addr=rs.getString("clientaddr");
				
				System.out.println(onum+"\t"+client+"\t"+food+"\t"+price+"\t"+shop+"\t"+loc+"\t"+addr);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConnectTest_03 conn=new ConnectTest_03();
		conn.getGroupSawon();
		conn.getMyBaedal();

	}

}

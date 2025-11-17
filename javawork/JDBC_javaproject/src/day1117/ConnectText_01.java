package day1117;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectText_01 {
	
	//변수로 드라이버, url
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";

	
	//메서드 ..오라클과 자바를 연결(본인의 계정, 비번 작성)
	public void getconnectEmp()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "min", "a1234");
			
			System.out.println("클라우드의 오라클 서버에 연결 성공");
			
			String sql="select empno ,ename, job, sal from emp order by ename";  //사원명 오름차순 정렬
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("***emp데이터 가져오기***");
			System.out.println("사원번호 \t 사원명 \t 직무 \t 급여");
			System.out.println("===================================");
			
			//여러줄의 데이터를 읽어올 경우는 while문으로 가져온다.
			//rs.next() : 다음데이터 읽어오면서 더이상 데이터가 없으면 false 반환
			while(rs.next())
			{
				//db로부터 데이터 가져오기
				int empno=rs.getInt("empno");
				String name=rs.getString("ename");
				String job=rs.getString("job");
				int sal=rs.getInt("sal");
				
				System.out.println(empno+"\t"+name+"\t"+job+"\t"+sal);
			}
			
		} catch (SQLException e) {
			
//			e.printStackTrace();
			System.out.println("클라우드의 오라클 연결 실패"+e.getMessage());
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
	
	
	//test
	public void getconnectTest()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from sawon order by name desc";
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL,"test","a1234");
			
			System.out.println("서버 연결 성공");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("***사원 정보 출력***");
			System.out.println("사원번호 \t 사원명 \t 성별 \t 부서 \t 급여 \t 입사일자");
			System.out.println("================================================================");
			
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				int pay=rs.getInt("pay");
				
				System.out.println(num +"\t"+ name+"\t"+gender+"\t"+buseo+"\t"+pay+"\t"+rs.getDate("ipsa"));
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

		ConnectText_01 text1=new ConnectText_01();
//		text1. getconnectEmp();
		text1.getconnectTest();
		
	}

}

package day1119;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectHello {

	DBConnect db=new DBConnect();
	Scanner sc=new Scanner(System.in);
	
	//insert
	public void insert()
	{
		
		
		System.out.println("저장할 회원정보의 성함을 입력해주세요.");
		String name=sc.nextLine();
		System.out.println("저장할 회원정보의 나이를 입력해주세요.");
		int age=Integer.parseInt(sc.nextLine());
		
		//입력된 이름과 나이가 sql문의 변수로 들어가야 하므로 입력아래에 있어야 한다.
		String sql="insert into hello values(seq4.nextval, '"+name+"', "+age+", sysdate)";
		System.out.println(sql);
		
		//db연결
		Connection conn=db.getDbConnect();
		
		//statement
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("***db에 추가 성공***");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//select
	
	public void selectHello() {
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from hello";
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("** 회원 정보 **");
			System.out.println("번호 \t 성함 \t 나이 \t 가입일");
			System.out.println("===========================================");
			
			while(rs.next())
			{
				System.out.printf("%2d %8s %6d %15s\n",rs.getInt("num"),rs.getString("name"),rs.getInt("age"),rs.getDate("writeday").toString());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
	
	//delect
	public void getDelectHello()
	{
		
		
		
		System.out.println("삭제한 번호를 입력해주세요.");
		
		String dn=sc.nextLine();
		
		String sql="delete from hello where num="+dn;
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			int a=stmt.executeUpdate(sql);
			
			if(a==0) {
				System.out.println("*** 없는 데이터 입니다. ***");
			} else
				System.out.println("*** 삭제되었습니다. ***");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//update
	public void getUpdateHello()
	{
		//시퀀스를 입력하여 해당 시퀀스의 이름과 나이를 수정한다.
		
		System.out.println("수정할 번호를 입력해주세요.");
		String udnum=sc.nextLine();
		System.out.println("수정할 이름을 입력해주세요.");
		String udname=sc.nextLine();
		System.out.println("수정할 나이를 입력해주세요.");
		int udage=Integer.parseInt(sc.nextLine());
		
		String sql="update hello set name='"+udname+"',age="+udage+" where num="+udnum;
		System.out.println(sql);
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			
			System.out.println("** 수정이 완료되었습니다. **");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("수정 실패");
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		
		 ConnectHello hello = new ConnectHello();
		    Scanner sc = new Scanner(System.in);  // Scanner 딱 1개

		    while(true) {
		        System.out.println("11.insert 22.select 33.delete 44.update 5.exit");
		        System.out.println("=======================================================================");

		        int r;
		        try {
		            r = Integer.parseInt(sc.nextLine().trim()); // 항상 반복문 안에서 입력
		        } catch (Exception e) {
		            System.out.println("숫자만 입력하세요.");
		            continue; // 잘못된 입력이면 다시 메뉴 출력
		        }

		        switch(r) {
		            case 11: hello.insert(); break;
		            case 22: hello.selectHello(); break;
		            case 33: hello.getDelectHello();; break;
		            case 44: hello.getUpdateHello(); break;
		            case 5: System.out.println("프로그램 종료"); return;
		            default: System.out.println("잘못된 번호입니다.");
		        }
	}

}
}

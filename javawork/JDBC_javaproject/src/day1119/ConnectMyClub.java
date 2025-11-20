package day1119;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectMyClub {
	
	Scanner sc=new Scanner(System.in);
	DBConnect db=new DBConnect();

	//insert...최소 5명입력
	public void getInsert()
	{
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		System.out.println("회원 성함을 입력해주세요.");
		String cname=sc.nextLine();
		System.out.println("회원 주소를 입력해주세요.");
		String caddr=sc.nextLine();
		System.out.println("회원의 직업을 작성해주세요.");
		String cjob=sc.nextLine();
		System.out.println("회원의 핸드폰 번호를 입력해주세요.");
		String chp=sc.nextLine();
		
		String sql="insert into myclub values(seq4.nextval,'"+cname+"', '"+caddr+"', '"+cjob+"', '"+chp+"', sysdate)";
		System.out.println(sql);
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			
			System.out.println("회원정보가 저장되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//select
	public void getSelect()
	{
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from myclub";
		
		try {
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("*** 회원정보 ***");
			System.out.println("번호 1.회원명     2.주소 \t 3.직업 \t    4.핸드폰 \t    가입일자");
			System.out.println("================================================================");
			
			while(rs.next())
			{
				System.out.printf("%2s %5s %10s %7s %15s %12s\n",rs.getInt("cno"),rs.getString("cname"),rs.getString("caddr"),rs.getString("cjob"),rs.getString("chp"),rs.getDate("gaipday"));
			}
			
			System.out.println("회원정보가 연결되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}
	
	
	//delete
	public void getDelete()
	{
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		System.out.println("삭제할 회원 번호를 입력해주세요.");
		int n;
		n=Integer.parseInt(sc.nextLine());
		
		String sql="delete from myclub where cno="+n;

		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			
			if(n==0) {
				System.out.println("없는 데이터 입니다.");
			}else {
				System.out.println("삭제되었습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
				
	}
	
	//update
	public void getUpdate()
	{
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		System.out.println("수정할 회원 번호를 입력해주세요.");
		int no=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 이름을 입력해주세요.");
		String name=sc.nextLine();
		System.out.println("수정할 주소를 입력해주세요.");
		String addr=sc.nextLine();
		System.out.println("수정할 회원 직업을 입력해주세요.");
		String job=sc.nextLine();
		System.out.println("수정할 회원 휴대폰 번호를 입력해주세요.");
		String hp=sc.nextLine();
		
		String sql="update myclub set cname='"+name+"',caddr='"+addr+"',cjob='"+job+"',chp='"+hp+"' where cno="+no;
		System.out.println(sql);
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			
			System.out.println("** 수정이 완료되었습니다 **");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}

	}
	
	public void getSearch()
	{
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		System.out.println("회원명을 검색해주세요.(일부도 가능)");
		String s=sc.nextLine();
		
		String sql="select * from myclub where cname like'%"+s+"%'";
		System.out.println(sql);
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("*** 회원정보 ***");
			System.out.println("번호 1.회원명     2.주소 \t 3.직업 \t    4.핸드폰 \t    가입일자");
			System.out.println("================================================================");
			
			while(rs.next())
			{
				System.out.printf("%2s %5s %10s %7s %15s %12s\n",rs.getInt("cno"),rs.getString("cname"),rs.getString("caddr"),rs.getString("cjob"),rs.getString("chp"),rs.getDate("gaipday"));
			}
			
			System.out.println("검색이 완료되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		//반복문으로 1.회원가입     2.회원정보     3.회원삭제     4.회원정보수정     5.종료
		
		ConnectMyClub club=new ConnectMyClub();
		int num;
		
		while(true) {
			System.out.println("1.회원가입 \t 2.회원정보 \t 3.회원삭제 \t 4.회원정보수정 \t 5.회원검색 \t 9.종료");
			System.out.println("=======================================================================================");
			
			num=Integer.parseInt(sc.nextLine());
			
			if(num==1)
				club.getInsert();
			else if(num==2)
				club.getSelect();
			else if(num==3)
				club.getDelete();
			else if(num==4)
				club.getUpdate();
			else if(num==5)
				club.getSearch();
			else if(num==9) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}

}

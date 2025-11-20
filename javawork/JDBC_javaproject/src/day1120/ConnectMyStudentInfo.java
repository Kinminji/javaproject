package day1120;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import day1119.DBConnect;

//1.학생정보입력 2.학생정보조회 3.학생정보삭제 4.학생정보수정 5.학생검색(성을 검색) 9.종료
public class ConnectMyStudentInfo {
	
	Scanner sc=new Scanner(System.in);
	DBConnect db=new DBConnect();
	
	public void getinsert()
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		System.out.println("이름을 입력해주세요.");
		String name=sc.nextLine();
		System.out.println("주소를 입력해주세요.");
		String addr=sc.nextLine();
		System.out.println("몇학년 이십니까?");
		int grade=Integer.parseInt(sc.nextLine());
		System.err.println("혈액형을 입력해주세요.");
		String blood=sc.nextLine();
		System.out.println("생일을 입력하세요.");
		String brith=sc.nextLine();
		
		String sql="insert into mystudentinfo values(seq4.nextval,?,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, grade);
			pstmt.setString(4, blood);
			pstmt.setString(5, brith);
			
			pstmt.execute();
			
			System.out.println("정보가 저장되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void getselect()
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		System.out.println("번호 \t 이름 \t 주소 \t 학년 \t 혈액형 \t 생일 \t 작성일");
		System.out.println("------------------------------------------------------------------");
		
		String sql="select * from mystudentinfo";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt("stu_no")+"\t"+rs.getString("stu_name")+"\t"+rs.getString("stu_addr")+"\t"+rs.getInt("stu_grade")+"\t"+rs.getString("stu_blood")+"\t"+rs.getString("stu_birth")+"\t"+rs.getDate("writeday"));
			}
			System.out.println("출력되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	public void getdelete()
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		System.out.println("삭제하실 번호를 입력해주세요.");
		int no=Integer.parseInt(sc.nextLine());
		
		String sql="delete from mystudentinfo where stu_no="+no;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			
			if(no==0)
				System.out.println("없는 번호입니다.");
			else
				System.out.println("삭제가 완료되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void getupdate()
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		System.out.println("수정하실 학생의 번호를 입력해주세요.");
		int no=Integer.parseInt(sc.nextLine());
		System.out.println("수정하실 학생의 이름을 입력해주세요.");
		String name=sc.nextLine();
		System.out.println("수정하실 학생의 주소를 입력해주세요.");
		String addr=sc.nextLine();
		System.out.println("수정하실 학생의 학년을 입력해주세요.");
		int grade=Integer.parseInt(sc.nextLine());
		System.out.println("수정하실 학생의 혈액형을 입력해주세요.");
		String boold=sc.nextLine();
		System.out.println("수정하실 학생의 생일을 입력해주세요.");
		String birth=sc.nextLine();
		
		String sql="update mystudentinfo set stu_name=?, stu_addr=?, stu_grade=?, stu_blood=?, stu_birth=? where stu_no=?";
		System.out.println(sql);
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, grade);
			pstmt.setString(4, boold);
			pstmt.setString(5, birth);
			pstmt.setInt(6, no);
			
			pstmt.execute();
			
			System.out.println("업데이트 완료되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void getsearch()
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		System.out.println("찾으실 학생의 성을 입력해주세요.");
		String sung=sc.nextLine();
		
		String sql="select * from mystudentinfo where stu_name like ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, sung+"%");
			
			rs=pstmt.executeQuery();
			
			System.out.println("번호 \t 이름 \t 주소 \t 학년 \t 혈액형 \t 생일 \t 작성일");
			System.out.println("------------------------------------------------------------------");
			
			while(rs.next())
			{
				System.out.println(rs.getInt("stu_no")+"\t"+rs.getString("stu_name")+"\t"+rs.getString("stu_addr")+"\t"+rs.getInt("stu_grade")+"\t"+rs.getString("stu_blood")+"\t"+rs.getString("stu_birth")+"\t"+rs.getDate("writeday"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	public void output()
	{
		ConnectMyStudentInfo my=new ConnectMyStudentInfo();
		
		while(true)
		{
			System.out.println("1.학생정보입력 \t 2.학생정보조회 \t 3.학생정보삭제 \t 4.학생정보수정 \t 5.학생검색(성을 검색) \t 9.종료");
			System.out.println("==================================================================================================");
			
			int no=Integer.parseInt(sc.nextLine());
			
			if(no==1)
			{
				my.getinsert();
			}
			else if(no==2)
			{
				my.getselect();
			}
			else if(no==3)
			{
				my.getdelete();
			}
			else if(no==4)
			{
				my.getupdate();
			}
			else if(no==5)
			{
				my.getsearch();
			}
			else if(no==9)
			{
				System.out.println("종료합니다.");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectMyStudentInfo mystudent=new ConnectMyStudentInfo();
		mystudent.output();

	}

}

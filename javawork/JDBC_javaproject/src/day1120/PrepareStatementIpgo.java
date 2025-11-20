package day1120;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day1119.DBConnect;

public class PrepareStatementIpgo {

	Scanner sc=new Scanner(System.in);
	DBConnect db=new DBConnect();

	//insert
	public void getsangpuminput() {

		System.out.println("상품의 카테고리를 입력해주세요.");
		String type=sc.nextLine();
		System.out.println("상품명을 입력해주세요.");
		String name=sc.nextLine();
		System.out.println("상품수량을 입력해주세요.");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("상품의 가격을 입력해주세요.");
		int price=Integer.parseInt(sc.nextLine());

		//String sql="insert into mymallipgo values(seq4.nextval, '"+type+"', '"+name+"', "+su+", "+price+", sysdate)";
		//PrepareStatement객체는 미완성된  sql문을 작성할 수 있다.
		//변수를 ?로 표시 후 나중에 바인딩 시켜준다
		String sql="insert into mymallipgo values(seq4.nextval, ?,?,?,?, sysdate)";

		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);

			//?순서대로 바인딩 
			pstmt.setString(1, type);
			pstmt.setString(2, name);
			pstmt.setInt(3, su);
			pstmt.setInt(4, price);

			//업데이트
			int a=pstmt.executeUpdate();

			if(a==1)
				System.out.println("인서트 성공");
			else
				System.out.println("인서트 실패");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	//select
	
	public void getSelectIpgo()
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from mymallipgo order by category";
		
		System.out.println("번호 \t 카테고리 \t 상품명 \t 상품수량 \t 가격 \t 입고일");
		System.out.println("---------------------------------------------------------");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.printf("%2d %10s %7s %3d %7d %12s\n", rs.getInt("num"), rs.getString("category"),rs.getString("sangpum"), rs.getInt("su"), rs.getInt("price"),rs.getDate("ipgo") );
			}
			
			System.out.println("상품재고 현황이 출력되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}


	//delete
	public void getDeleteIpgo()
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("삭제하실 번호를 입력해주세요.");
		int n=Integer.parseInt(sc.nextLine());
		String sql="delete from mymallipgo where num="+n;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			
			if(n==0)
				System.out.println("없는번호 입니다.");
			else
				System.out.println("삭제가 완료되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//update
	
	public void getUpdateIpgo()
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		System.out.println("수정 하실 상품번호를 입력해주세요.");
		int no=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 카테고리을 입력해주세요.");
		String utype=sc.nextLine();
		System.out.println("수정할 상품명을 입력해주세요.");
		String uname=sc.nextLine();
		System.out.println("수정할 상품의 수량을 입력해주세요.");
		int usu=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 상품의 가격을 입력해주세요.");
		int uprice=Integer.parseInt(sc.nextLine());
		
		String sql="update mymallipgo set category=?, sangpum=?, su=?,price=? where num=?";
		System.out.println(sql);
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?순서대로 바인딩
			pstmt.setString(1, utype);
			pstmt.setString(2, uname);
			pstmt.setInt(3, usu);
			pstmt.setInt(4, uprice);
			pstmt.setInt(5, no);
			
			pstmt.execute();
			
			System.out.println("업데이트 완료 되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			db.dbClose(pstmt, conn);
		}
		
		
	}
	
	//search
	public void getSearchIpgo()
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		System.out.println("검색어를 입력해주세요.");
		String s=sc.nextLine();
		
		String sql="select * from mymallipgo where sangpum like ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+s+"%");
			
			rs=pstmt.executeQuery();
			
			System.out.println("번호 \t 카테고리 \t 상품명 \t 상품수량 \t 가격 \t 입고일");
			System.out.println("---------------------------------------------------------");

			while(rs.next())
			{
				System.out.printf("%2d %10s %7s %3d %7d %12s\n", rs.getInt("num"), rs.getString("category"),rs.getString("sangpum"), rs.getInt("su"), rs.getInt("price"),rs.getDate("ipgo") );
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			db.dbClose(pstmt, conn);
		}
	}

	//write_process(출력문도 호출)
	public void processMymallIpgo()
	{
		PrepareStatementIpgo ipgo=new PrepareStatementIpgo();

		while(true)
		{
			System.out.println("\t ***MYMALL 입고 상풍 현황 ***");
			System.out.println("1.상품입고     2.상품재고현황     3.상품삭제     4.상품정보수정     5.상품검색     9.종료");
			System.out.println("=============================================================================");

			int selNum=Integer.parseInt(sc.nextLine());

			if(selNum==1)
				ipgo.getsangpuminput();
			else if(selNum==2)
				ipgo.getSelectIpgo();
			else if(selNum==3)
				ipgo.getDeleteIpgo();
			else if(selNum==4)
				ipgo.getUpdateIpgo();
			else if(selNum==5)
				ipgo.getSearchIpgo();
			else if(selNum==9)
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrepareStatementIpgo ppr=new PrepareStatementIpgo();
		ppr.processMymallIpgo();
	}

}

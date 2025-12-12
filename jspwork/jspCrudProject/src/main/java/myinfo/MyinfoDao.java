package myinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracle_db.DBConnect;

public class MyinfoDao{
	
	DBConnect db=new DBConnect();
	
	public void insertmyinfo(MyinfoDto dto) {
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String s="insert into myinfo values(seq1.nextval,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(s);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//select
	
	public Vector<MyinfoDto> getAllDates(){
		Vector<MyinfoDto>list =new Vector<MyinfoDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//num의 오름차순
		String s="select * from myinfo order by num";
		
		try {
			pstmt=conn.prepareStatement(s);
			rs=pstmt.executeQuery();
			
			//데이터 여러개 조회 시 while 하나 if
			while(rs.next()) {
				//반드시 while문 안에서 dto 선언
				MyinfoDto dto=new MyinfoDto();
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setSdate(rs.getTimestamp("sdate"));
				
				//리스트에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,pstmt, conn);
		}
		
		
		return list;
	}
	
	//delete
	public void deleteMyinfo(String num) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from myinfo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//update
	//수정에 필요한 하나의 데이터 조회
	public MyinfoDto getOneData(String num) {
		MyinfoDto dto=new MyinfoDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String s="select * from myinfo where num="+num;
		
		try {
			pstmt=conn.prepareStatement(s);
			rs=pstmt.executeQuery();
			
			//수정하려는 하나의 데이터만 필요하므로 if
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setSdate(rs.getTimestamp("sdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,pstmt, conn);
		}
		
		return dto;
	}
	
	//수정
	public void updateMyinfo(MyinfoDto dto) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String s="update myinfo set name=?, addr=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(s);
			
			//?바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setString(3, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
}
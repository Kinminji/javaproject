package guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.DBConnect;

public class guestDao {
	DBConnect db=new DBConnect();
	
	//insert
	public void insertGuest(guestDto dto) {
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="insert into guest values(null,?,?,?,now())";
				
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getEmot());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	//select
	public List<guestDto> getAllGuest(){
		List<guestDto> list=new ArrayList<guestDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from guest order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				guestDto dto=new guestDto();
				
				dto.setNum(rs.getString("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
				dto.setEmot(rs.getString("emot"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//delete
	public void deleteGuest(String num) {
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from guest where num=?";
		
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
	
	//num에 대한 하나의 dto
	public guestDto oneselectguest(String num) {
		guestDto dto=new guestDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from guest where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setEmot(rs.getString("emot"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				dto.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	//수정
	public void updateGuest(guestDto dto) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update guest set nickname=?, content=?, emot=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getEmot());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
}

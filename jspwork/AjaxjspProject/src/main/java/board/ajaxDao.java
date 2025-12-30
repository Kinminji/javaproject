package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.DBConnect;

public class ajaxDao {
	DBConnect db=new DBConnect();
	
	//insert
	public void insertBoard(ajaxDto dto) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="insert into boarde values(null,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmot());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//select
	public List<ajaxDto> selectBoard(){
		List<ajaxDto> list=new ArrayList<ajaxDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from boarde order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ajaxDto dto=new ajaxDto();
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
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
	public void delectBoard(String num) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from boarde where num=?";
		
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
	
	//oneselect
	public ajaxDto oneselectBoard(String num){
		ajaxDto dto=new ajaxDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from boarde where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setEmot(rs.getString("emot"));
				dto.setWriteday(rs.getTimestamp("writeday"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	//update
	
	public void updateBoard(ajaxDto dto) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update boarde set name=?, subject=?, content=?, emot=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmot());
			pstmt.setString(5, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
}

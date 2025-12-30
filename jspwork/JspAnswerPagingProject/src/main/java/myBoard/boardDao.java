package myBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.DBConnect;

public class boardDao {

	DBConnect db=new DBConnect();

	//select
	public List<boardDto> selectBoard(){
		List<boardDto> list=new ArrayList<boardDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myboard order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				 boardDto dto=new boardDto();
				 dto.setNum(rs.getString("num"));
				 dto.setWriter(rs.getString("writer"));
				 dto.setSubject(rs.getString("subject"));
				 dto.setContent(rs.getString("content"));
				 dto.setPath(rs.getString("path"));
				 dto.setWidthcount(rs.getInt("widthcount"));
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
	
	
	//insert
	public void insertBoard(boardDto dto) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="insert into myboard values(null,?,?,?,0,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPath());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//readcount
	public void updateWidthcount(String num) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update myboard set widthcount=widthcount+1 where num=?";
		
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
	public boardDto oneselectBoard(String num) {
		boardDto dto=new boardDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myboard where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {

				 dto.setNum(rs.getString("num"));
				 dto.setWriter(rs.getString("writer"));
				 dto.setSubject(rs.getString("subject"));
				 dto.setContent(rs.getString("content"));
				 dto.setPath(rs.getString("path"));
				 dto.setWidthcount(rs.getInt("widthcount"));
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
	
	//비밀번호 맞는지 체크
	public boolean ispathCheck(String num, String path) {
		boolean check=false;
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select count(*) from myboard where num=? and path=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, path);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1)==1) //비번이 틀릴경우 0, 초기값이 false니까 굳이 안줘도 됨
					check=true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return check;
	}
	
	//delete
	public void deleteBoard(String num) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from myboard where num=?";
		
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
	public void updateBoard(boardDto dto) {
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update myboard set writer=?, subject=?, content=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	
	//전체 갯수 반환
		public int getTotalCount() {
			int total=0;
			
			Connection conn=db.getDbConnect();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select count(*) from myboard";
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					total=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			return total;
			
		}
	
		
	//페이지 넘김
	public List<boardDto> pagingListBoard(int startNum, int perPage){
		List<boardDto> list=new ArrayList<boardDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myboard order by num desc limit ?,?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, perPage);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				 boardDto dto=new boardDto();
				 dto.setNum(rs.getString("num"));
				 dto.setWriter(rs.getString("writer"));
				 dto.setSubject(rs.getString("subject"));
				 dto.setContent(rs.getString("content"));
				 dto.setPath(rs.getString("path"));
				 dto.setWidthcount(rs.getInt("widthcount"));
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
}

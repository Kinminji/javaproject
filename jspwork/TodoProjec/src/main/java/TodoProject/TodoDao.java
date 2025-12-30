package TodoProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.DBConnect;

public class TodoDao {
	DBConnect db=new DBConnect();
	
	//insert
	public void insertTodo(TodoDto dto) {
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="insert into todo values(null,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getEmot());
			pstmt.setString(3, dto.getScope());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//oneselect
	public TodoDto oneSelectTodo(String num){
		TodoDto dto=new TodoDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from todo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setContent(rs.getString("content"));
				dto.setEmot(rs.getString("emot"));
				dto.setScope(rs.getString("scope"));
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
	
	//delete
	
	//update
}

package myBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PresentationDirection;

import mysql.DBConnect;

public class boardAnswerDao {

	DBConnect db=new DBConnect();
	
	//insert
	public void insertAnswer(boardAnswerDto dto) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="insert into myboardanswer values(null,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getComment());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//select
	public List<boardAnswerDto> selectAnswer(int num){
		List<boardAnswerDto> list=new ArrayList<boardAnswerDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myboardanswer where num=? order by idx desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				boardAnswerDto dto=new boardAnswerDto();
				dto.setIdx(rs.getString("idx"));
				dto.setNum(rs.getInt("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setComment(rs.getString("comment"));
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
	public void deleteAnswer(String idx) {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from myboardAnswer where idx=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
}

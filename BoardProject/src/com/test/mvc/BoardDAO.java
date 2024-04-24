package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConn;

public class BoardDAO
{
	private Connection conn;
	
	// 데이터베이스 연결
	public void connection() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	public void close() throws SQLException
	{
		DBConn.close();
	}
	
	
	
	
	public int boardWrite(String title, String content) throws SQLException
	{
		int result = 0;
		
		String sql = "INSERT INTO TBL_BOARD(BD_ID, BD_TITLE, BD_CONTENT) VALUES(BD_SEQ.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
	}
	
	
	public ArrayList<BoardDTO> BoardList() throws SQLException
	{
		ArrayList<BoardDTO> result = new ArrayList<BoardDTO>();
		
		String sql = "SELECT BD_ID, BD_TITLE, BD_CONTENT FROM TBL_BOARD ORDER BY 1";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery(sql);
		while (rs.next())
		{
			BoardDTO dto = new BoardDTO();
			
			dto.setBd_id(rs.getInt("BD_ID"));
			dto.setBd_title(rs.getString("BD_TITLE"));
			dto.setBd_content(rs.getString("BD_CONTENT"));
			
			result.add(dto);
		}
		
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	
	

}

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
	
	
	
	// 게시물 작성
	public int boardWrite(BoardDTO dto) throws SQLException
	{
		int result = 0;
		
		String sql = "INSERT INTO TBL_BOARD(BD_ID, BD_TITLE, BD_CONTENT, FILENAME, FILEPATH) VALUES(BD_SEQ.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getBd_title());
		pstmt.setString(2, dto.getBd_content());
		pstmt.setString(3, dto.getFileName());
		pstmt.setString(4, dto.getFilePath());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	// 게시물 리스트
	public ArrayList<BoardDTO> BoardList() throws SQLException
	{
		ArrayList<BoardDTO> result = new ArrayList<BoardDTO>();
		
		String sql = "SELECT BD_ID, BD_TITLE, BD_CONTENT FROM TBL_BOARD ORDER BY 1 DESC";
		
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
	
	
	// 특정 게시물 
	public BoardDTO boardView(int bd_id) throws SQLException
	{
		BoardDTO result = new BoardDTO();
		
		String sql = "SELECT BD_ID, BD_TITLE, BD_CONTENT, FILENAME, FILEPATH FROM TBL_BOARD WHERE BD_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bd_id);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			result.setBd_id(bd_id);
			result.setBd_title(rs.getString("BD_TITLE"));
			result.setBd_content(rs.getString("BD_CONTENT"));
			result.setFileName(rs.getString("FILENAME"));
			result.setFilePath(rs.getString("FILEPATH"));
		}
		
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	
	// 게시물 삭제
	public int boardDelete(int bd_id) throws SQLException
	{
		int result = 0;
		
		String sql = "DELETE FROM TBL_BOARD WHERE BD_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bd_id);
		
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
	
	// 게시물 수정
	public int boardModify(BoardDTO brd) throws SQLException
	{
		int result = 0;
		
		String sql = "UPDATE TBL_BOARD SET BD_TITLE = ?, BD_CONTENT = ? WHERE BD_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, brd.getBd_title());
		pstmt.setString(2, brd.getBd_content());
		pstmt.setInt(3, brd.getBd_id());
		
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
	
	// 게시물 갯수
	public int listCount() throws SQLException
	{
		int result = 0;
		
		String sql = "SELECT COUNT(BD_ID) AS COUNT FROM TBL_BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			result = rs.getInt("COUNT");
		
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	
	
	

}

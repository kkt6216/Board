/*==========================================
	BoardController.java
	- 사용자 정의 컨트롤러 클래스
	- 『@Controller』 어노테이션 등록
	- 『@RequestMapping』 어노테이션 등록
 ==========================================*/

package com.test.mvc;

import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;					//-- check~!!!
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;		//-- check~!!!
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;




// ※ Controller Annotation 활용
@Controller												//-- check~!!
public class BoardController
{
	
	
	// 게시판 리스트 페이지 메소드
	@RequestMapping("/hello.action")
	public String hello(Model model) throws ClassNotFoundException, SQLException
	{
		ArrayList<BoardDTO> brdList = new ArrayList<BoardDTO>();
		
		
		BoardDAO dao = new BoardDAO();
		dao.connection();
		brdList = dao.BoardList();
		
		model.addAttribute("brdList", brdList);
		
		
		return "BoardList.jsp";
	}
	
	
	// 게시글 작성 액션 처리 메소드
	@RequestMapping("/boardwrite.action")
	public String write(Model model, String bd_title, String bd_content, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException, ClassNotFoundException, SQLException 
	{
		// 파일 저장 경로
		String filePath = "C:/Users/1/git/Board/BoardProject/WebContent/files/" + file.getOriginalFilename();
        // 파일 저장
		file.transferTo(new File(filePath));
		
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		
		dto.setBd_title(bd_title);
		dto.setBd_content(bd_content);
		dto.setFileName(file.getOriginalFilename());
		dto.setFilePath(filePath);
		
		
		dao.connection();
		dao.boardWrite(dto);
	  	dao.close();
		  
	  	model.addAttribute("message", "글 작성이 완료되었습니다."); 
	  	model.addAttribute("url","/BoardProject/hello.action");
		 
		
		return "Message.jsp";
	}
	
	/*
	 * // 다운로드
	 * 
	 * @RequestMapping(value = "/download.action") public String download(String
	 * bd_id) { BoardDTO dto = new BoardDTO();
	 * 
	 * String filePath = dto.getFilePath();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return ""; }
	 */
	
	
	
	// 특정 게시글 불러오기
	@RequestMapping("/boardview.action")
	public String boardView(int bd_id, Model model) throws SQLException, ClassNotFoundException
	{
		BoardDAO dao = new BoardDAO();
		BoardDTO brd = new BoardDTO();
		
		dao.connection();
		brd = dao.boardView(bd_id);
		
		model.addAttribute("brd", brd);		
		
		return "BoardView.jsp";
	}
	
	
	// 게시물 삭제
	@RequestMapping("/boarddelete.action")
	public String boardDelete(int bd_id) throws SQLException, ClassNotFoundException
	{
		BoardDAO dao = new BoardDAO();
		
		dao.connection();
		dao.boardDelete(bd_id);
		
		return "redirect:hello.action";
	}
	
	
	// 수정폼 이동
	@RequestMapping("/boardupdateform.action")
	public String updateForm(int bd_id, Model model) throws ClassNotFoundException, SQLException
	{
		BoardDAO dao = new BoardDAO();
		BoardDTO brd = new BoardDTO();
		
		dao.connection();
		brd = dao.boardView(bd_id);
		
		model.addAttribute("brd", brd);	
		
		return "BoardUpdateForm.jsp";
	}
	
	// 게시물 수정    
	@RequestMapping("/boardupdate.action")
	public String boardModify(Model model, int bd_id, String bd_title, String bd_content) throws ClassNotFoundException, SQLException
	{
		BoardDAO dao = new BoardDAO();
		BoardDTO brd = new BoardDTO();
		
		System.out.println("gd");
		
		brd.setBd_id(bd_id);
		brd.setBd_title(bd_title);
		brd.setBd_content(bd_content);
		
		dao.connection();
		
		dao.boardModify(brd);
		
		return "redirect:hello.action";
	}
	
	
	
}












































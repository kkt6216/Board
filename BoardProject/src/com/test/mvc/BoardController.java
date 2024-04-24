/*==========================================
	BoardController.java
	- 사용자 정의 컨트롤러 클래스
	- 『@Controller』 어노테이션 등록
	- 『@RequestMapping』 어노테이션 등록
 ==========================================*/

package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;					//-- check~!!!
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;		//-- check~!!!

// ※ Controller Annotation 활용
@Controller												//-- check~!!
public class BoardController
{
	
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
	
	
	
	@RequestMapping("/boardwrite.action")
	public String write(String title, String content) throws SQLException, ClassNotFoundException
	{
		BoardDAO dao = new BoardDAO();
		
		dao.connection();
		dao.boardWrite(title, content);
		dao.close();
		
		return "redirect:hello.action";
	}
	
	
	@RequestMapping("/boardview.action")
	public String boardView(String bd_id)
	{
		
		
		
		return "";
	}
	
	
	
	
}












































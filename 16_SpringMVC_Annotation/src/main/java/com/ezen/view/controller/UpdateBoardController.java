// 0620 글 수정
package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class UpdateBoardController {

	@RequestMapping("/updateBoard.do")
	public String updateBoard (BoardVO vo, BoardDAO boardDao) {

		// updateBoard 전달하여 게시글 수정
		boardDao.updateBoard(vo);
		
		return "getBoardList.do";
	}

}

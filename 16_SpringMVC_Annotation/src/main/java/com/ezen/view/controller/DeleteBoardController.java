package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class DeleteBoardController {

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard (BoardVO vo, BoardDAO boardDao ) {

		// 게시글 일련번호로 확인 후 삭제

		boardDao.deleteBoard(vo);

		return "getBoardList.do";
	}
}

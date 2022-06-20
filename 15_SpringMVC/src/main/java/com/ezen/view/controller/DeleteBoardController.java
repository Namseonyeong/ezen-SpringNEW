package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 게시글 일련번호로 확인 후 삭제
		String seq = request.getParameter("seq");

		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDao = new BoardDAO();
		boardDao.deleteBoard(vo);

		// 응답
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("redirect:getBoardList.do");

		return modelView;

	}

}

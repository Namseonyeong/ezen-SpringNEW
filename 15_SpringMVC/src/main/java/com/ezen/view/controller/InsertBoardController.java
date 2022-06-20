// 0620 글 등록
package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1. 사용자 입력 정보 추출
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		// 3. 화면 네비게이션
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("redirect:getBoardList.do");  // redirect를 넣는 이유는 사용자가 재요청하는것처럼 하기 위해서
		
		return modelView;
	}

}

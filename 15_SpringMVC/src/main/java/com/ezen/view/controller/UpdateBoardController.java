// 0620 글 수정
package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 화면에서 받기
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		
		// 받은 데이터 변수에 저장
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));
		
		// updateBoard 전달하여 게시글 수정
		BoardDAO boardDao = new BoardDAO();
		boardDao.updateBoard(vo);
		
		
		// 게시글 수정 응답 처리
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("redirect:getBoardList.do"); //게시글 목록 디스플레이 
		
		return modelView;
	}

}

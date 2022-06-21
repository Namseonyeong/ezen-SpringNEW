package com.ezen.biz.board;

import java.util.List;

import com.ezen.biz.dto.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO board);

	void updateBoard(BoardVO board);

	void deleteBoard(BoardVO board);

	List<BoardVO> getBoardList(BoardVO vo);

	BoardVO getBoard(BoardVO board);

}
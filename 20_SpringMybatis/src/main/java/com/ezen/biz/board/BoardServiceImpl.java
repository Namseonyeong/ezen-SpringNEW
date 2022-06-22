package com.ezen.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

/*
 * 	-------  BoardService 인터페이스를 구현한 클래스.  -------
 */

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO bDao;

	public BoardServiceImpl() {
	}

	@Override
	public void insertBoard(BoardVO board) {
		bDao.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board) {
		bDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(BoardVO board) {
		bDao.deleteBoard(board);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return bDao.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO board) {
		return bDao.getBoard(board);
	}

}

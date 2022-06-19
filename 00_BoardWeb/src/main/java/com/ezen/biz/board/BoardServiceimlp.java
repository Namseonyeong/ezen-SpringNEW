//0610 인터페이스를 구현한 클래스
package com.ezen.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

//Serviceimlp를 Main에서 호출할 수 있게 객체로 등록 / @Service
@Service("boardService")
public class BoardServiceimlp implements BoardService {


	
	//insert에서 사용할수있게 
	@Autowired //생성된 객체를...? 
	private BoardDAO bDao;
	@Override
	public void insertBoard(BoardVO board) {
		bDao.insertBoard(board);
	}
	
	@Override
	public void updateBoard(BoardVO board) {
		bDao.updateBoard(board);
	}
	
	@Override
	public void daleteBoard(BoardVO board) {
		bDao.deleteBoard(board);
	}
	
	@Override
	public List<BoardVO> getBoardList() {
		
		//BoardVO 타입의 값을 boardList(변수)에 담지않고 바로 호출
		return bDao.getBoardList();
	}
	
	@Override
	public BoardVO getBoard(BoardVO board) {
		
		return bDao.getBoard(board);
	}
	
	
}
s
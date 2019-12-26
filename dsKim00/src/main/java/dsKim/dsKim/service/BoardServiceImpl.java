package dsKim.dsKim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsKim.dsKim.dto.BoardDTO;
import dsKim.dsKim.mapper.BoardMapper;


/**
 * @author ds.kim
 *게시판 서비스부분
 */
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	/**
	 *전체 게시글 리스트 조회 service
	 */
	@Override
	public List<BoardDTO> selectBoardList() throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardList();
	}

	/**
	 *게시글 등록 service
	 */
	@Override
	public void insertBoard(BoardDTO board) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.insertBoard(board);
		
	}

	/**
	 *게시글 상세정보 service
	 */
	@Override
	public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.updateHitCount(boardIdx);
		BoardDTO board = new BoardDTO();
		board = boardMapper.selectBoardDetail(boardIdx);
		return board;
	}

	/**
	 *게시글 삭제 service
	 */
	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.deleteBoard(boardIdx);
	}

	/**
	 *게시글 수정
	 */
	@Override
	public void updateBoard(BoardDTO board) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.updateBoard(board);
		
	}

	

}

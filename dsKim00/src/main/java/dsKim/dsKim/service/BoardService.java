package dsKim.dsKim.service;

import java.util.List;

import dsKim.dsKim.dto.BoardDTO;

/**
 * @author ds.kim
 * 게시판  서비스 interface
 */
public interface BoardService {
	
	public List<BoardDTO> selectBoardList() throws Exception;
	public void insertBoard(BoardDTO board) throws Exception;
	public BoardDTO selectBoardDetail(int boardIdx) throws Exception;
	public void updateBoard(BoardDTO board) throws Exception;
	public void deleteBoard(int boardIdx) throws Exception;

}

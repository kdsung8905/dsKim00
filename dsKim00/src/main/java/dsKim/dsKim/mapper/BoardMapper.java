package dsKim.dsKim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dsKim.dsKim.dto.BoardDTO;
import dsKim.dsKim.dto.BoardFileDTO;

/**
 * @author ds.kim
 * 게시판 mapper 인터페이스
 */
@Mapper
public interface BoardMapper {

	public List<BoardDTO> selectBoardList() throws Exception;	//전체리스트를 불러온다
	public void insertBoard(BoardDTO board) throws Exception;	//게시글 등록
	public BoardDTO selectBoardDetail(int boardIdx) throws Exception;	//게시글 상세정보 보기
	public void updateHitCount(int boardIdx) throws Exception;		//조회수 up
	public void updateBoard(BoardDTO board) throws Exception;		//게시글 수정
	public void deleteBoard(int boardIdx) throws Exception;			//게시글 삭제
	public void insertBoardFileList(List<BoardFileDTO> list) throws Exception;
	
}

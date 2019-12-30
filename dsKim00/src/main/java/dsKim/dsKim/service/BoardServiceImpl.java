package dsKim.dsKim.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import dsKim.common.FileUtils;
import dsKim.dsKim.dto.BoardDTO;
import dsKim.dsKim.dto.BoardFileDTO;
import dsKim.dsKim.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;


/**
 * @author ds.kim
 *게시판 서비스부분
 */
@Service
@Slf4j
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileUtils fileUtils;

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
	public void insertBoard(BoardDTO board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.insertBoard(board);
		System.out.println("========================================================================================================="+board.getBoardIdx());
		List<BoardFileDTO> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
		
		if(CollectionUtils.isEmpty(list) == false) {
			boardMapper.insertBoardFileList(list);
		}
		
	}

	/**
	 *게시글 상세정보 service
	 */
	@Override
	public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.updateHitCount(boardIdx);
		
		
		return boardMapper.selectBoardDetail(boardIdx);
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

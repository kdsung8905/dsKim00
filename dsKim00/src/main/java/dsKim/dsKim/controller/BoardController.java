package dsKim.dsKim.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dsKim.dsKim.dto.BoardDTO;
import dsKim.dsKim.service.BoardService;

/**
 * @author ds.kim
 *게시판 컨트롤러
 */
/**
 * @author ds.kim
 *
 */
/**
 * @author ds.kim
 *
 */
@Controller

public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * @return mav(ModelAndView)
	 * @throws Exception
	 * 메인게시판으로 이동
	 */
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception{
		
		ModelAndView mav = new ModelAndView("/board/boardList");
		
		List<BoardDTO> list = boardService.selectBoardList();
		mav.addObject("list", list);
		
		return mav;
	}
	
	/**
	 * @return /board/boardWrite
	 * @throws Exception
	 * 글쓰기 화면으로 이동
	 */
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
		return "/board/boardWrite";
	}
	
	/**
	 * @param board
	 * @return redirect:/board/openBoardList.do
	 * @throws Exception
	 * 새로운 게시글 등록
	 */
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDTO board) throws Exception{
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	/**
	 * @param boardIdx
	 * @return mav(ModelAndView)
	 * @throws Exception
	 * 게시글 상세(글 읽기)
	 */
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception{
		ModelAndView mav = new ModelAndView("/board/boardDetail");
		
		BoardDTO board = boardService.selectBoardDetail(boardIdx);
		mav.addObject("board", board);
		return mav;
	}
	
	/**
	 * @param board
	 * @return redirect:/board/openBoardList.do
	 * @throws Exception
	 * 게시글 수정
	 * 
	 */
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDTO board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	/**
	 * @param boardIdx
	 * @return
	 * @throws Exception
	 * 게시글 삭제
	 */
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList.do";
	}
	
}

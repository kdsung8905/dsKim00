package dsKim;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dsKim.dsKim.dto.BoardDTO;
import dsKim.dsKim.service.BoardService;
import lombok.extern.log4j.Log4j2;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log4j2
public class BoardServiceTest {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testgetList()throws Exception {
		service.selectBoardList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testRead() throws Exception{
		log.info(service.selectBoardDetail(32));
	}
	
	@Test
	public void testInsert() throws Exception{
		BoardDTO dto = new BoardDTO();
		dto.setTitle("서비스테스트");
		dto.setContent("서비스테스트");
		
		service.insertBoard(dto);
		log.info(dto);
		
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardDTO dto = new BoardDTO();
		dto.setBoardIdx(43);
		dto.setTitle("서비스업데이트테스트");
		dto.setContent("서비스업데이트테스트");
		
		service.updateBoard(dto);
		log.info(dto);
	}
	
	@Test
	public void testDelete() throws Exception{
		service.deleteBoard(43);
	}

}

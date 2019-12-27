package dsKim;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dsKim.dsKim.dto.BoardDTO;
import dsKim.dsKim.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log4j2
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList()throws Exception {
		mapper.selectBoardList().forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testInsert() throws Exception{
		
			BoardDTO dto = new BoardDTO();
		IntStream.rangeClosed(1, 10).forEach(i -> {
			dto.setTitle("메가커피1"+i);
			dto.setContent("아메리카노1"+i);
			try {
				mapper.insertBoard(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void testRead() throws Exception{
		log.info(mapper.selectBoardDetail(28));
	}
	
	@Test
	public void testUpdate() throws Exception{
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardIdx(28);
		dto.setContent("(수정완료)메가커피 메뉴");
		dto.setTitle("메뉴수정(오렌지에이드)");
		
		
		mapper.updateBoard(dto);
		log.info(dto);
	}
	
	@Test
	public void testDelete() throws Exception{
		mapper.deleteBoard(32);
	}
	
	@Test
	public void testHitCnt() throws Exception{
		mapper.updateHitCount(32);
	}
	
	

}

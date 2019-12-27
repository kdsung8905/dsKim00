package dsKim;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTest {
	
	@Autowired
	MockMvc mockMvc;

	@Test
	public void testGetList() throws Exception {
		assertThat(mockMvc).isNotNull();
		mockMvc.perform(get("/board/openBoardList.do")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testCreate() throws Exception{
		assertThat(mockMvc).isNotNull();
		mockMvc.perform(post("/board/insertBoard.do")
				.param("title", "302")
				.param("content", "302")
				).andExpect(status().is3xxRedirection()).andDo(print());
	}
	
	@Test
	public void testRead() throws Exception{
		mockMvc.perform(get("/board/openBoardDetail.do")
				.param("boardIdx", "44")
				).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testUpdate() throws Exception{
		mockMvc.perform(post("/board/updateBoard.do")
				.param("boardIdx", "44")
				.param("title", "컨트롤러수정테스트")
				.param("content", "컨트롤러수정테스트")
				).andExpect(status().is3xxRedirection()).andDo(print());
	}
	
	@Test
	public void testDelete() throws Exception{
		mockMvc.perform(delete("/board/deleteBoard.do")
				.param("boardIdx", "47")
				).andExpect(status().is3xxRedirection()).andDo(print());
	}
	
}

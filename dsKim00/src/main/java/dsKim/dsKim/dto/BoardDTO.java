package dsKim.dsKim.dto;

import lombok.Data;

/**
 * @author ds.kim
 *게시판에 대한 DTO
 */
@Data
public class BoardDTO {
	private int boardIdx;	//글번호
	private String title;	//글제목
	private String content;	//내용
	private int hitCnt;		//조회수
	private String creatorId;		//작성자
	private String regDate;			//작성일
	private String updateDate;		//수정일

}

package dsKim.dsKim.dto;

import lombok.Data;

@Data
public class BoardFileDTO {

	private int fileIdx;
	private int boardIdx;
	private String originalFileName;
	private String storeFilePath;
	private long fileSize;
	
}

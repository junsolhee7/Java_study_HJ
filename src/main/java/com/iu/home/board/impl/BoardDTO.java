package com.iu.home.board.impl;

import java.sql.Date;

import com.iu.home.file.FileDTO;

public class BoardDTO extends FileDTO {
	
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private Long hit;
	private BoardFileDTO boardFileDTO;
	
	
	
	public BoardFileDTO getBoardFileDTO() {
		return boardFileDTO;
	}
	public void setBoardFileDTO(BoardFileDTO boardFileDTO) {
		this.boardFileDTO = boardFileDTO;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	
	

}
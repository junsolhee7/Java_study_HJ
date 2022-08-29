package com.iu.home.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.bankMembers.BankMembersFileDTO;
import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.impl.BoardFileDTO;
import com.iu.home.board.impl.BoardService;
import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		
		Long totalCount=noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		return noticeDAO.getList(pager); 
	}
	public Long getCount(Pager pager)throws Exception{
		return noticeDAO.getCount(pager);
	}
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception{
		int result = noticeDAO.setAdd(boardDTO);
		String path = "resources/upload/notice";
		
		for(MultipartFile multipartFile : files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}
			//HD저장하는코드

//			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
//
//			noticeFileDTO.setFileName(fileName);
//			noticeFileDTO.setOriName(mf.getOriginalFilename());
//			noticeFileDTO.setNum(boardDTO.getNum());
//

//
////			DB저장하는코드
			
		return result;
		
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setDelete(boardDTO);
	}
	
	
}

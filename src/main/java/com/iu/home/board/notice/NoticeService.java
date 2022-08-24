package com.iu.home.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.impl.BoardService;

@Service
public class NoticeService implements BoardService {

	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Long page) throws Exception{
		System.out.println("Service page: " + page);
		Long perPage = 15L;//한페이지에 출력할 목록의 갯수
		//Page		startRow 		lastRow
		//1			1/1				10/15
		//2			11/16			20/30
		//3			21/31			30/45
		Long startRow = (page-1) * perPage + 1 ;
		Long lastRow = page * perPage;
		
		System.out.println("StartRow : "+startRow);
		System.out.println("LastRow : "+lastRow);
		Map<String,Long> map = new HashMap <String,Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		/********************************
		 * 글의 갯수가 총 53개
		 * 1-15
		 * 2-15
		 * 3-15
		 * 4-8
		 */
		return noticeDAO.getList(map); 
	}
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setDelete(boardDTO);
	}
	
	public Long getCount()throws Exception{
		return noticeDAO.getCount();
	}

	
	
}

package com.iu.home.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.impl.BoardService;
import com.iu.home.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		
		Long totalCount=noticeDAO.getCount();
		pager.getNum(totalCount);
		pager.getRowNum();
		
//		System.out.println("Service page: " + page);
//		Long perPage = 10L;//한페이지에 출력할 목록의 갯수
//		//Page		startRow 		lastRow
//		//1			1				10
//		//2			11				20
//		//3			21				30
//		Long startRow = (page-1) * perPage + 1 ;
//		Long lastRow = page * perPage;
//		
//		System.out.println("StartRow : "+startRow);
//		System.out.println("LastRow : "+lastRow);
//		Map<String,Long> map = new HashMap <String,Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
//		/********************************
//		 * JSP에 페이지번호를 출력 1-?
//		 * 1.글의 총갯수 (53)
//		 * 2.총 페이지 수 구하기 (5+1) {50+3}
//		 */
//		Long totalCount = noticeDAO.getCount();
//		Long totalPage = totalCount/perPage;
//		if(totalCount/perPage!=0) {
//			totalPage++;
//		}
//		
//		System.out.println("totalPage : "+totalPage);
//		/********************************
//		 * 3. totalBlock 갯수 구하기
//		 * Block : 1-5, 6-10, 11-15
//		 * perBlock : 한페이지에 출력할 번호의수
//		 */
//		Long perBlock=5L;
//		Long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock!=0) {
//			totalBlock++;
//		}
//		System.out.println("totalBlock : "+totalBlock);
//		
//		/********************************
//		 * 4. page로 현재 Block번호 찾기
//		 * 
//		 * page				curBlock
//		 * 1					1
//		 * 2					1
//		 * 5					1
//		 * ...
//		 * 6					2
//		 */
//		Long curBlock = page/perBlock;
//		if(page%perBlock!=0) {
//			curBlock++;
//		}
//		System.out.println("curBlock : "+curBlock);
//	
//		/********************************
//		 * 5.현재 Block번호로 시작번호와 끝번호 알아오기
//		 * 
//		 * curBlock		startNum	lastNum
//		 * 1			1			5
//		 * 2			6			10
//		 * 3			11			15
//		 * ...
//		 */
////		Long startNum = curBlock*perBlock-(perBlock-1);
//		Long startNum = (curBlock-1)*perBlock+1;
//		Long lastNum = curBlock*perBlock;
//		System.out.println("startNum : "+startNum);
//		System.out.println("lastNum : "+lastNum);
		
		return noticeDAO.getList(pager); 
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

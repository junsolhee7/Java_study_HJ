package com.iu.home.board.notice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void setAddTest()throws Exception{
//		for(int i=100;i<200;i++) {
//			NoticeDTO noticeDTO = new NoticeDTO();
//			noticeDTO.setTitle("Title"+i);
//			noticeDTO.setWriter("Writer"+i);
//			noticeDTO.setContents("Contents"+i);
//			
//			int result = noticeDAO.setAdd(noticeDTO);
//			
//			if(i%10==0) {
//				Thread.sleep(500);
//			}
//			
//		}
//	}
	
	@Test
	public void getCountTest() throws Exception{
			long count = noticeDAO.getCount();
			assertEquals(102L,count);
	}
}

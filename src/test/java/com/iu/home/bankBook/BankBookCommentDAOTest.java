package com.iu.home.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyAbstractTest;
import com.iu.home.util.CommentPager;

public class BankBookCommentDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

//	@Test
//	public void getCommentListTotalCount() throws Exception{
//		
//		bankBookCommentDAO.getCommentListTotalCount();
//		assertNotEqualss(0,ar.size);
//	}
	
	@Test
	public void getCommentListTest() throws Exception{
		CommentPager commentPager = new CommentPager();
		commentPager.setBookNum(1660194298495L);
		commentPager.setPage(1L);
		commentPager.getRowNum();
		
		List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(null);
		assertNotEquals(0, ar.size());
	}
	//@Test
	public void setCommentAdd() throws Exception{
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setWriter("reply");
		bankBookCommentDTO.setContents("contents");
		bankBookCommentDTO.setBookNum(1660800406484L);
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1,result);
	}

}

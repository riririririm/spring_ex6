package com.rim.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rim.board.BoardDTO;
import com.rim.s6.AbstractTest;
import com.rim.util.PageMaker;

public class NoticeDAOTest extends AbstractTest {

	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	
	/*
	 * @Before public void t() {}
	 * 
	 * @BeforeClass public void t() {}
	 * 
	 * @After public void t() {}
	 * 
	 * @AfterClass public void t() {}
	 */
	
	//@Test
	public void selectList() throws Exception {
		PageMaker pageMaker=null;
		List<BoardDTO> ar = noticeDAOImpl.getList(pageMaker);
		
		assertEquals(3, ar.size());
	}
	
	//@Test
		public void selectOne() throws Exception {
			BoardDTO boardDTO = noticeDAOImpl.getSelect(17);
			System.out.println(boardDTO.getTitle());
			assertNotNull(boardDTO);
		}
	
	
	//@Test
	public void delete() throws Exception {
		int num=24;
		int result =noticeDAOImpl.setDelete(num);
		assertEquals(1, result);
	}
	
	//@Test
	public void update() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setContents("ccc");
		boardDTO.setTitle("ccc");
		boardDTO.setNum(17);
		//boardDTO.setWriter("mmmm");
		int result =noticeDAOImpl.setUpdate(boardDTO);
		
		assertEquals(1, result);
	}

}

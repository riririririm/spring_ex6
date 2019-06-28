package com.rim.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.rim.board.BoardDTO;
import com.rim.s6.AbstractTest;
import com.rim.util.PageMaker;

public class NoticeServiceTest extends AbstractTest{

	@Inject
	private NoticeServiceImpl noticeService;
	
	@Test
	public void test() throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCurPage(1);
		
		List<BoardDTO> ar = noticeService.getList(pageMaker);
		assertEquals(10, ar.size());
	}

}

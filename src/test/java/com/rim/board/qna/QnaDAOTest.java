package com.rim.board.qna;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.rim.board.BoardDTO;
import com.rim.s6.AbstractTest;

public class QnaDAOTest extends AbstractTest{

	@Inject
	private QnaDAO qnaDAO;
	
	//@Test
	public void insert() throws Exception {
		QnaDTO boardDTO = new QnaDTO();
		boardDTO.setTitle("qqq");
		boardDTO.setContents("qqq");
		boardDTO.setWriter("qqq");
		
		int result= qnaDAO.setWrite(boardDTO);
		assertNotEquals(0, result);
	}
	
	//@Test
	public void delete() throws Exception {
		int num=1;
		
		int result= qnaDAO.setDelete(num);
		assertNotEquals(0, result);
	}
	
	
	
	//@Test
	public void update() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("ttt");
		boardDTO.setContents("ttt");
		boardDTO.setNum(1);
		int result= qnaDAO.setUpdate(boardDTO);
		System.out.println(result);
		assertNotEquals(0, result);
	}
	
	//@Test
	public void selectOne() throws Exception {
		int num=2;
		
		BoardDTO qnaDTO= qnaDAO.getSelect(num);
		assertNull(qnaDTO);
	}
	
	//@Test
	public void selectList() throws Exception {
				
		List<BoardDTO> ar= qnaDAO.getList();
		assertNotEquals(0, ar.size());
	}

}

package com.rim.board.notice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.rim.board.BoardDTO;
import com.rim.board.BoardService;
import com.rim.util.PageMaker;

@Service
public class NoticeServiceImpl implements BoardService{

	@Inject
	private NoticeDAOImpl noticeDAO;
	
	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		int result=0;
		result=noticeDAO.setWrite(boardDTO);
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		pageMaker.makeRow();
		
		//페이징처리 계산
		int totalCount = noticeDAO.getTotalCount();
		pageMaker.makePage(totalCount);
		return noticeDAO.getList(pageMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		BoardDTO noticeDTO = new BoardDTO();
		noticeDTO = noticeDAO.getSelect(num);
		return noticeDTO;
	}

	@Override
	public int setDelete(int num) throws Exception {
		int result = noticeDAO.setDelete(num);
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		int result = noticeDAO.setUpdate(boardDTO);
		return result;
	}

}

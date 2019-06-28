package com.rim.board.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.rim.board.BoardDAO;
import com.rim.board.BoardDTO;
import com.rim.util.DBConnector;
import com.rim.util.PageMaker;

import oracle.net.aso.b;

@Repository
public class NoticeDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private String mapper = "NoticeMapper.";
	
	@Override
	public int setDelete(int num) throws Exception {
		int result = sqlSession.delete(mapper+"noticeDelete",num);
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.update(mapper+"noticeUpdate",boardDTO);
		return result;
	}

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.insert(mapper+"noticeWrite", boardDTO);
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		System.out.println(pageMaker.getStartRow());
		System.out.println(pageMaker.getLastRow());
		List<BoardDTO> ar = sqlSession.selectList(mapper+"noticeList",pageMaker);
		return ar;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		
		return sqlSession.selectOne(mapper+"noticeSelect",num);
	}
	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		
		return sqlSession.selectOne(mapper+"totalCount", pageMaker);
	}

	

}

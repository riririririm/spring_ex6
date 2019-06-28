package com.rim.util;

import org.apache.ibatis.cache.impl.PerpetualCache;

public class PageMaker {
	private int perPage=10;
	
	private Integer curPage; //int가 아닌 Integer는 레퍼런스 타입이라서 null이 들어갈 수 있다. 대신 형변환 필수
	private String kind;
	private String search;
	
	//rownum
	private int startRow;
	private int lastRow;
	
	//page
	private int totalBlock;
	private int curBlock;
	private int startNum;
	private int lastNum;
	
	
	
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	
	
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
		if(curPage==null)this.curPage=1;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
	
	public int getStartRow() {
		return startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	
	
	//startRow, lastRow 계산
	public void makeRow() {
		this.startRow = (this.curPage-1)*perPage +1;
		this.lastRow = this.curPage*perPage;
	}
	
	//
	public void makePage(int totalCount) {
		//1.전체글의 갯수
		//2.totalPage구하기
		int totalPage = totalCount/perPage;
		if(totalCount%perPage !=0)
			totalPage++;
		
		//3.totalBlock
		int perBlock=5;
		this.totalBlock=totalPage/perBlock;
		if(totalPage%perBlock !=0)
			this.totalBlock++;
		
		//4.curPage를 이용해서 curBlock
		this.curBlock = curPage/perBlock;
		if(this.curBlock%perBlock !=0)
			curBlock++;
		
		//5.startNum, lastNum
		this.startNum=(this.curBlock-1)*perBlock+1;
		this.lastNum=this.curBlock*perBlock;
		
		//6.curBlock이 totalBlock일때
		if(this.curBlock==totalBlock)
			this.lastNum = totalPage;
		
		
	}
	

}

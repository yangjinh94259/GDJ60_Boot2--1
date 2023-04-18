package com.iu.base.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {

	//page 번호 담을 변수
	private Long page;
	
	//한페이지에 보여줄 글의 갯수
	private Long perPage;
	
	//시작 index 번호
	private Long startRow;
	
	private String kind;
	
	private String search;
	
	private Long startNum;
	private Long lastNum;
	
	public void makeNum(Long totalCount) {
		Long totalPage = totalCount / this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		Long totalBlock = totalPage / 5;
		if(totalPage % 5 != 0) {
			totalBlock++;
		}
		
		Long curBlock = this.getPage() / 5;
		if(this.getPage() % 5 != 0) {
			curBlock++;
		}
		
		startNum = (curBlock-1)*5+1 ;
		lastNum = curBlock * 5;
		
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
		
	}
	
	//시작 index 번호를 계산하는 메서드
	public void makeStartRow() {
		//page = 1, startRow = 0
		//page = 2, startRow = 10
		//page = 3, startRow = 20
		this.startRow=(this.getPage()-1) * this.getPerPage();
	}
	
	public Long getPage() {
		if(this.page == null || this.page == 0) {
			this.page=1L;
		}
		
		return this.page;
	}
	
	public Long getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage=10L;
		}
		
		return this.perPage;
	}
	
	public String getSearch() {
		if(this.search)
	}
	
}

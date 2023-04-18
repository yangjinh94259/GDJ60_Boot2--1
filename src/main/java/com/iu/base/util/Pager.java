package com.iu.base.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {
   
   //page 번호 담을 변수
   private Long page;
   
   //한 페이지에 보여줄 글의 개수
   private Long perPage;
   
   //시작 index 번호
   private Long startRow;
   
   //검색 종류
   private String kind;
   //검색어
   private String search;
   
   //한 블럭당 출력할 번호의 갯수
   private Long perBlock;
   
   //전체 페이지 갯수
   private Long totalPage;
   
   //전체 row의 갯수를 담을 변후
   //private Long totalCount;
   
   //시작 페이지 번호
   private Long startNum;
   
   //끝 페이지 번호
   private Long lastNum;
   
   private boolean before;
   private boolean after;
   
   //page 계산하는 메서드
   public void makeNum(Long totalCount) {
      //1.전체 글의 갯수를 받아옴
      
      //2.전체 글의 갯수로 전체 페이지 갯수 구하기
      Long totalPage = totalCount / this.getPerPage();
      if(totalCount % this.getPerPage() != 0) {
         totalPage++;
      }
      
      if(this.getPage() > totalPage) {
         this.setPage(totalPage);
      }
      
      //perBlock의 개수
      Long perBlock = 5L;
      
      //3.전체 페이지로 전체 블럭의 갯수 구하기
      Long totalBlock = totalPage / perBlock;
      
      if(totalPage % perBlock != 0) {
         totalBlock++;
      }
      
      //4. page 번호로 현재 블럭 번호 구하기
      Long curBlock = this.getPage() / perBlock;
      if(this.getPage() % perBlock != 0) {
         curBlock++;
      }
      
      //5. 현재 블럭 번호로 시작 번호와 끝번호 구하기
      //curBlock   startNum  lastNum
      // 1            1        5
      // 2            6        10
      // 3           11        15
      
      this.startNum = (curBlock-1) * perBlock + 1;
      this.lastNum = curBlock * perBlock;
      
      //6. 현재블럭 번호가 마지막 블럭 이라면 끝번호는 전체 페이지 번호와 같음
      if(curBlock == totalBlock) {
         lastNum = totalPage;
      }
      
      //7. 이전블럭, 다음블럭 가능한지 유무
      this.after= true;
      
      if(curBlock == 1) {
         this.before= true;
      }   
   }
   
   //시작 index 번호를 계산하는 메서드
   public void makeStartRow() {
      //page = 1, startRow = 0
      //page = 2, startRow = 10
      //page = 3, startRow = 20
      this.startRow = (this.getPage()-1) * this.getPerPage();
   }
   
   public Long getPage() {
      if(this.page == null || this.page == 0) {
         this.page = 1L;
      }
      
      return this.page;
   }
   
   public Long getPerPage() {
      if(this.perPage == null || this.perPage == 0) {
         this.perPage = 10L;
      }
      return this.perPage;
   }
   
   public String getSearch() {   
      if(this.search == null) {
         this.search="";
      }
      return search;
   }
   
}
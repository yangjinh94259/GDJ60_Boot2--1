package com.iu.base.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.base.board.BoardVO;

@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	void setInsertTest() throws Exception{
//		for(int i=0; i < 120; i++) {
//			BoardVO boardVO = new NoticeVO();
//			
//			boardVO.setName("iu" + i);
//			boardVO.setTitle("Insert Test" + i);
//			boardVO.setInfo("Insert Test" + i);
//			
//			int result = noticeDAO.setInsert(boardVO);
//			
//			if(i % 10 == 0) {
//				Thread.sleep(500);
//			}
//		}
//		System.out.println("종료");
//	}
//	
//	@Test
//	void setUpdateTest() throws Exception{
//		BoardVO boardVO = new NoticeVO();
//		
//		boardVO.setNum(1L);
//		boardVO.setName("iu2");
//		boardVO.setTitle("Insert Test2");
//		boardVO.setInfo("Insert Test2");
//		
//		int result = noticeDAO.setUpdate(boardVO);
//		
//		assertEquals(1, result);
//	}
	
//	@Test
//	void setDeleteTest() throws Exception{
//		BoardVO boardVO = new NoticeVO();
//		
//		boardVO.setNum(11L);
//		
//		int result = noticeDAO.setDelete(boardVO);
//		
//		assertEquals(1, result);
//	}

}

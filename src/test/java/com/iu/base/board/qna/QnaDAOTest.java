package com.iu.base.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.base.board.BoardVO;
import com.iu.base.board.notice.NoticeDAO;

@SpringBootTest
class QnaDAOTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	void setInsertTest() throws Exception{
		for(int i=0; i < 120; i++) {
			BoardVO boardVO = new QnaVO();
			
			boardVO.setName("iu" + i);
			boardVO.setTitle("Insert Test" + i);
			boardVO.setInfo("Insert Test" + i);
			
			int result = qnaDAO.setInsert(boardVO);
			
			if(i % 10 == 0) {
				Thread.sleep(500);
			}
		}
		System.out.println("종료");
	}
}

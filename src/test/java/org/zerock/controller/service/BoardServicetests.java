package org.zerock.controller.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import static org.junit.Assert.assertNotNull;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServicetests {
    @Setter(onMethod_ =@Autowired)
    private BoardService boardService;

    @Test
    public void testExist(){
        log.info(boardService);
        assertNotNull(boardService);
    }
    @Test
    public void testRegister(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 글");
        boardVO.setContent("새로 작성하는 내용");
        boardVO.setWriter("newbie");
        boardService.register(boardVO);
        log.info("생성된 게시물 번호: "+boardVO.getBno());
    }
    @Test
    public void getGEtList(){
        boardService.getList().forEach(boardVO -> log.info(boardVO));
    }
    @Test
    public void testGet(){
        log.info(boardService.get(21L));
    }
}

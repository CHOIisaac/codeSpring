package org.zerock.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        log.info(mapper.getList());
//        mapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testInsert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 글");
        boardVO.setContent("새로 작성하는 내용");
        boardVO.setWriter("newbie");
        mapper.insert(boardVO);
        log.info(boardVO);
    }
    @Test
    public void testInsertSelectKey(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 글 select key");
        boardVO.setContent("새로 작성하는 내용 select key");
        boardVO.setWriter("newbie");
        mapper.insertSelectKey(boardVO);
        log.info(boardVO);
    }
    @Test
    public void testRead(){
        BoardVO boardVO = mapper.read(22L);
        log.info(boardVO);
    }
    @Test
    public void testDelete(){
        log.info("DELETE COUNT: "+mapper.delete(1L));
    }
    @Test
    public void testUpdate(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBno(21L);
        boardVO.setTitle("수정된 제목");
        boardVO.setContent("수정된 내용");
        boardVO.setWriter("user00");

        int count = mapper.update(boardVO);
        log.info("UPDATE COUNT: "+count);
    }
    @Test
    public void testPaging(){
        Criteria cri = new Criteria();
        cri.setPageNum(3);
        cri.setAmount(10);
        List<BoardVO> list = mapper.getListWithPaging(cri);
        list.forEach(boardVO -> log.info(boardVO.getBno()));
    }
}

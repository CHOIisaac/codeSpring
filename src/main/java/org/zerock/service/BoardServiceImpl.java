package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
    @Setter(onMethod_ =@Autowired)
    private BoardMapper boardMapper;

    @Override
    public void register(BoardVO boardVO){
        log.info("register................."+boardVO);
        boardMapper.insertSelectKey(boardVO);
    }
    public BoardVO get(Long bno){
        log.info("get..........."+bno);
        return boardMapper.read(bno);
    }
    public boolean modify(BoardVO boardVO){
        log.info("modify.........."+boardVO);
        return boardMapper.update(boardVO)==1;
    }
    public boolean remove(Long bno){
        log.info("remove.........."+bno);
        return boardMapper.delete(bno)==1;
    }
    public List<BoardVO> getList(Criteria cri){
        log.info("getList With criteria................ "+ cri);
        return boardMapper.getListWithPaging(cri);
    }
}

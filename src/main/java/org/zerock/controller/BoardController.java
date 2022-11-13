package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private BoardService service;

    @GetMapping("/list")
    public void list(Criteria cri, Model model){
        log.info("list");
        model.addAttribute("list", service.getList(cri));
        model.addAttribute("pageMaker", new PageDTO(cri, 123));
        log.info("list");
    }

    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes rttr){
        log.info("register: "+boardVO);
        service.register(boardVO);
        rttr.addFlashAttribute("result", boardVO.getBno());
        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/modify"})
    public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model){
        log.info("/get or modify");
        model.addAttribute("board",service.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO boardVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr){
        log.info("modify: "+boardVO);
        if(service.modify(boardVO)){
            rttr.addFlashAttribute("result", "success");
        }
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount",cri.getAmount());
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr){
        log.info("remove.........");
        if (service.remove(bno)){
            rttr.addFlashAttribute("result", "success");
        }
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount",cri.getAmount());
        return "redirect:/board/list";
    }
}

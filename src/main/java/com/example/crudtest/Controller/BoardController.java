package com.example.crudtest.Controller;


import com.example.crudtest.Entitiy.Board;
import com.example.crudtest.Service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    public final BoardService boardService;

    @GetMapping
    public String boards(Model model){
        List<Board> boards = boardService.BoardList();
        model.addAttribute("boards",boards);
        return "boards/boards";
    }

    @GetMapping("/{uid}")
    public String board(@PathVariable("uid") String uid,Model model){
        boardService.ViewcntUpdate(uid);
        Optional<Board> result = boardService.BoardOne(uid);
        Board board = result.get();
        model.addAttribute("board",board);
        return "boards/board";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("board",new Board());
        return "boards/addForm";
    }

    @PostMapping("/add")
    public String addBoard(@ModelAttribute Board board, RedirectAttributes redirectAttributes){
        boardService.BoardAdd(board);
        return "redirect:/boards";
    }












}

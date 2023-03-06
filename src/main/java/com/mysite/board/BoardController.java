package com.mysite.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
//	public String boardlist(Model model) {
//		List<Board> boardlist = this.boardService.findAll();
//		model.addAttribute("boardList",boardList);
//		return "board_list";
//	}
}

package com.mysite.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	
	public String detail(Model model,@PathVariable("id") Integer id) {
		Board bo = this.boardService.getBoard(id);
		
		model.addAttribute("Board",bo);
		return "board_detail";
		
	}
}

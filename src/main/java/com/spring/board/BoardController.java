package com.spring.board;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.domain.Board;
import com.spring.logger.LoggerInterceptor;

@Controller
@RequestMapping("/board")
@SessionAttributes("board")
public class BoardController {
	Logger log = Logger.getLogger(BoardController.class.getName());
	
	@Autowired BoardService boardService;
	
	@RequestMapping("/list")
	public void list (Model model){
		model.addAttribute("list", boardService.list());
	}
	
	@RequestMapping("/addForm")
	public void addForm (Model model){
		model.addAttribute("board", new Board());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addFormSubmit(@Valid Board board, BindingResult result){
		if(result.hasErrors())
			return "board/addForm";
		boardService.add(board);
		System.out.println(board);
		return "redirect:/board/list";
	}
	@RequestMapping(value="/delete/{num}")
	public String delete(@PathVariable int num){
		boardService.delete(num);
	return "redirect:/board/list";
	}
	@RequestMapping("/{num}")
	public String view(@PathVariable int num, Model model){
		model.addAttribute("board", boardService.get(num));
	return "board/view";
	}
	@RequestMapping(value= "/update/{num}", method=RequestMethod.GET)
	public String updateForm(@PathVariable int num, Model model){
		model.addAttribute("board", boardService.get(num));
		return "board/update";
	}
	
	@RequestMapping(value= "/update", method=RequestMethod.POST)
	public String updateFormSubmit(@Valid Board board, BindingResult result, SessionStatus status){
		if(result.hasErrors()){
			return "board/update";
		}
		boardService.update(board);
		status.setComplete();
		return "redirect:/board/list";
	}
}

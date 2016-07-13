package com.spring.board;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.springframework.web.servlet.ModelAndView;

import com.spring.common.CommandMap;
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
////////////////////////////////////// MAP 학습용 /////////////////////////////////////////	
	@RequestMapping(value="/test")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("");
	     
	    if(commandMap.isEmpty() == false){
	        Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
	        Entry<String,Object> entry = null;
	        while(iterator.hasNext()){
	            entry = iterator.next();
	            log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
	        }
	    }
	    return mv;
	}
	@RequestMapping(value="/openBoardWrite")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/board/write");
	     
	    return mv;
	}
	@RequestMapping(value="/insertBoard")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/openBoardList");
		
		boardService.insertBoard(commandMap.getMap());
		return mv;
	}
	
   @RequestMapping(value="/openBoardList")
    public ModelAndView openSampleBoardList(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/board/list");
         
        List<Map<String,Object>> list = boardService.selectBoardList(commandMap.getMap());
        mv.addObject("list", list);
         
        return mv;
    }
   
   @RequestMapping(value="/openBoardDetail")
   public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
       ModelAndView mv = new ModelAndView("/board/detail");
        
       Map<String,Object> map = boardService.selectBoardDetail(commandMap.getMap());
       if(log.isDebugEnabled()){
    	   log.debug("map parameter    :    "+map);
       }
       mv.addObject("map", map);
        
       return mv;
   }
	   
}

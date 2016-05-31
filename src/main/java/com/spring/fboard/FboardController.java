package com.spring.fboard;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.domain.Fboard;

@Controller
@RequestMapping("/fboard")
@SessionAttributes("fboard")
public class FboardController {

	@Autowired FboardService fboardService;
	
	@RequestMapping("/list")
	public void list (Model model){
		model.addAttribute("list", fboardService.list());
	}
	
	@RequestMapping("/addForm")
	public void addForm (Model model){
		model.addAttribute("fboard", new Fboard());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addFormSubmit(@Valid Fboard fboard, BindingResult result){
		if(result.hasErrors())
			return "fboard/addForm";
		fboardService.add(fboard);
		System.out.println(fboard);
		return "redirect:/fboard/list";
	}
	@RequestMapping(value="/delete/{num}")
	public String delete(@PathVariable int num){
		fboardService.delete(num);
	return "redirect:/fboard/list";
	}
	@RequestMapping("/{num}")
	public String view(@PathVariable int num, Model model){
		model.addAttribute("fboard", fboardService.get(num));
	return "fboard/view";
	}
	@RequestMapping(value= "/update/{num}", method=RequestMethod.GET)
	public String updateForm(@PathVariable int num, Model model){
		model.addAttribute("fboard", fboardService.get(num));
		return "fboard/update";
	}
	
	@RequestMapping(value= "/update", method=RequestMethod.POST)
	public String updateFormSubmit(@Valid Fboard fboard, BindingResult result, SessionStatus status){
		if(result.hasErrors()){
			return "fboard/update";
		}
		fboardService.update(fboard);
		status.setComplete();
		return "redirect:/fboard/list";
	}
}

package com.spring.user;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.domain.User;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

	@Autowired UserService userService;
	
	@RequestMapping("/list")
	public void list (Model model){
		model.addAttribute("list", userService.list());
	}
	
	@RequestMapping("/addForm")
	public void addForm (Model model){
		model.addAttribute("user", new User());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addFormSubmit(@Valid User user, BindingResult result){
		if(result.hasErrors())
			return "user/addForm";
		userService.add(user);
		return "redirect:/user/list";
	}
	@RequestMapping(value="/delete/{num}")
	public String delete(@PathVariable int num){
		userService.delete(num);
	return "redirect:/user/list";
	}
	@RequestMapping("/{num}")
	public String view(@PathVariable int num, Model model){
		model.addAttribute("user", userService.get(num));
	return "user/view";
	}
	@RequestMapping(value= "/update/{num}", method=RequestMethod.GET)
	public String updateForm(@PathVariable int num, Model model){
		model.addAttribute("user", userService.get(num));
		return "user/update";
	}
	
	@RequestMapping(value= "/update", method=RequestMethod.POST)
	public String updateFormSubmit(@Valid @ModelAttribute User user, BindingResult result, SessionStatus status){
		if(result.hasErrors()){
			return "user/update";
		}
		userService.update(user);
		status.setComplete();
		return "redirect:/user/list";
	}
	@RequestMapping("/login")
	public void login(Model model){
		model.addAttribute("user", new User());
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userLoginInfo", null);
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute User user, HttpSession session) {
		
		User loginUser = userService.findByUserIdAndPassword(user.getId(), user.getPassword());
		if (loginUser != null) {
			session.setAttribute("userLoginInfo", loginUser);
		}
		return "redirect:/user/login";
	}
}

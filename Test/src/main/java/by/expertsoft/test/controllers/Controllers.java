package by.expertsoft.test.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.expertsoft.test.entity.User;
import by.expertsoft.test.service.UserService;

@Controller
public class Controllers {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/menu")
	public String doMenu(Model model){
		return "menu";
	}
	
	@RequestMapping(value="/list")
	public ModelAndView doList(){
		ModelAndView mav = new ModelAndView();
		
		List<User> allUsers;
		try {
			allUsers = userService.getAllUser();
			
			mav.addObject("users", allUsers);
			mav.setViewName("list");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/add")
	public String doAdd(Model model){
		return "add";
	}
	
	@ModelAttribute("users")
	private User populateUser(){
		return new User();
	}
}

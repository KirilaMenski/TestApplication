package by.expertsoft.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import by.expertsoft.test.entity.User;
import by.expertsoft.test.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/sorting_{colName}")
	public String sortByColName(@PathVariable String colName, Model model){
		
		List<User> assortedVal;
		try{
			assortedVal = userService.sortByColumnName(colName);
			model.addAttribute("users", assortedVal);
		}catch(Exception e){
			e.printStackTrace();
		}

		return "list";
		
	}

}

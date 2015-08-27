package by.expertsoft.test.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.expertsoft.test.action.ReaderCSV;
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
	
	@RequestMapping(value="/convert", method=RequestMethod.POST)
	public String convToDB(HttpServletRequest request){
		ReaderCSV readerCSV = new ReaderCSV();
		
		readerCSV.convertToBD(request.getParameter("title"));
		System.out.println(request.getParameter("title"));
		
		return "redirect:/list";
	}

}

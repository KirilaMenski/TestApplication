package by.expertsoft.test.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.expertsoft.test.DAOImpl.UserDAOImpl;
import by.expertsoft.test.entity.User;
import by.expertsoft.test.service.UserService;

@Controller
public class Controllers {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/menu")
	public String doMenu(Model model) {
		return "menu";
	}

	@RequestMapping(value = "/list_{numb}")
	public ModelAndView doList(@PathVariable int numb) {
		ModelAndView mav = new ModelAndView();

		List<User> usersOnPage;
		List<User> allUsers;
		List<Integer> numbPages = new ArrayList<Integer>();

		try {
			usersOnPage = userService.getAllUser(numb);
			allUsers = userService.getAllUser();
			
			double pages = (double) allUsers.size()
					/ (double) UserDAOImpl.MAX_RES;

			for (int i = 0; i < Math.ceil(pages); i++) {
				numbPages.add(i + 1);
			}

			mav.addObject("numb", numbPages);
			mav.addObject("users", usersOnPage);
			mav.setViewName("list");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/add")
	public String doAdd(Model model) {
		return "add";
	}

	@ModelAttribute("users")
	private User populateUser() {
		return new User();
	}

}

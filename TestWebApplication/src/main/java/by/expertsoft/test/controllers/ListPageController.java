package by.expertsoft.test.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.expertsoft.test.DAOImpl.UserDAOImpl;
import by.expertsoft.test.entity.User;
import by.expertsoft.test.service.UserService;
import by.expertsoft.test.serviceImpl.UserServiceImpl;

@WebServlet("/listPage")
public class ListPageController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		List<User> usersOnPage = new ArrayList<User>();
		List<User> users = new ArrayList<User>();
		List<Integer> numbPages = new ArrayList<Integer>();
		
//		numb = Integer.parseInt(request.getParameter("numb"));
		
		try {
			// usersOnPage = userService.getAllUser(numb);
			users = userService.getAllUser();

			for (int i = 0; i < Math.ceil((double) users.size()
					/ (double) UserDAOImpl.MAX_RES); i++) {
				numbPages.add(i + 1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("users", users);
		request.setAttribute("numb", numbPages);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}

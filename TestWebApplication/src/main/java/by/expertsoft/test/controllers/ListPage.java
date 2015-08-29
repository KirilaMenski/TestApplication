package by.expertsoft.test.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.expertsoft.test.entity.User;
import by.expertsoft.test.service.UserService;
import by.expertsoft.test.serviceImpl.UserServiceImpl;

@WebServlet("/index")
public class ListPage extends HttpServlet {

	private UserService userService = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		List<User> users = new ArrayList<User>();
		try {
			users = userService.getAllUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("users", users);

		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");

		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}

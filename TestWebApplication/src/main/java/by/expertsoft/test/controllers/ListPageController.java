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
	private ColName name = new ColName();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		int numPage = 1;
		String colName = null;

		if (request.getParameter("page") != null) {
			numPage = Integer.parseInt(request.getParameter("page"));
		}

		colName = request.getParameter("colName");
		
		if(colName != null){
			name.setColName(colName);
		}

		List<User> usersOnPage = new ArrayList<User>();
		List<User> users = new ArrayList<User>();
		List<Integer> pages = new ArrayList<Integer>();

		try {
			usersOnPage = userService.sortByColumnName(name.getColName(), numPage);
			users = userService.getAllUser();

			for (int i = 0; i < Math.ceil((double) users.size()
					/ (double) UserDAOImpl.MAX_RES); i++) {
				pages.add(i + 1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(numPage);
		System.out.println(name.getColName());

		request.setAttribute("users", usersOnPage);
		request.setAttribute("page", pages);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}

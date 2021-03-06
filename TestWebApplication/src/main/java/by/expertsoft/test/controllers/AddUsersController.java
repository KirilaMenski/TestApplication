package by.expertsoft.test.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.expertsoft.test.action.ReaderCSV;

@WebServlet("/addUsers")
public class AddUsersController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ReaderCSV readerCSV = new ReaderCSV();
		
		String title = request.getParameter("title");
		
		readerCSV.convertToBD(title);
		
		response.sendRedirect("listPage");

	}

}

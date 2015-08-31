package by.expertsoft.test.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.expertsoft.test.DAO.UserDAO;
import by.expertsoft.test.DAOImpl.UserDAOImpl;
import by.expertsoft.test.entity.User;
import by.expertsoft.test.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO = new UserDAOImpl();

	public void addUser(User user) throws SQLException {
		userDAO.addUser(user);
	}

	public void editUser(User user) throws SQLException {
		userDAO.editUser(user);
	}

	public void deleteUser(User user) throws SQLException {
		
	}

	public List<User> getAllUser() throws SQLException {
		List<User> users = new ArrayList<User>();
		users = userDAO.getAllUser();
		return users;
	}

	public List<User> getAllUser(int page) throws SQLException {
		List<User> userOnPage = new ArrayList<User>();
		userOnPage = userDAO.getAllUser(page);
		return userOnPage;
	}

	public List<User> sortByColumnName(String colName) throws SQLException {
		List<User> assortedUsers = new ArrayList<User>();
		assortedUsers = userDAO.sortByColumnName(colName);
		return assortedUsers;
	}

	public List<User> sortByColumnName(String colName, int page)
			throws SQLException {
		List<User> assortedUsers = new ArrayList<User>();
		assortedUsers = userDAO.sortByColumnName(colName, page);
		return assortedUsers;
	}

}

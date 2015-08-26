package by.expertsoft.test.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.expertsoft.test.DAO.UserDAO;
import by.expertsoft.test.entity.User;
import by.expertsoft.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void addUser(User user) throws SQLException {
		userDAO.addUser(user);
	}

	public void editUser(User user) throws SQLException {
		userDAO.editUser(user);
	}

	@Transactional
	public void deleteUser(User user) throws SQLException {
		userDAO.deleteUser(user);
	}

	@Transactional
	public List<User> getAllUser() throws SQLException {
		List<User> allUsers = new ArrayList<User>();
				allUsers = userDAO.getAllUser();
		return allUsers;
	}

	@Transactional
	public List<User> sortByColumnName(String colName) throws SQLException {
		List<User> assortedVal = userDAO.sortByColumnName(colName);
		return assortedVal;
	}

}

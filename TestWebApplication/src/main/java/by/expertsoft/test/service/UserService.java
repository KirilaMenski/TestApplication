package by.expertsoft.test.service;

import java.sql.SQLException;
import java.util.List;

import by.expertsoft.test.entity.User;

public interface UserService {

	public void addUser(User user) throws SQLException;

	public void editUser(User user) throws SQLException;

	public void deleteUser(User user) throws SQLException;

	public List<User> getAllUser() throws SQLException;

	public List<User> getAllUser(int numb) throws SQLException;

	public List<User> sortByColumnName(String colName) throws SQLException;

	public List<User> sortByColumnName(String colName, int numb)
			throws SQLException;

}

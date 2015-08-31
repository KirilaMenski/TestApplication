package by.expertsoft.test.DAO;

import java.sql.SQLException;

import by.expertsoft.test.entity.User;

public interface UsersConvert {
	
	public void convUsers(User user) throws SQLException;
	
	public void editUsers(User user, long id) throws SQLException;

}

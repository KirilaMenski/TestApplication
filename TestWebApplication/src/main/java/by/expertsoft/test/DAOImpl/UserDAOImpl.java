package by.expertsoft.test.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.expertsoft.test.DAO.UserDAO;
import by.expertsoft.test.entity.User;
import by.expertsoft.test.util.ConnectionPool;

public class UserDAOImpl implements UserDAO {

	public void addUser(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement prepStatment = null;

		try {

			connection = ConnectionPool.getConnection();
			prepStatment = connection
					.prepareStatement("INSERT INTO user (name, surname, login, email, phone_number) VALUES (?, ?, ?, ?, ?)");
			prepStatment.setString(1, user.getName());
			prepStatment.setString(2, user.getSurname());
			prepStatment.setString(3, user.getLogin());
			prepStatment.setString(4, user.getEmail());
			prepStatment.setInt(5, user.getPhoneNumb());
			prepStatment.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepStatment != null) {
				prepStatment.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	public void editUser(User user) throws SQLException {

		Connection connection = null;
		PreparedStatement prepStatment = null;

		try {

			connection = ConnectionPool.getConnection();
			prepStatment = connection
					.prepareStatement("UPDATE user SET name = ?, surname = ?, login = ?, email = ?, phone_number = ? WHERE id = ?");
			prepStatment.setString(1, user.getName());
			prepStatment.setString(2, user.getSurname());
			prepStatment.setString(3, user.getLogin());
			prepStatment.setString(4, user.getEmail());
			prepStatment.setInt(5, user.getPhoneNumb());
			prepStatment.setLong(6, user.getId());
			prepStatment.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepStatment != null) {
				prepStatment.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	public List<User> getAllUser() throws SQLException {
		List<User> users = new ArrayList<User>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try{
			
			connection = ConnectionPool.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM user");
			while(resultSet.next()){
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				String login = resultSet.getString("login");
				String email = resultSet.getString("email");
				int phoneNumber = resultSet.getInt("phone_number");
				users.add(new User(id, name, surname, login, email,phoneNumber));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(resultSet != null){
				resultSet.close();
			}
			if(connection != null){
				connection.close();
			}
			if(statement != null){
				statement.close();
			}
		}
		
		return users;
	}

	public List<User> getAllUser(int numb) throws SQLException {
		return null;
	}

	public List<User> sortByColumnName(String colName) throws SQLException {
		return null;
	}

	public List<User> sortByColumnName(String colName, int numb)
			throws SQLException {
		return null;
	}

}

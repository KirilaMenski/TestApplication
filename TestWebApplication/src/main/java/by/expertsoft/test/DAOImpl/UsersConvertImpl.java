package by.expertsoft.test.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.expertsoft.test.DAO.UsersConvert;
import by.expertsoft.test.entity.User;
import by.expertsoft.test.util.ConnectionPool;

public class UsersConvertImpl implements UsersConvert {

	public void convUsers(User user) throws SQLException {
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

	public void editUsers(User user, long id) throws SQLException {
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
			prepStatment.setLong(6, id);
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

}

package by.expertsoft.test.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import by.expertsoft.test.DAO.UserDAO;
import by.expertsoft.test.DAO.UsersConvert;
import by.expertsoft.test.DAOImpl.UserDAOImpl;
import by.expertsoft.test.DAOImpl.UsersConvertImpl;
import by.expertsoft.test.entity.User;

public class ReaderCSV {

	private BufferedReader reader = null;
	private String separator = ",";
	private User user = new User();
	private UsersConvert usersConv = new UsersConvertImpl();
	private UserDAO allUsers = new UserDAOImpl();

	public synchronized void convertToBD(String title) {

		try {

			reader = new BufferedReader(new FileReader(title));
			// addToDB(reader);
			check(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void check(BufferedReader reader) {
		String[] values;

		try {
			while (reader.ready()) {
				values = reader.readLine().split(separator);

				List<User> users = allUsers.getAllUser();
				if (users.size() == 0) {
					addToDB(reader);
				}
				for (int i = 0; i < users.size(); i++) {

					if (users.get(i).getName().equals(values[0])) {
						update(values, users.get(i).getId());

					} else {
						addToDB(reader);
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addToDB(BufferedReader reader) {
		String[] values;
		try {
			while (reader.ready()) {
				values = reader.readLine().split(separator);
				user.setName(values[0]);
				user.setSurname(values[1]);
				user.setLogin(values[2]);
				user.setEmail(values[3]);
				user.setPhoneNumb(Integer.parseInt(values[4]));

				usersConv.convUsers(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void update(String[] values, long id) {
		try {
			user.setName(values[0]);
			user.setSurname(values[1]);
			user.setLogin(values[2]);
			user.setEmail(values[3]);
			user.setPhoneNumb(Integer.parseInt(values[4]));

			usersConv.editUsers(user, id);

			System.out.println("update" + values[0] + "\t" + values[2]);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

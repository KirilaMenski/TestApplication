package by.expertsoft.test.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import by.expertsoft.test.DAO.UsersConvert;
import by.expertsoft.test.DAOImpl.UsersConvertImpl;
import by.expertsoft.test.entity.User;

public class ReaderCSV {

	private BufferedReader reader = null;
	private String separator = ",";
	private User user = new User();
	private UsersConvert usersConv = new UsersConvertImpl();
	
	public void convertToBD(String title) {

		try {

			reader = new BufferedReader(new FileReader(title));
			addToDB(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public synchronized void addToDB(BufferedReader reader) {

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

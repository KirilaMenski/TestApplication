package by.expertsoft.test.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import by.expertsoft.test.entity.User;
import by.expertsoft.test.util.Factory;

public class ReaderCSV {

	private BufferedReader reader = null;
	private String separator = ",";
	private User user = new User();
	public void convertToBD(String title) {

		try {

			reader = new BufferedReader(new FileReader(title));
			addToDB(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addToDB(BufferedReader reader) {

		String[] values;
		try {
			while (reader.ready()) {

				values = reader.readLine().split(separator);
				user.setName(values[0]);
				user.setSurname(values[1]);
				user.setLogin(values[2]);
				user.setEmail(values[3]);
				user.setPhoneNumb(Integer.parseInt(values[4]));
				Factory.getInstance().getUserConvert().convUsers(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package by.expertsoft.test.util;

import by.expertsoft.test.DAO.UsersConvert;
import by.expertsoft.test.DAOImpl.UsersConvertImpl;

public class Factory {

	private static UsersConvert userConv = null;
	private static Factory instance = null;

	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public UsersConvert getUserConvert() {
		if (userConv == null) {
			userConv = new UsersConvertImpl();
		}
		return userConv;
	}

}

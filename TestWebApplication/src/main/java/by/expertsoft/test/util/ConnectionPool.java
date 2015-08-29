package by.expertsoft.test.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;

public class ConnectionPool {

	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "yj55";
	private static DataSource dataSource;

	static {
		DriverAdapterCPDS adapterCPDS = new DriverAdapterCPDS();

		try {
			adapterCPDS.setDriver(DRIVER);
			adapterCPDS.setUrl(URL);
			adapterCPDS.setUser(USERNAME);
			adapterCPDS.setPassword(PASSWORD);

			SharedPoolDataSource sharedPool = new SharedPoolDataSource();
			sharedPool.setConnectionPoolDataSource(adapterCPDS);

			dataSource = sharedPool;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}

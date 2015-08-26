package by.expertsoft.test.DAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.expertsoft.test.DAO.UserDAO;
import by.expertsoft.test.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) throws SQLException {
		try{
			currentSession().save(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void editUser(User user) throws SQLException {
		try{
			currentSession().update(user);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteUser(User user) throws SQLException {
		try{
			currentSession().delete(user);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser() throws SQLException {
		List<User> allUsers = new ArrayList<User>();
		try{
			allUsers = currentSession().createQuery("FROM User").list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return allUsers;
	}

	@SuppressWarnings("unchecked")
	public List<User> sortByColumnName(String colName) throws SQLException {
		List<User> assortedVal = new ArrayList<User>();
		switch (colName.toLowerCase()) {
		case "name":
			assortedVal = currentSession().createQuery("SELECT u FROM User u ORDER BY u.name").list();
			break;
		case "surname":
			assortedVal = currentSession().createQuery("SELECT u FROM User u ORDER BY u.surname").list();
			break;
		case "login":
			assortedVal = currentSession().createQuery("SELECT u FROM User u ORDER BY u.login").list();
			break;
		case "email":
			assortedVal = currentSession().createQuery("SELECT u FROM User u ORDER BY u.email").list();
			break;
		case "phonenumber":
			assortedVal = currentSession().createQuery("SELECT u FROM User u ORDER BY u.phoneNumber").list();
			break;

		}
		return assortedVal;
	}

	public Session currentSession() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession;
	}
}

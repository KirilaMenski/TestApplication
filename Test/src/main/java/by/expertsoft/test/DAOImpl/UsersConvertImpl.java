package by.expertsoft.test.DAOImpl;

import java.sql.SQLException;

import org.hibernate.Session;

import by.expertsoft.test.DAO.UsersConvert;
import by.expertsoft.test.entity.User;
import by.expertsoft.test.util.HibernateUtil;

public class UsersConvertImpl implements UsersConvert {

	public void convUsers(User user) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen() & session != null) {
				session.close();
			}
		}
	}

}

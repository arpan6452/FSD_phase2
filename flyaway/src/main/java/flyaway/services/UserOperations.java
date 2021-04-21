package flyaway.services;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import flyaway.model.Role;
import flyaway.model.RoleName;
import flyaway.model.User;
import flyaway.utils.DBConnection;

public class UserOperations {
	public static void main(String[] args) {
		UserOperations userOperations = new UserOperations();
		userOperations.searchUser("arpaghos@gmail.com", "arpan123");
		//userOperations.updatePassword("arpaghos1@gmail.com", "arpan123");
		//userOperations.createUser("arpaghos@gmail.com", "Arpan", "Ghosh", "user", "arpan@123");
	}
	
	public User createUser(String email, String firstName,String lastName, String password, String roleName) {
		Role role = new Role();
		if(roleName.equalsIgnoreCase("Admin")) {
			role.setName(RoleName.ROLE_ADMIN);
		}else {
			role.setName(RoleName.ROLE_USER);
		}
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setRole(role);
		DBConnection dbconnection = DBConnection.getInstance();
		SessionFactory sf = dbconnection.getSession();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(user);
		session.save(role);
		session.flush();
		transaction.commit();
		session.close();
		return user;
	}

	public List searchUser(String emailID, String password) {
		DBConnection dbconnection = DBConnection.getInstance();
		SessionFactory sf = dbconnection.getSession();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("select user from User user where email=:emailID and password=:pass");
		q.setParameter("emailID",emailID);
		q.setParameter("pass",password);
		List list = q.getResultList();
		session.flush();
		transaction.commit();
		session.close();
		return list;
	}
	
	public int updatePassword(String emailID, String newPassword) {
		DBConnection dbconnection = DBConnection.getInstance();
		SessionFactory sf = dbconnection.getSession();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("update User set password=:newPassword where email=:emailID");
		q.setParameter("newPassword",newPassword);
		q.setParameter("emailID",emailID);
		int status=q.executeUpdate();
		session.flush();
		transaction.commit();
		session.close();
		return status;
	}
}

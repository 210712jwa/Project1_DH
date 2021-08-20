package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.User;
import com.revature.model.UserRole;

public class PopulateDataInDatabase {

	public static void main(String[] args) {
		populateReimburesementStatus_ReimbursementType_UserRole();
		addSampleUsers();
	}
	
	private static void populateReimburesementStatus_ReimbursementType_UserRole() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		UserRole admin = new UserRole("admin");
		UserRole user = new UserRole("user");
		session.persist(admin);
		session.persist(user);
		
		ReimbursementStatus pending = new ReimbursementStatus("pending");
		ReimbursementStatus approved = new ReimbursementStatus("approved");
		ReimbursementStatus denied = new ReimbursementStatus("denied");
		session.persist(pending);
		session.persist(approved);
		session.persist(denied);
		
		ReimbursementType travel = new ReimbursementType("travel");
		ReimbursementType business = new ReimbursementType("business");
		ReimbursementType medical = new ReimbursementType("medical");
		session.persist(travel);
		session.persist(business);
		session.persist(medical);
		
		tx.commit();
		session.close();
	}
	
	private static void addSampleUsers() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User adminUser1 = new User("username","password","david", "huynh", "david@revature.net");
		UserRole admin = (UserRole) session.createQuery("FROM UserRole ur WHERE ur.role = 'admin'").getSingleResult();
		adminUser1.setUserRole(admin);
		session.persist(adminUser1);
		
		UserRole user = (UserRole) session.createQuery("FROM UserRole ur WHERE ur.role = 'user'").getSingleResult();
		User regularUser1 = new User("username1","password","bob", "burgers", "david@revature.net");
		regularUser1.setUserRole(user);
		User regularUser2 = new User("username2","password","nick", "loy", "david@revature.net");
		regularUser2.setUserRole(user);
		
		session.persist(regularUser1);
		session.persist(regularUser2);
		
		tx.commit();
		session.close();
	}

}

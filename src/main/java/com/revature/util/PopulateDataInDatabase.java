package com.revature.util;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.Reimbursement;
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
		
		User adminUser1 = new User("username1","password","david", "huynh", "david@revature.net", "admin");
		UserRole admin = (UserRole) session.createQuery("FROM UserRole ur WHERE ur.role = 'admin'").getSingleResult();
		adminUser1.setUserRole(admin);
		session.persist(adminUser1);
		
		UserRole user = (UserRole) session.createQuery("FROM UserRole ur WHERE ur.role = 'user'").getSingleResult();
		User regularUser1 = new User("username2","password","Tony", "Stark", "TStark@SOI.net", "user");
		regularUser1.setUserRole(user);
		User regularUser2 = new User("username3","password","Bruce", "Banner", "BBanner@SOI.net", "user");
		regularUser2.setUserRole(user);
		
		session.persist(regularUser1);
		session.persist(regularUser2);
		
		tx.commit();
		session.close();
	}
	
	private static void addShips_user123() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		User test123 = (User) session.createQuery("FROM User u WHERE u.username = 'username1'").getSingleResult();
		ReimbursementStatus pending = (ReimbursementStatus) session.createQuery("FROM ReimbursementStatus s WHERE s.status = 'pending'").getSingleResult();
		
		ReimbursementType travel = (ReimbursementType) session.createQuery("FROM ReimburesementType s WHERE s.type = 'travel'").getSingleResult();
		ReimbursementType business = (ReimbursementType) session.createQuery("FROM ReimburesementType s WHERE s.type = 'business'").getSingleResult();
		ReimbursementType medical = (ReimbursementType) session.createQuery("FROM ReimbursementType s WHERE s.type = 'medical'").getSingleResult();
		
		Reimbursement reimbursement1 = new Reimbursement( 495.95, timestamp , "null", "Went to China for tea");
		reimbursement1.setReimbAuthor(test123);
		reimbursement1.setReimbStatus(pending);
		reimbursement1.setType(travel);
		
		Reimbursement reimbursement2 = new Reimbursement( 9985.95, timestamp , "null", "ordered dinner for meeting");
		reimbursement2.setReimbAuthor(test123);
		reimbursement2.setReimbStatus(pending);
		reimbursement2.setType(business);
		
		Reimbursement reimbursement3 = new Reimbursement(49005.95, timestamp , "null", "car accident");
		reimbursement3.setReimbAuthor(test123);
		reimbursement3.setReimbStatus(pending);
		reimbursement3.setType(medical);
		
		session.persist(reimbursement1);
		session.persist(reimbursement2);
		session.persist(reimbursement3);
		
		tx.commit();
		session.close();
	}
}

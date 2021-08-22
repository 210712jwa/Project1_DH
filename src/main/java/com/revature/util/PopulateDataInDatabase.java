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
		//SessionFactorySingleton.getSessionFactory();
		//populateReimburesementStatus_ReimbursementType_UserRole();
		//addSampleUsers();
		addReimbursements_user123();
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
		
		User adminUser1 = new User("username1","password","david", "huynh", "dhuynh@SOInet");
		UserRole admin = (UserRole) session.createQuery("FROM UserRole ur WHERE role = 'admin'").getSingleResult();
		adminUser1.setUserRole(admin);
		session.persist(adminUser1);
		
		UserRole user = (UserRole) session.createQuery("FROM UserRole ur WHERE role = 'user'").getSingleResult();
		User regularUser1 = new User("username2","password","Tony", "Stark", "TStark@SOI.net");
		regularUser1.setUserRole(user);
		
		User regularUser2 = new User("username3","password","Bruce", "Banner", "BBanner@SOI.net");
		regularUser2.setUserRole(user);
		
		session.persist(regularUser1);
		session.persist(regularUser2);
		
		tx.commit();
		session.close();
	}
	
	private static void addReimbursements_user123() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		User test = (User) session.createQuery("FROM User u WHERE username = 'username1'").getSingleResult();
		
		ReimbursementStatus pending = (ReimbursementStatus) session.createQuery("FROM ReimbursementStatus s WHERE s.reimbStatus = 'pending'").getSingleResult();
		 
		ReimbursementType travel = (ReimbursementType) session.createQuery("FROM ReimbursementType  s WHERE s.reimbType = 'travel'").getSingleResult();
		ReimbursementType business = (ReimbursementType) session.createQuery("FROM ReimbursementType s  WHERE s.reimbType = 'business'").getSingleResult();
		ReimbursementType medical = (ReimbursementType) session.createQuery("FROM ReimbursementType s   WHERE s.reimbType = 'medical'").getSingleResult();
		
		Reimbursement reimbursement1 = new Reimbursement(495.66, "time and date", "time and date", "diiner for meeting", 1);
		reimbursement1.setReimbAuthor(test);
		reimbursement1.setReimbStatus(pending);
		reimbursement1.setType(travel);
		
		Reimbursement reimbursement2 = new Reimbursement(495.66,"time and date", "time and date", "diiner for meeting", 1);
		reimbursement2.setReimbAuthor(test);
		reimbursement2.setReimbStatus(pending);
		reimbursement2.setReimbType(business);
		
		Reimbursement reimbursement3 = new Reimbursement(495.66, "time and date", "time and date", "diiner for meeting", 1);
		reimbursement3.setReimbAuthor(test);
		reimbursement3.setReimbStatus(pending);
		reimbursement3.setReimbType(medical);
		
		session.persist(reimbursement1);
		session.persist(reimbursement2);
		session.persist(reimbursement3);
		
		System.out.println(reimbursement1.getId());
		tx.commit();
		session.close();
	}
}
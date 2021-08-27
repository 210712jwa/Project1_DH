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
		populateReimburesementStatus_ReimbursementType_UserRole();
		addSampleUsers();
		addReimbursementsToUsers();
	}
	
	private static void populateReimburesementStatus_ReimbursementType_UserRole() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		UserRole financeManager = new UserRole("finance manager");
		UserRole employee = new UserRole("employee");
		session.persist(financeManager);
		session.persist(employee);
		
		ReimbursementStatus pending = new ReimbursementStatus("pending");
		ReimbursementStatus approved = new ReimbursementStatus("approved");
		ReimbursementStatus denied = new ReimbursementStatus("denied");
		session.persist(pending);
		session.persist(approved);
		session.persist(denied);
		
		ReimbursementType Lodging = new ReimbursementType("Lodging");
		ReimbursementType Travel = new ReimbursementType("Travel");
		ReimbursementType Food = new ReimbursementType("Food");
		ReimbursementType Other = new ReimbursementType("Other");
		session.persist(Lodging);
		session.persist(Travel);
		session.persist(Food);
		session.persist(Other);
		
		tx.commit();
		session.close();
	}
	
	private static void addSampleUsers() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User adminUser1 = new User("username1","password","david", "huynh", "dhuynh@SOInet");
		UserRole admin = (UserRole) session.createQuery("FROM UserRole ur WHERE ur.role = 'finance manager'").getSingleResult();
		adminUser1.setUserRole(admin);
		session.persist(adminUser1);
		
		UserRole user = (UserRole) session.createQuery("FROM UserRole ur WHERE role = 'employee'").getSingleResult();
		User regularUser1 = new User("username2","password","Tony", "Stark", "TStark@SOI.net");
		regularUser1.setUserRole(user);
		
		User regularUser2 = new User("username3","password","Bruce", "Banner", "BBanner@SOI.net");
		regularUser2.setUserRole(user);
		
		session.persist(regularUser1);
		session.persist(regularUser2);
		
		tx.commit();
		session.close();
		
	}
	
	private static void addReimbursementsToUsers() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		User test = (User) session.createQuery("FROM User u WHERE username = 'username1'").getSingleResult();
		
		ReimbursementStatus pending = (ReimbursementStatus) session.createQuery("FROM ReimbursementStatus s WHERE s.reimbStatus = 'pending'").getSingleResult();
		 
		//ReimbursementType travel = (ReimbursementType) session.createQuery("FROM ReimbursementType  s WHERE s.reimbType = 'travel'").getSingleResult();
		ReimbursementType Lodging = session.get(ReimbursementType.class, 1);
		ReimbursementType Travel = session.get(ReimbursementType.class, 2);
		ReimbursementType Food = session.get(ReimbursementType.class, 3);
		ReimbursementType Other = session.get(ReimbursementType.class, 4);
//		ReimbursementType business = (ReimbursementType) session.createQuery("FROM ReimbursementType s  WHERE s.reimbType = 'Lodging'").getSingleResult();
//		ReimbursementType medical = (ReimbursementType) session.createQuery("FROM ReimbursementType s   WHERE s.reimbType = 'medical'").getSingleResult();
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		
		Reimbursement reimbursement1 = new Reimbursement(495.66, time, time, "travel to china", 1);
		reimbursement1.setReimbAuthor(test);
		reimbursement1.setReimbStatus(pending);
		reimbursement1.setReimbType(Lodging);
		
		Reimbursement reimbursement2 = new Reimbursement(65.33,time, time, "diiner for meeting", 1);
		reimbursement2.setReimbAuthor(test);
		reimbursement2.setReimbStatus(pending);
		reimbursement2.setReimbType(Travel);
		
		Reimbursement reimbursement3 = new Reimbursement(5403.66, time, time, "slipped and fell", 1);
		reimbursement3.setReimbAuthor(test);
		reimbursement3.setReimbStatus(pending);
		reimbursement3.setReimbType(Other);
		
		session.persist(reimbursement1);
		session.persist(reimbursement2);
		session.persist(reimbursement3);
		
		tx.commit();
		session.close();
	}
}
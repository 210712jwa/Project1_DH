package com.revature.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.revature.model.Reimbursement;
import com.revature.util.SessionFactorySingleton;

public class ReimbursementDAO {
	public List<Reimbursement> getAllReimbursementsFromUserId(int id) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// Get reimbursements by owner id
		List<Reimbursement> reimbursements = session.createQuery("SELECT s FROM Reimbursement  JOIN s.author u WHERE u.id = id").setParameter("userId", id).getResultList();
	
		return reimbursements;
	}
}


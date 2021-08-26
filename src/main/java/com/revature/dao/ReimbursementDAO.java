package com.revature.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.dto.AddReimbursementDTO;
import com.revature.dto.EditReimbursementDTO;
import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.User;
import com.revature.util.SessionFactorySingleton;

public class ReimbursementDAO {
	public List<Reimbursement> getAllReimbursementsFromUserId(int id) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// Get reimbursements by owner id
		List<Reimbursement> reimbursements = session.createQuery("SELECT s FROM Reimbursement s JOIN s.reimbAuthor u WHERE u.id = :id").setParameter("id", id).getResultList();
	
		return reimbursements;
	}

	public Reimbursement addReimbursemntFormBelongingToSpecificUser(int id, AddReimbursementDTO reimbToAdd) {
		//Date date = new Date();
		Timestamp submitted = new Timestamp(System.currentTimeMillis());
		
		
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Reimbursement addReimbursement = new Reimbursement();
		
		
		addReimbursement.setReimbAmount(reimbToAdd.getAmount());
		addReimbursement.setReimbDiscription(reimbToAdd.getDiscription());
		addReimbursement.setReimbSubmitted(submitted);
		
		addReimbursement.setReimbAuthor(session.get(User.class, id));
		addReimbursement.setType(session.get(ReimbursementType.class, reimbToAdd.getType()));
		addReimbursement.setReimbStatus(session.get(ReimbursementStatus.class, 1));
		addReimbursement.setReimbResolver(null);
		addReimbursement.setReimbResolver(null);
		addReimbursement.setReimbRecipe(1);
		
		session.persist(addReimbursement);
		tx.commit();
		session.close();
		
		return addReimbursement;
		
	}

	public List<Reimbursement> getAllReimbursements() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// Get reimbursements by owner id
		List<Reimbursement> reimbursements = session.createQuery("SELECT s FROM Reimbursement s").getResultList();
	
		tx.commit();
		session.close();
		return reimbursements;
	}

	public Reimbursement editReimbursementForm(int userId, int reimbId, EditReimbursementDTO reimbursement) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Timestamp resolved = new Timestamp(System.currentTimeMillis());

		Reimbursement editReimbursement = session.get(Reimbursement.class, reimbId);

		editReimbursement.setReimbResolved(resolved);;
		editReimbursement.setReimbResolver(session.get(User.class, userId));
		editReimbursement.setReimbStatus(session.get(ReimbursementStatus.class, reimbursement.getStatus()));
		session.saveOrUpdate(editReimbursement);
		
		tx.commit();
		session.close();
		return editReimbursement;
	}
}


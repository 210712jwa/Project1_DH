package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dto.AddReimbursementDTO;
import com.revature.dto.EditReimbursementDTO;
import com.revature.exception.BadParameterException;
import com.revature.model.Reimbursement;

public class ReimbursementService {

	private ReimbursementDAO reimbursementDao;

	public ReimbursementService() {
		this.reimbursementDao = new ReimbursementDAO();
	}

	public List<Reimbursement> getAllReimbursementFromUserId(String userId) {
		int id = Integer.parseInt(userId);

		List<Reimbursement> reimbursements = reimbursementDao.getAllReimbursementsFromUserId(id);

		return reimbursements;
	}

	public Reimbursement addReimbursemntFormBelongingToSpecificUser( String userId, AddReimbursementDTO reimbToAdd) {

		int id = Integer.parseInt(userId);
		

		Reimbursement addedReimbursement = reimbursementDao.addReimbursemntFormBelongingToSpecificUser( id, reimbToAdd);

		return addedReimbursement;
	}

	public List<Reimbursement> getAllReimbursements() {
		
		List<Reimbursement> reimbursements = reimbursementDao.getAllReimbursements();
		
		return reimbursements;
	}

	public Reimbursement editReimbursemntForm(String stringUserId, String stringReimbId, EditReimbursementDTO reimbursementToEdit) {
		int userId = Integer.parseInt(stringUserId);
		int reimbId = Integer.parseInt(stringReimbId);
		
		Reimbursement editedReimbursement = reimbursementDao.editReimbursementForm(userId, reimbId, reimbursementToEdit);
		
		
		return editedReimbursement;
	}

}

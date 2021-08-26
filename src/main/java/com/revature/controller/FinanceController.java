package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dto.EditReimbursementDTO;
import com.revature.dto.MessageDTO;
import com.revature.model.Reimbursement;
import com.revature.service.AuthorizeService;
import com.revature.service.ReimbursementService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class FinanceController implements Controller {

	private ReimbursementService reimbursementService;
	
	private AuthorizeService authService;
	
	
	
	public FinanceController() {
		this.reimbursementService = new ReimbursementService();
		this.authService = new AuthorizeService();
	}

	private Handler getAllReimbursement = (ctx) -> {
		HttpSession session = ctx.req.getSession();
		
		authService.guard(ctx);

		List<Reimbursement> reimbursements = reimbursementService.getAllReimbursements();

				ctx.json(reimbursements);
				ctx.status(200);
	};
	
	private Handler editReimbursemntFromSpecificUser = (ctx) -> {
		HttpSession session = ctx.req.getSession();
		authService.guard(ctx);

		String userId = ctx.pathParam("userId");
		String reimbId = ctx.pathParam("reimbId");
		
		EditReimbursementDTO editedReimbursement = ctx.bodyAsClass(EditReimbursementDTO.class);
		Reimbursement reimbursements = reimbursementService.editReimbursemntForm(userId, reimbId, editedReimbursement );

				ctx.json(reimbursements);
				ctx.status(200);
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/reimbursement", getAllReimbursement);
		app.put("/user/:userId/reimbursement/:reimbId", editReimbursemntFromSpecificUser);


	}
}

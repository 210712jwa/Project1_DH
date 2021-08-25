package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

//import com.revature.dto.AddOrEditAccountDTO;
import com.revature.dto.AddReimbursementDTO;
import com.revature.dto.EditReimbursementDTO;
import com.revature.dto.MessageDTO;
import com.revature.model.User;
import com.revature.model.UserRole;
import com.revature.service.ReimbursementService;
import com.revature.model.Reimbursement;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbursementController implements Controller {

	private ReimbursementService reimbursementService;

	public ReimbursementController() {
		this.reimbursementService = new ReimbursementService();
	}

	private Handler getAllReimbursementsBelongingToSpecificUser = (ctx) -> {
		HttpSession session = ctx.req.getSession();

		if (session.getAttribute("currentUser") == null) {
			ctx.json(new MessageDTO("You need to be logged in to perform this action"));
		} else {
			User currentUser = (User) session.getAttribute("currentUser");

			String userId = ctx.pathParam("userId");

			if (currentUser.getId() == Integer.parseInt(userId)) {
				List<Reimbursement> reimbursements = reimbursementService.getAllReimbursementFromUserId(userId);

				ctx.json(reimbursements);
				ctx.status(200);
			} else {
				ctx.json(new MessageDTO("You are not the user that you want to retrieve all users from"));
				ctx.status(401);
			}
		}
	};

	private Handler addReimbursemntFormBelongingToSpecificUser = (ctx) -> {
		HttpSession session = ctx.req.getSession();

		if (session.getAttribute("currentUser") == null) {
			ctx.json(new MessageDTO("You need to be logged in to perform this action"));
		} else {
			User currentUser = (User) session.getAttribute("currentUser");

			String userId = ctx.pathParam("userId");

			if (currentUser.getId() == Integer.parseInt(userId)) {
			
				AddReimbursementDTO reimbToAdd = ctx.bodyAsClass(AddReimbursementDTO.class);
				Reimbursement reimbursements = reimbursementService.addReimbursemntFormBelongingToSpecificUser(userId, reimbToAdd);

				ctx.json(reimbursements);
				ctx.status(200);
			} else {
				ctx.json(new MessageDTO("You are not the user that you want to retrieve all users from"));
				ctx.status(401);
			}
		}
	};

	private Handler getAllReimbursement = (ctx) -> {
		HttpSession session = ctx.req.getSession();

//		if (session.getAttribute("currentUser") == null) {
//			ctx.json(new MessageDTO("You need to be logged in to perform this action"));
//		} else {
//			User currentUser = (User) session.getAttribute("currentUser");
//			UserRole userRole = currentUser.getUserRole();
//
//			String userId = ctx.pathParam("userId");
//
//			if (currentUser.getUserRole() == "admin") {
//				List<Reimbursement> reimbursements = reimbursementService.addReimbursemntFormBelongingToSpecificUser(userId);
//
//				ctx.json(reimbursements);
//				ctx.status(200);
//			} else {
//				ctx.json(new MessageDTO("You are not the user that you want to retrieve all users from"));
//				ctx.status(401);
//			}
//		}
	};

	private Handler editReimbursemntForm = (ctx) -> {
HttpSession session = ctx.req.getSession();
		
//		if (session.getAttribute("currentUser") == null) {
//			ctx.json(new MessageDTO("You need to be logged in to perform this action"));
//		} else {
//			User currentUser = (User) session.getAttribute("currentUser");
//			
//			String userId = ctx.pathParam("userId");
//			
//			if (currentUser.getId() == Integer.parseInt(userId)) {
//				List<Reimbursement> reimbursements = reimbursementService.addReimbursemntFormBelongingToSpecificUser(userId);
//				
//				ctx.json(reimbursements);
//				ctx.status(200);
//			} else {
//				ctx.json(new MessageDTO("You are not the user that you want to retrieve all users from"));
//				ctx.status(401);
//			}
//		}
	};

	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/reimbursement", getAllReimbursement);
		app.get("/user/:userId/reimbursement", getAllReimbursementsBelongingToSpecificUser);
		app.post("/user/:userId/reimbursement", addReimbursemntFormBelongingToSpecificUser);
		app.put("/user/:userId/reimbursement", editReimbursemntForm);

	}

}

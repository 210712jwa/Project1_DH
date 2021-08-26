package com.revature.service;

import javax.servlet.http.HttpSession;

import com.revature.exception.NotAuthorizedException;
import com.revature.model.User;

import io.javalin.http.Context;

public class AuthorizeService {

	public void guard(Context ctx) throws NotAuthorizedException {
		HttpSession session = ctx.req.getSession();
		
		User currentUser = (User) session.getAttribute("currentUser");
		
		if( currentUser.getUserRole().getId() != 1) {
			throw new NotAuthorizedException("You are not authorized to perform this action.");
		}
		
	}

	
}

package com.revature.app;

import com.revature.controller.Controller;
import com.revature.controller.ExceptionController;
import com.revature.controller.LoginController;

import io.javalin.Javalin;

public class Application {

	private static Javalin app;
	
	public static void main(String[] args) {
		app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins(); // could include ("http://localhost:7000")
		});
		
		mapControllers(new LoginController(), new ExceptionController());
		
		app.start(7000);
	}
	
	private static void mapControllers(Controller... controllers) {
		for (Controller c : controllers) {
			c.mapEndpoints(app);
		}
	}

}
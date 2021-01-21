package com.example;

import org.apache.log4j.*;

import com.example.controller.ReimbursementController;
import com.example.controller.UserController;
import com.example.dao.ERSDBConnection;
import com.example.dao.ReimbursementDao;
import com.example.dao.UserDao;
import com.example.service.ReimbursementService;
import com.example.service.UserService;

import io.javalin.Javalin;

public class MainDriver {
	public final static Logger log = Logger.getLogger(MainDriver.class);
	
	public static void main(String[] args) {
	
		
		UserController uCon = new UserController(new UserService(new UserDao(new ERSDBConnection())));
		ReimbursementController rCon = new ReimbursementController(new ReimbursementService(new ReimbursementDao(new ERSDBConnection())));
		Javalin app = Javalin.create(config->{
			config.addStaticFiles("/frontend");
			config.enableCorsForAllOrigins();
		});
		
		app.start(9012);
		app.post("/user/login", uCon.postLogin);
		app.post("/user/signup", uCon.postSignUp);
		app.post("/reimbursement/new",rCon.postReimbursement);
		app.get("/reimbursement/data", rCon.getData);
		app.get("/user/session", uCon.getSession);
		app.post("/user/logout", uCon.logOut);
		app.get("/manger/data", rCon.getManagerData);
		app.post("/remb/data", rCon.getIndividualReimb);
		app.post("/remb/update", rCon.updateReimb);
		app.exception(NullPointerException.class, (e,ctx)->{
			ctx.status(404);
		});
		
		
	}
	
	
	
	
}



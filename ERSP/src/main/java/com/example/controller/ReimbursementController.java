package com.example.controller;

import java.sql.Timestamp;

import com.example.MainDriver;
import com.example.model.User;
import com.example.service.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	private ReimbursementService rServ;
	
	public Handler postReimbursement =(ctx) ->{
		Timestamp created = new Timestamp(System.currentTimeMillis());
		User user = (User)ctx.sessionAttribute("user");
		MainDriver.log.info("User " + user.getUsername() + " just created a reimbursement!" );
		rServ.addReimbursement(Double.parseDouble(ctx.formParam("amount")), created, ctx.formParam("description"),"" + user.getUserId() , "1", ctx.formParam("type"));
		ctx.redirect("/html/employee.html");
	};
	
	public Handler getData = (ctx) ->{

		User user = (User)ctx.sessionAttribute("user");
		ctx.json(rServ.getAllReimbursements(user.getUserId()));
	};
	
	public Handler getManagerData = (ctx)->{
		ctx.json(rServ.getAllForManager());
	};
	
	public Handler getIndividualReimb = (ctx)->{
		int id = Integer.parseInt(ctx.formParam("value"));
		ctx.json(rServ.getReimbursementById(id));
		
	};
	
	public Handler updateReimb = (ctx) ->{
		int id = Integer.parseInt(ctx.formParam("id")); 
		int decision = Integer.parseInt(ctx.formParam("decision"));
		Timestamp resolved = new Timestamp(System.currentTimeMillis());
		User user = (User)ctx.sessionAttribute("user");
		rServ.updateReimbursement(id, resolved, user.getUserId(), decision);
		MainDriver.log.info("User " + user.getUsername() + " just resolved a Reimbursement" );
	};
	 
	
	
	
	public ReimbursementController() {
		// TODO Auto-generated constructor stub
	}

	public ReimbursementController(ReimbursementService rServ) {
		super();
		this.rServ = rServ;
	}
	
	
}

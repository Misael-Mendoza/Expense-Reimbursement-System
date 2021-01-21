package com.example.controller;

import com.example.MainDriver;
import com.example.model.User;
import com.example.service.UserService;

import io.javalin.http.Handler;


public class UserController {
	private UserService uServ;
	



	public Handler postLogin = (ctx)->{
		
		if(uServ.verifyUser(ctx.formParam("username"), ctx.formParam("password"))) {
			MainDriver.log.info("User " + ctx.formParam("username") + " just logged in!" );
			ctx.sessionAttribute("user",uServ.getUser(ctx.formParam("username")));
			if(uServ.getUser(ctx.formParam("username")).getRoleId() == 0 ) {
				ctx.redirect("/html/manager.html");
			} else {
				ctx.redirect("/html/employee.html");
			}
		}else {
			ctx.status(404);
			ctx.redirect("/html/notFound.html");
		}
	};
	
	
	public Handler postSignUp = (ctx)->{
		uServ.signUpUser(ctx.formParam("username"), ctx.formParam("password"), ctx.formParam("firstName"), ctx.formParam("lastName"), ctx.formParam("email"), ctx.formParam("role"));
		ctx.redirect("/html/index.html");
	};
	
	public Handler getSession = (ctx)->{
		User user = (User)ctx.sessionAttribute("user");
		if(user == null) {
			User user2 = new User(0," "," "," "," "," ",0);
			ctx.json(user2);
		}
		else {
			ctx.json(user);
		}
	};
	
	public Handler logOut = (ctx)->{
		ctx.redirect("/html/index.html");
		
		User user = (User)ctx.sessionAttribute("user");
		MainDriver.log.info("User " + user.getUsername() + " just logged in!" );
		ctx.sessionAttribute("user", null);
	};
	
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public UserController(UserService uServ) {
		super();
		this.uServ = uServ;
	}

}

package com.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReimbursmentFormPage {
	
	private WebDriver driver;
	private WebElement decision;
	private WebElement Accept;
	private WebElement GoBack;
	
	public ReimbursmentFormPage(WebDriver driver) {
		this.driver = driver;
		this.navigateTo();
		this.decision = driver.findElement(By.name("decision"));
		this.Accept = driver.findElement(By.id("approve"));
		this.GoBack = driver.findElement(By.name("gb"));
	}
	
	public void navigateTo(){
		this.driver.get("http://localhost:9012/html/Reimbursement.html");
	}
	
	public void setDecision(String previous) {
		Select s = new Select(this.decision);
		if (previous.equals("Aproved")) {
			s.selectByVisibleText("Denied");
		}else if(previous.equals("Denied")) {
			s.selectByVisibleText("Approve");
		}
	}
	
	public void Accept() {
		this.Accept.click();
	}
	
	public void GoBack() {
		this.GoBack.click();
	}

}

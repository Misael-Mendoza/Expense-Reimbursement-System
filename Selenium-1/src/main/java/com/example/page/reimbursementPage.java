package com.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class reimbursementPage {
	private WebDriver driver;
	private WebElement amountField;
	private WebElement descriptionField;
	private WebElement submitButton;
	
	
	public reimbursementPage(WebDriver driver) {
		this.driver = driver;
		this.navigateTo();
		this.amountField = driver.findElement(By.name("amount"));
		this.descriptionField = driver.findElement(By.name("description"));
		this.submitButton = driver.findElement(By.id("submit-btn"));
	}
	
	public void navigateTo() {
		this.driver.get("http://localhost:9012/html/newReimbursement.html");
	}
	
	public void submit() {
		this.submitButton.click();
	}
	
	public void setAmount(String amount) {
		 this.amountField.clear();
		 this.amountField.sendKeys(amount);
	}
	
	public void setDescription(String description) {
		this.descriptionField.clear();
		this.descriptionField.sendKeys(description);
	}
	
	
	
}

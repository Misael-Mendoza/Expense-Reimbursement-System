package com.example.page;

import java.nio.file.WatchEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class logginPage {
	private WebDriver driver;

	private WebElement usernameField;
	private WebElement passwordField;
	private WebElement submitButton;
	
	public logginPage(WebDriver driver){
		this.driver = driver;
		this.navigateTo();
		this.usernameField = driver.findElement(By.name("username"));
		this.passwordField = driver.findElement(By.name("password"));
		this.submitButton= driver.findElement(By.name("userSubmit"));
	}
	
	public void navigateTo(){
		this.driver.get("http://localhost:9012/html/index.html");
	}
	
	public void setUsername(String name) {
		this.usernameField.clear();
		this.usernameField.sendKeys(name);
	}
	
	public String getUsername() {
		return this.usernameField.getAttribute("value");
	}
	
	public void setPassword(String password) {
		this.passwordField.clear();
		this.passwordField.sendKeys(password);
	}
	
	public String getPassword() {
		return this.passwordField.getAttribute("value");
	}
	
	public void submit() {
		this.submitButton.click();
	}

}

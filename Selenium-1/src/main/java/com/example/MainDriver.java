package com.example;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.page.employeePage;
import com.example.page.logginPage;

public class MainDriver {

	public static void main(String[] args) {
		
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		
		WebDriver driver = new ChromeDriver();
		
		
		//logginPage page = new logginPage(driver);
		//employeePage pageE = new employeePage(driver);
		//page.navigateTo();
		//pageE.navigateTo();
	}

}

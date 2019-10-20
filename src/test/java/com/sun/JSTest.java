package com.sun;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSTest {
	WebDriver driver;
	@BeforeTest
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "F:\\javaworkspace\\Seleniumtest\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void exJS() throws InterruptedException{
		driver.get("http://www.baidu.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('kw').setAttribute('value','webdriver');");
		Thread.sleep(5000);
		}
	
	
	
	@AfterMethod
	public void closed(){
		driver.close();
	}
	
}

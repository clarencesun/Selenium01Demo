package com.sun.alertTest;

import org.apache.http.message.HeaderValueFormatter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;

public class AlertTest01 {
	WebDriver driver;
	
	
	@BeforeTest
	public void open(){
		System.setProperty("webdriver.chrome.driver", "F:\\javaworkspace\\Seleniumtest\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	//Alert弹框处理
	@Test
	public void alertTest() throws InterruptedException{
		driver.get("http://www.baidu.com");
		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	//confim弹框处理
	@Test
	public void confimTest() throws InterruptedException{
		driver.get("http://www.baidu.com");
		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
//		alert.dismiss();
	}
	
	//Prompt
	@Test
	public void prompTest() throws InterruptedException{
		driver.get("http://www.baidu.com");
		driver.findElement(By.xpath("")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("请输入...");
		Thread.sleep(3000);
		prompt.accept();
//		prompt.dismiss();
		
	}
	
	@Test
	public void selectTest() throws InterruptedException{
		WebElement element =driver.findElement(By.name("Select"));
		Select select = new Select(element);
		select.selectByIndex(1);
		select.selectByValue("");
		select.selectByVisibleText("");
		
	}
	
	@Test
	public void winTest() throws InterruptedException{
		driver.findElement(By.xpath(""));
		String handle = driver.getWindowHandle();
		for (String handles:driver.getWindowHandles()) {
			if (handles.equals(handle)){ 
				continue;}
			driver.switchTo().window(handles);
			
		}
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(handle);
		Thread.sleep(3000);
		
	}
}

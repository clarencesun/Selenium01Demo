package OpenBrowerTest;


import java.util.List;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.po.page.LoginPage;

public class NewTest {
  @Test
  public void openFF() {
	  System.setProperty("webdriver.firefox.bin", "E:\\火狐\\firefox.exe");
	  WebDriver webdriver = new FirefoxDriver();
	  webdriver.close();
	  
  }
  @Test
  public void openChrome() {
	  System.setProperty("webdriver.chrome.driver", "F:\\javaworkspace\\Seleniumtest\\drivers\\chromedriver.exe");
	  WebDriver webdriver = new ChromeDriver();
	  webdriver.quit();
  }
  @Test
  public void openIE() {
	  System.setProperty("webdriver.ie.driver", "F:\\javaworkspace\\Seleniumtest\\drivers\\IEDriverServer.exe");
	  WebDriver webdriver = new InternetExplorerDriver();
	  webdriver.close();
  }
  @Test
  public void getbaidu() throws InterruptedException{
	  System.setProperty("webdriver.firefox.bin", "E:\\火狐\\firefox.exe");
	  WebDriver driver = new FirefoxDriver();
	  driver.get("https://www.baidu.com");
	  Thread.sleep(2000);
	  driver.quit();
  }
  
  @Test
  public void backff() throws InterruptedException{
	  System.setProperty("webdriver.firefox.bin", "E:\\火狐\\firefox.exe");
	  WebDriver driver = new FirefoxDriver();
	  //System.setProperty("phantomjs.binary.path", "F:\\javaworkspace\\Seleniumtest\\drivers\\phantomjs.exe");
	  //WebDriver driver = new PhantomJSDriver();
	  
	  driver.get("https://www.baidu.com");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  driver.findElement(By.id("kw")).sendKeys("aa");
	  driver.findElement(By.id("su")).click();
	  Thread.sleep(3000);
	  driver.navigate().back();
	  Thread.sleep(3000);
	  driver.navigate().forward();
	  Thread.sleep(3000);
	  driver.navigate().refresh();
	  Thread.sleep(3000);
	  String str = driver.getCurrentUrl();
	  System.out.println(str);
	  driver.quit();
  }
  
  
  public static void loginPo(WebDriver driver,String email,String password){
	  WebElement elem = driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
	  driver.switchTo().frame(elem);
	  driver.findElement(LoginPage.emailInput).sendKeys(email);
	  driver.findElement(LoginPage.pwdInput).sendKeys(email);
	  driver.findElement(LoginPage.loginButten).click();
  }
  

  
  @Test
  public void login() throws InterruptedException{
	  System.setProperty("webdriver.chrome.driver", "F:\\javaworkspace\\Seleniumtest\\drivers\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://mail.163.com/");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[contains(@id,'switchAccountLogin')]")).click();
	  //driver.findElement(By.xpath("//*[@id='switchAccountLogin']")).click();
	  loginPo(driver, "15705101092", "szc15150035874");
	  Thread.sleep(5000);
  }
  @Test
  public void getTextTest(){
	  System.setProperty("webdriver.chrome.driver", "F:\\javaworkspace\\Seleniumtest\\drivers\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.baidu.com");
	  List<WebElement> list = driver.findElements(By.xpath("//*[@id='u1']/a"));
	  //System.out.println(list);
	  for(int i = 0;i < list.size();i++){
		  String text = list.get(i).getText();
		  System.out.println(text);
		  
	  }  
  }
  
  @Test
  public void isDISplayedTest(){
	  System.setProperty("webdriver.chrome.driver", "F:\\javaworkspace\\Seleniumtest\\drivers\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.baidu.com");
	  Boolean bool = driver.findElement(By.xpath("//*[@id='su']")).isDisplayed();
	  Assert.assertTrue(bool,"校验按钮");
  }
  
  @Test
  public void screenShotFile(){
	  System.setProperty("webdriver.chrome.driver", "F:\\javaworkspace\\Seleniumtest\\drivers\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.baidu.com");
	  File screenShotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(screenShotFile,new File("F:\\javaworkspace\\Seleniumtest\\test.png"));
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  
  }
  

  
  
  
}

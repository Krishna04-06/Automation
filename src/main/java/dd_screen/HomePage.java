package dd_screen;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import dd_core.AppDriver;

public class HomePage extends AppDriver{
	
	public void clickOnLoginsignUp() throws Exception {
		log.info("Click on Login page Signup");
	driver.findElement(By.xpath(Obj.getProperty("close_popup"))).click();
	Actions action= new Actions(driver);
	log.info("Click on Login");
	action.moveToElement(driver.findElement(By.xpath(Obj.getProperty("login_page")))).build().perform();
	Thread.sleep(4000);
	log.info("Click on SignUp");
	driver.findElement(By.xpath(Obj.getProperty("login_signup"))).click();
	Thread.sleep(4000);
	log.info("Enter Mobile No. to SignUp");
	driver.findElement(By.xpath(Obj.getProperty("login_mobile"))).sendKeys("8376900247");	 
	log.info("Click on Continue");
	driver.findElement(By.xpath(Obj.getProperty("continue_btn"))).click();
Thread.sleep(400);

String a = driver.findElement(By.xpath(Obj.getProperty("login_popup"))).getText();
System.out.println(a);
/*
 * Alert alert = driver.switchTo().alert(); String a = alert.getText();
 * System.out.println(a); log.info(alert);
 */
	
	/* System.out.println(alert); */
Thread.sleep(400);
	log.info("fill password");
	driver.findElement(By.xpath(Obj.getProperty("login_password"))).sendKeys("12348404");
	Thread.sleep(4000);
	log.info("Click on Login");
	driver.findElement(By.xpath(Obj.getProperty("login_btn"))).click();
	Thread.sleep(4000);
	String user = driver.findElement(By.xpath("(//div[@class='_2aUbKa'])[1]")).getText();
log.info("checking user name");

	Assert.assertEquals(user, "sachin singh");
	}
}

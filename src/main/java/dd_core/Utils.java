package dd_core;


import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils extends AppDriver{
	
public WebElement get_WebElement_Object(String locator, String locator_type) {
		
		WebElement Object= null;
		if(locator_type.equals("xpath")) {
			Object= fluentWaitForWebelements(By.xpath(locator));
		}
		else if(locator_type.equals("name")) {
			Object= fluentWaitForWebelements(By.name(locator));
		}
		else if(locator_type.equals("id")) {
			Object= fluentWaitForWebelements(By.id(locator));
		}
		else if(locator_type.equals("linkText")) {
			Object= fluentWaitForWebelements(By.linkText(locator));
		}
		else if(locator_type.equals("partialLinkText")) {
			Object= fluentWaitForWebelements(By.partialLinkText(locator));
		}
		else if(locator_type.equals("className")) {
			Object= fluentWaitForWebelements(By.className(locator));
		}
		else if(locator_type.equals("cssSelector")) {
			Object= fluentWaitForWebelements(By.cssSelector(locator));
		}
		else if(locator_type.equals("tagName")) {
			Object= fluentWaitForWebelements(By.tagName(locator));
		}
		return Object;
		
	}
public WebElement fluentWaitForWebelements(final By locator) {
	final Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	.withTimeout(Duration.ofSeconds(20))    
    .pollingEvery(Duration.ofMillis(200))   
    .ignoring(NoSuchElementException.class);

			WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
			try {
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return driver.findElement(locator);
			}
			});
			return foo;
}

	public WebElement WebDriverWaitforElements(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void scrollIntoView(By locator) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver);
	}
	public void clickOnAnyElement(String locator, String locator_type, String click_type) {
		WebElement Object=null;
		Object=get_WebElement_Object(locator, locator_type);
		if(click_type.equalsIgnoreCase("Click")){
			Object.click();
		}
		else if(click_type.equalsIgnoreCase("javascript")) {
				JavascriptExecutor executor= (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", Object);
		}
		else if(click_type.equalsIgnoreCase("keys")) {
			Object.sendKeys(Keys.CONTROL);
			Object.sendKeys(Keys.ENTER);			
		}
	}
	public void send_to_textBox(String locator, String locator_type, String textToSend) {
		WebElement Object=null;
		Object=get_WebElement_Object(locator, locator_type);
		Object.clear();
		Object.sendKeys(textToSend);
	}
	public void singleDropDownSelect(String locator, String locator_type, String textToSelect, String Select_type) {
		WebElement Object=null;
		Select select=null;
		Object=get_WebElement_Object(locator, locator_type);
		if(Object==null) {
			select=new Select(Object);
		}
		else if(Select_type.equalsIgnoreCase("value")) {
			select.selectByValue(textToSelect);
		}else if(Select_type.equalsIgnoreCase("text")) {
			select.selectByVisibleText(textToSelect);
		}else if(Select_type.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(textToSelect));
		}
	}
}

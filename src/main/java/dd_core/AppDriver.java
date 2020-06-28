package dd_core;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;

public class AppDriver {
	
	public static WebDriver driver=null;
	public static Properties Config=new Properties();
	public static Properties Obj=new Properties();
	public static Logger log= Logger.getLogger("devpinoyLogger");
	
	@BeforeMethod
	public void launchApp() throws Exception
	{
		FileInputStream fis_Config= new FileInputStream("D:\\testing\\snc\\src\\main\\java\\dd_properties\\Config.properties");
		Config.load(fis_Config);
		FileInputStream fis_Object= new FileInputStream("D:\\testing\\snc\\src\\main\\java\\dd_properties\\Object.properties");
		Obj.load(fis_Object);
		
		String driverPath= Config.getProperty("driverPath");
		
		if(Config.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver= new ChromeDriver();
			log.info("Chrome lunch successfully");
		}
		
		else if(Config.getProperty("browser").equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "driverpath_IE");
			driver= new InternetExplorerDriver();
			log.info("IE lunch successfully");
		}
		
		else if(Config.getProperty("browser").equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", driverPath+"MicrosoftWebDriver.exe");
			driver= new InternetExplorerDriver();
			log.info("IE lunch successfully");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
	}
	public void closeUrl() {
		driver.close();
	}

}

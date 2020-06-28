package dd_core;

import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	
   
    	public static WebDriver driver=null;
    	public static Properties Config=new Properties();
    	public static Properties Obj=new Properties();
    	public static Logger log= Logger.getLogger("devpinoyLogger");
    	
    	public static void main( String[] args ) throws Exception
    	{
    		FileInputStream fis_Config= new FileInputStream("D:\\testing\\snc\\src\\main\\java\\dd_properties\\Config.properties");
    		Config.load(fis_Config);
    		FileInputStream fis_Object= new FileInputStream("D:\\testing\\snc\\src\\main\\java\\dd_properties\\Object.properties");
    		Obj.load(fis_Object);
    		String driverPath= Config.getProperty("driverPath");
    		System.out.println(driverPath+"MicrosoftWebDriver.exe");

    
    }
    	
    	    }

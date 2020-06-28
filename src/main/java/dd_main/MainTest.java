package dd_main;

import org.testng.annotations.Test;

import dd_core.AppDriver;
import dd_screen.HomePage;

public class MainTest extends AppDriver {
	HomePage home;
	public MainTest() {
		
		super();
		 home= new HomePage();
	}
	
	
	@Test
	public void homeSignup() throws Exception 
	{
		
		home.clickOnLoginsignUp();
	}

}

package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class LoginTest extends Base{

	public WebDriver driver;
	
	@BeforeTest
	public void initialize() {
		this.driver=driver;
	}
	
	@Test
	public void loginTest() {
		driver.get(prop.getProperty("url"));
	}
	
	
	@AfterTest
	public void tearDown() {
		
	}
}

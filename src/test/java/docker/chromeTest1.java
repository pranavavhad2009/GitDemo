package docker;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class chromeTest1 {
	


@Test
public void test1() throws MalformedURLException
{
	DesiredCapabilities capability = new DesiredCapabilities();
	
	//cap.setCapability("chrome.driver","78.0");
	ChromeOptions options = new ChromeOptions();
	//capability.setBrowserName("chrome");
	options.addArguments("--disable-dev-shm-usage");
	capability.setPlatform(org.openqa.selenium.Platform.ANY);
	capability.setCapability(ChromeOptions.CAPABILITY, options);
	
			
	URL u = new URL("http://localhost:4444/wd/hub");
	RemoteWebDriver driver = new RemoteWebDriver(u, capability);
	
	driver.get("http://google.com");
	System.out.println(driver.getTitle());
	driver.close();
	driver.quit();
		
	}

}

package docker;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firefoxTest3 {
	


@Test
public void test3() throws MalformedURLException
{
	DesiredCapabilities capability = new DesiredCapabilities();
	FirefoxOptions options = new FirefoxOptions();
	//options.addArguments("--disable-dev-shm-usage");

	//capability.setBrowserName("chrome");
	capability.setPlatform(org.openqa.selenium.Platform.ANY);
	capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
	URL url = new URL("http://localhost:4444/wd/hub");
	RemoteWebDriver driver = new RemoteWebDriver(url, capability);
	
	driver.get("http://yahoo.com");
	System.out.println(driver.getTitle());
	driver.close();
	driver.quit();
		
	}

}

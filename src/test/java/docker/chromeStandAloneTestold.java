package docker;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class chromeStandAloneTestold {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		//DesiredCapabilities cap = DesiredCapabilities.chrome();
		DesiredCapabilities capability = new DesiredCapabilities();
		//cap.setCapability("browserName", "chrome");
		//cap.setCapability("chrome.driver","78.0");
		ChromeOptions options = new ChromeOptions();
			
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		//options.addArguments("--disable-dev-shm-usage");		
		//cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		capability.setBrowserName("chrome");
		capability.setPlatform(org.openqa.selenium.Platform.ANY);
		capability.setCapability(ChromeOptions.CAPABILITY, options);
		
		//URL u = new URL("http://localhost:4444/wd/hub");
		URL u = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(u, capability);
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle());

	}

}

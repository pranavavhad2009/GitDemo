package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class chromeStandAloneTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		//DesiredCapabilities cap=DesiredCapabilities.chrome();
		DesiredCapabilities capability = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-dev-shm-usage");
		//options.addArguments("--headless");
		//options.addArguments("--disable-gpu");
		capability.setBrowserName("chrome");
		capability.setPlatform(org.openqa.selenium.Platform.ANY);
		capability.setCapability(ChromeOptions.CAPABILITY, options);
		
		
		URL u=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver=new RemoteWebDriver(u,capability);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.close();
		driver.quit();
		
	}

}

package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		WebDriver driver;
		// Firefox
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
		 * driver=new FirefoxDriver(); driver.get("https://frontend.nopcommerce.com/");
		 */
		// Edge
		/*
		 * System.setProperty("webdriver.edge.driver",
		 * System.getProperty("user.dir")+"//BrowserDriver//msedgedriver.exe");
		 * driver=new EdgeDriver(); driver.get("https://frontend.nopcommerce.com/");
		 */

		//If we use WebDriverManager then no need to setup below
		//Automatic Selenium WebDriver binaries management in runtime for Java
		  //System.setProperty("webdriver.chrome.driver",
		  //System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
		  
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver(); driver.get("https://frontend.nopcommerce.com/");

		driver.close();
		driver.quit();

	}

}

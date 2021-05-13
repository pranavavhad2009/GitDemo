package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//config.properties");
		prop.load(fis);
		
		String browser=prop.getProperty("browser");
				
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}else if(browser.equalsIgnoreCase("ie")) {
			
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void main(String[] args) throws IOException {
		new Base().
		initializeDriver();
	}
	
	public String getScreenshotPath(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot capture=(TakesScreenshot)driver;
		File source=capture.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}

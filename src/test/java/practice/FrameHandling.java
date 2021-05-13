package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class FrameHandling {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver;
		String driverPath=System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe";
		System.out.println(driverPath);
		System.setProperty("webdriver.chrome.driver",driverPath );
		driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement frameElement=driver.findElement(By.id("courses-iframe"));
		
		//switch to frame
		driver.switchTo().frame(frameElement);
		
		WebElement element;
		//element=driver.findElement(By.cssSelector(".btn btn-theme btn-sm btn-min-block"));
		element=driver.findElement(By.cssSelector("a[class='btn btn-theme btn-sm btn-min-block']"));
		String text=element.getText();
		System.out.println("join button text:"+text);
		
		//Switching back to default content
		driver.switchTo().defaultContent();
		driver.findElement(By.id("alertbtn")).click();
		
		
		Alert alert=driver.switchTo().alert();
		System.out.println("alert text:"+alert.getText());;
		alert.accept();
		
		
		//Drop down
		String locator="dropdown-class-example";
		//using xpath
		locator="//div[@class='cen-right-align']/fieldset/select[@id='dropdown-class-example']";
		WebElement dropdown=driver.findElement(By.xpath(locator));
		Select select	=new Select(dropdown);
		List<WebElement> options=select.getOptions();
		
		for(WebElement option:options) {
			System.out.println("Option:"+option.getText());
			if(option.getText().equals("Option2"))
				select.selectByVisibleText("Option2");
		}
		
		
		driver.findElement(By.id("opentab")).click();
		
		Set<String> windows=driver.getWindowHandles();
		String parentWindow="";
		String child="";
		Iterator itr=windows.iterator();
		while(itr.hasNext()) {
			
			parentWindow=(String)itr.next();
			child=(String)itr.next();
		}
		driver.switchTo().window(child);
		String header_text=driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/div/div/div/div/h2/span")).getText();
		
		
		

		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("name")).sendKeys(header_text);
		
		
		

		
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
	}

}

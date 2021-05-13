package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Links {

	public static void main(String[] args) {

		WebDriver driver;
		String driverPath = System.getProperty("user.dir") + "//BrowserDriver//chromedriver.exe";
		System.out.println(driverPath);
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// Get all links on child page 
		//Using classsname-NOT WORKING
		//WebElement footer=driver.findElement(By.cssSelector("div[class='footer_top_agile_w3ls gffoot footer_style']"));
		//Using id in CSSSELECTOR-Workd
		//WebElement footer=driver.findElement(By.cssSelector("#gf-BIG"));
		
		WebElement footer=driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		List<WebElement> links =footer.findElements(By.tagName("a"));
		
		//List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("size:" + links.size());
		int responseCode=0;
		HttpURLConnection con=null;
		SoftAssert softAssert = new SoftAssert();
		for (WebElement link : links) {
			String url = link.getAttribute("href");

			
			try {
				con = (HttpURLConnection) (new URL(url).openConnection());
				con.setRequestMethod("HEAD");
				con.connect();
			} catch (Exception e) {
		        System.out.println("EXCEPTION:"+e.getMessage());
		    }
			try {

				responseCode = con.getResponseCode();

				if (responseCode >= 400) {
					System.out.println(url + " is a broken link");
					softAssert.assertTrue(responseCode<400, "The Link Text:"+url);
				} else {
					System.out.println(url + " is a valid link");
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}

		}

		 softAssert.assertAll();

	}

}

package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUsingSendKeys {
	

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		WebElement element=driver.findElement(By.id("uploadfile_0"));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		//Use Sendkey when type=file in html 
		element.sendKeys("E:\\Test.rtf");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		//element.click();
		//driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]")).sendKeys("E:\\Test.rtf");
		List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"res\"]/center"));
		System.out.println("size:"+list.size());
		System.out.println("text:"+list.get(0).getAccessibleName());
		
		
		driver.close();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		WebElement element1=driver.findElement(By.id("//*[@id=\"fileupload\"]/div/div[1]/span[1]"));
		
		element1.click();
		
		
		//Using Robot class
		
		
		

	}

}

package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUsingWindowPopup {

	public static void main(String[] args) throws AWTException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		//String path="//*[@id='fileupload']/div/div[1]/span[1]";
		String path="//*[@id='fileupload']/div/div[1]/span";//
		//WebElement element = driver.findElement(By.xpath(path));
		path="span[class='btn btn-success fileinput-button']";
		WebElement element = driver.findElement(By.cssSelector(path));

		wait.until(ExpectedConditions.visibilityOf(element));

		element.click();
		
		// Using Robot class
		Robot robot=new Robot();
		robot.delay(2000);
		StringSelection ss=new StringSelection("E:\\Test.html");
		//similar to ctrl+c   put file path in clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}

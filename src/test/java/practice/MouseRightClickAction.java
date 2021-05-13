package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseRightClickAction {

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement element=driver.findElement(By.xpath("//*[@id=\"mousehover\"]"));
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
		List<WebElement> submenu=driver.findElements(By.cssSelector("div.mouse-hover-content"));
		System.out.println("PRANAV:"+submenu.get(0).getText());
		//action.click(submenu.get(0));

	}

}

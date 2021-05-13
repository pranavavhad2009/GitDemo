package practice;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {

	public static void main(String[] args) {
		WebDriver driver;
		String location = System.getProperty("user.dir") + "\\downloads\\";
		
		HashMap<String, String> preferences = new HashMap<>();
		preferences.put("download.default_directory", location);

		ChromeOptions options = new ChromeOptions();
		// EdgeOptions options=new EdgeOptions();

		// Firefox
		/*
		 * FirefoxProfile profile=new FirefoxProfile();
		 * profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		 * "application/msword"); //MIME Type site
		 * profile.setPreference("browser.download.folderList", 2); //0-desktop,
		 * 1-download,2-desired location profile.setPreference("browser.download.dir",
		 * location); FirefoxOptions options1=new FirefoxOptions();
		 * options1.setProfile(profile); driver=new FirefoxDriver(options1);
		 */

		options.setExperimentalOption("prefs", preferences);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[1]/td[5]/a[1]")).click();
		// driver.close();
		// driver.quit();
	}

}

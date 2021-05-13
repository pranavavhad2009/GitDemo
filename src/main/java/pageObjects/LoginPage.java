package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email=By.id("");
	public By getEmail() {
		return email;
	}
	public void setEmail(By email) {
		this.email = email;
	}
	public By getPassword() {
		return password;
	}
	public void setPassword(By password) {
		this.password = password;
	}
	public By getLogin() {
		return login;
	}
	public void setLogin(By login) {
		this.login = login;
	}

	By password=By.id("");
	By login=By.id("");
	
}

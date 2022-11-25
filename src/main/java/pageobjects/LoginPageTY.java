package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Base;

public class LoginPageTY extends Base {

	private WebDriver driver;
	private By email = By.id("login-email");
	private By password = By.id("login-password-input");
	private By loginBtn = By.cssSelector("#login-register > div.lr-container > div.q-layout.login > form > button");

	public LoginPageTY(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginWith(String a, String b) {
		waitFunctionClickable(email);
		sendKey(email, a);
		waitFunctionClickable(password);
		sendKey(password, b);
		waitFunctionClickable(loginBtn);
		clickButton(loginBtn);
	}

}
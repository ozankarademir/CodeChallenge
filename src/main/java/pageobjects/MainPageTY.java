package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utils.Base;

public class MainPageTY extends Base {

	private WebDriver driver;
	private String pageTitle = "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
	public By logIn = By.xpath("//p[contains(text(),'Giriş Yap')]");
	public By modalPopUpClose = By.cssSelector("#gender-popup-modal > div > div > div.modal-close");
	public By logInBtn = By.xpath("//div[contains(text(),'Giriş Yap')]");
	public By myAccountBtn = By.xpath("//p[contains(text(),'Hesabım')]");
	public By logOutBtn = By.xpath("//p[contains(text(),'Çıkış Yap')]");
	public By usrInfoBtn = By.xpath("//p[contains(text(),'Kullanıcı Bilgilerim')]");

	public MainPageTY(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void verifyMainPageisOpen() {
		Assert.assertEquals(pageTitle, getTitle());
	}

	public WebElement myAccount() {
		return driver.findElement(myAccountBtn);
	}

	public WebElement logOut() {
		return driver.findElement(logOutBtn);
	}

	
	public WebElement userInfo() {
		return driver.findElement(usrInfoBtn);
	}
	
	public void goUserInfoPage() {
		waitFunctionClickable(myAccountBtn);
		mouseOver(myAccountBtn);
		waitFunctionClickable(usrInfoBtn);
		clickButton(usrInfoBtn);
	}

	public void goLoginPage() {
		mouseOver(logIn);
		waitFunctionClickable(logInBtn);
		clickButton(logInBtn);
	}

	public void closeModalPopUp() {
		waitFunctionClickable(modalPopUpClose);
		clickButton(modalPopUpClose);
	}
	
	public boolean verifyLogin() {
		waitFunctionVisible(myAccountBtn);
		Actions actions = new Actions(driver);
		actions.moveToElement(myAccount()).build().perform();
		waitFunctionVisible(logOutBtn);
		if (logOut().isDisplayed())
			return true;
		return false;
	}
}
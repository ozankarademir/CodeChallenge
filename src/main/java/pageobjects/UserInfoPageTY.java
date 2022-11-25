package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.Base;

public class UserInfoPageTY extends Base {

	private WebDriver driver;
	private String pageTitle = "Kullanıcı Bilgilerim - Trendyol";

	public By birthDayDropDown = By.xpath("//body/div[@id='container']/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div");
	public By birthDayBtn = By.xpath("//body/div[@id='container']/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]");
	public By birthMonthDropDown = By.xpath("//body/div[@id='container']/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div");
	public By birthMonthBtn = By.xpath("//body/div[@id='container']/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]");
	public By birthYearDropDown = By.xpath("//body/div[@id='container']/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div");
	public By birthYearBtn = By.xpath("//body/div[@id='container']/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[3]/div[1]/div[1]");
	public By birthDateUpdateBtn = By.xpath("//body/div[@id='container']/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]");									 
	public By successUpdateMsg = By.xpath("//span[contains(text(),'Güncelleme Başarılı!')]");
	
	public UserInfoPageTY(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void verifyUserInfoPageIsOpen() {
		Assert.assertEquals(pageTitle, getTitle());
	}

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)");
	}

	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-1000)");
	}

	public void selectBirthDay(int birthDay) {
		waitFunctionClickable(birthDayBtn);
		clickButton(birthDayBtn);
		List<WebElement> days = driver.findElements(birthDayDropDown);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.querySelector('.ty-display-flex:nth-child(4) > .ty-display-flex:nth-child(1) .ty-display-flex > .ty-display-flex').scrollBy(0,800)");
		days.get(birthDay).click();
	}

	public void selectBirthMonth(int birthMonth) {
		waitFunctionClickable(birthMonthBtn);
		clickButton(birthMonthBtn);
		List<WebElement> months = driver.findElements(birthMonthDropDown);
		months.get(birthMonth).click();
	}

	public void selectBirthYear(int birthYear) {
		waitFunctionClickable(birthYearBtn);
		clickButton(birthYearBtn);
		List<WebElement> years = driver.findElements(birthYearDropDown);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.querySelector('.ty-display-flex:nth-child(3) > div > .ty-display-flex > .ty-display-flex').scrollBy(0,600)");
		years.get(birthYear).click();
		clickButton(birthYearBtn);
	}

	public void birthDateUpdate() {
		waitFunctionClickable(birthDateUpdateBtn);
		clickButton(birthDateUpdateBtn);
	}

	public WebElement updateSuccessMsg() {
		waitFunctionVisible(successUpdateMsg);
		return driver.findElement(successUpdateMsg);
	}

}
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utils.Base;

public class MainPageHB extends Base {

	private WebDriver driver;
	private String pageTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
	private By search = By.cssSelector("[class*='desktopOldAutosuggestTheme'] [placeholder*='Ürün,']");
	private By searchBtn = By.xpath("//div[contains(text(),'ARA')]");

	public MainPageHB(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyHomePageisOpen() {
		Assert.assertEquals(pageTitle, getTitle());
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)");
	}
	
	public WebElement searchProduct() {
		return driver.findElement(search);
	}

	public WebElement searchButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(searchBtn)).build().perform();
		return driver.findElement(searchBtn);
	}

}

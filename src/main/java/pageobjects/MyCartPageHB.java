package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.Base;

public class MyCartPageHB extends Base {

	private WebDriver driver;
	private String pageTitle = "Sepetim";
	private By increaseProductBtn = By.cssSelector("[class='product_increase_3SpEx']");	
	private By productQuantity = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/section[1]/div[3]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/input[1]");
	private By mainPageBtn = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
	
	public MyCartPageHB(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void verifyMyCardPageisOpen() {
		Assert.assertEquals(pageTitle, getTitle());
	}

	public void increaseProduct() {
		clickButton(increaseProductBtn);
	}

	public boolean verifyQuantity(String a) {
		waitFunctionClickable(increaseProductBtn);
		WebElement el = driver.findElement(productQuantity);
		String quantity = el.getAttribute("value");
		// System.out.println(quantity);
		if (quantity == a)
			return false;
		else
			return true;
	}

	public void goMainPage() {
		clickButton(mainPageBtn);
	}

}
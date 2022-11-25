package pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utils.Base;

public class ProductPageHB extends Base {

	private WebDriver driver;
	private String productListPageTitle = "Apple Laptop - Hepsiburada";
	private By productName = By.cssSelector("[data-test-id='product-card-name']");
	private By goCart = By.id("shoppingCart");
	private By productOnCart = By.cssSelector(".product_name_3Lh3t a");
	public By productListContent = By.className("productListContent-tEA_8hfkPU5pDSjuFdKG");
	public By productArea = By.cssSelector("[data-test-id='product-card-image-container']");
	public By addToCartBtn = By.cssSelector("[data-test-id='product-info-button']");

	
	ArrayList<String> productNameList = new ArrayList<String>();

	public ProductPageHB(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyProductListPageisOpen() {
		Assert.assertEquals(productListPageTitle, getTitle());
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)");
	}
	
	public void goCart() {
		clickButton(goCart);
	}

	public void addProductToCart(int a) {
		waitFunctionClickable(productName);
		List<WebElement> product = driver.findElements(productName);
		Actions actions = new Actions(driver);
		actions.moveToElement(product.get(a)).build().perform();
		productNameList.add(product.get(a).getText());
	}
	
	public WebElement addProduct() {
		return driver.findElement(addToCartBtn);
	}

	public boolean verifyCartWithProductQuantity() {
		
		List<WebElement> pOnCard = driver.findElements(productOnCart);
		if (pOnCard.size() == 2)
			return true;
		else
			return false;
	}

	public boolean verifyCartWithProductName() {
		
		List<WebElement> pOnCard = driver.findElements(productOnCart);	
		for (int i = 0; i < pOnCard.size(); i++) {
			if (!productNameList.contains(pOnCard.get(i).getText())) {
				return false;
			}
		}
		return true;
	}
}

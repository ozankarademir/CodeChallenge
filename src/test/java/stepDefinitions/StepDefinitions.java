package stepDefinitions;

import org.junit.runner.RunWith;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import java.io.IOException;
import pageobjects.LoginPageTY;
import pageobjects.MainPageHB;
import pageobjects.MainPageTY;
import pageobjects.MyCartPageHB;
import pageobjects.ProductPageHB;
import pageobjects.UserInfoPageTY;
import utils.Base;

@RunWith(Cucumber.class)
public class StepDefinitions extends Base {

	public MainPageHB mainPageHb;
	public MyCartPageHB myCartPageHb;
	public MainPageTY mainPageTy;
	public LoginPageTY loginPageTy;
	public UserInfoPageTY userInfoPageTy;
	public ProductPageHB productPageHb;

	@Given("User is on {string} hepsiburada landing page")
	public void user_is_on_hepsiburada_landing_page(String hbMainPage) throws IOException {
		driver = initializeDriver();
		driver.get(hbMainPage);
	}
	
	@Then("Verify homepage is opened")
	public void verify_homepage_is_opened() {
		mainPageHb = new MainPageHB(driver);
		mainPageHb.verifyHomePageisOpen();
	}

	@When("User Search {string}")
	public void user_search(String laptop) {
		mainPageHb.searchProduct().sendKeys(laptop);
		mainPageHb.searchButton().click();
	}

	@Then("Verify product list page is opened")
	public void verify_product_list_page_is_opened() {
		productPageHb = new ProductPageHB(driver);
		waitFunctionClickable(productPageHb.productListContent);
		productPageHb.verifyProductListPageisOpen();
	}

	@And("User add first product from product list to cart")
	public void user_add_first_product_from_product_list_to_cart() throws InterruptedException {
		mainPageHb.scrollDown();
		Thread.sleep(500);
		productPageHb.addProductToCart(0);
		productPageHb.clickButton(productPageHb.addToCartBtn);

	}

	@Then("User add third product from product list to cart")
	public void user_add_third_product_from_product_list_to_cart() throws InterruptedException {
		Thread.sleep(3000);
		productPageHb.addProductToCart(2);
		productPageHb.clickButton(productPageHb.addToCartBtn);
	}

	@And("User goes to Cart")
	public void user_goes_to_cart() {
		myCartPageHb = new MyCartPageHB(driver);
		productPageHb.goCart();
		myCartPageHb.verifyMyCardPageisOpen();
	}

	@Then("Verify cart is opened")
	public void verify_cart_is_opened() {
		myCartPageHb.verifyMyCardPageisOpen();	
	}
	
	@Then("Verify product names and quantity")
	public void verify_product_names_and_quantity() {
		Assert.assertTrue(productPageHb.verifyCartWithProductName());
		Assert.assertTrue(productPageHb.verifyCartWithProductQuantity());
	}

	@And("User increases the quantity of the product in the basket")
	public void user_increases_the_quantity_of_the_product_in_the_basket() {
		myCartPageHb.increaseProduct();
	}

	@Then("Verify that the quantity of the product is {string}")
	public void verify_that_the_quantity_of_the_product_is(String quantity) {
		Assert.assertTrue(myCartPageHb.verifyQuantity(quantity));
	}

	@And("User go back to Main Page")
	public void user_go_back_to_main_page() {
		myCartPageHb.goMainPage();
		mainPageHb.verifyHomePageisOpen();
	}

	
	@Given("User is on {string} trendyol landing page")
	public void user_is_on_trendyol_landing_page(String string) {
		mainPageTy = new MainPageTY(driver);
		driver.get(string);
		mainPageTy.closeModalPopUp();
	}

	@And("User go to Login page")
	public void user_go_to_login_page() {
		mainPageTy.goLoginPage();
	}

	@Then("User login into website with {string} and {string} cridentials")
	public void user_login_into_website_with_and_cridentials(String string, String string2)
			throws InterruptedException {
		loginPageTy = new LoginPageTY(driver);
		loginPageTy.loginWith(string, string2);
	}

	@And("User verifies whether log in successfully")
	public void user_verifies_whether_log_in_successfully() throws InterruptedException {
		Assert.assertTrue(mainPageTy.verifyLogin());
		Thread.sleep(1000);
	}

	@Then("User go to User Information page")
	public void user_go_to_user_ınformation_page() {
		mainPageTy.goUserInfoPage();
	}

	@Then("Verify User Information page is opened")
	public void verify_user_ınformation_page_is_opened() {
		userInfoPageTy = new UserInfoPageTY(driver);
		waitFunctionClickable(userInfoPageTy.birthDayBtn);
		userInfoPageTy.verifyUserInfoPageIsOpen();
		userInfoPageTy.scrollDown();
	}

	@Then("User selects {int} th index in birthday dropdown")
	public void user_selects_th_index_in_birthday_dropdown(Integer int1) {
		userInfoPageTy.selectBirthDay(int1);
	}

	@Then("User selects {int} th index in birthmonth dropdown")
	public void user_selects_th_index_in_birthmonth_dropdown(Integer int1) {
		userInfoPageTy.selectBirthMonth(int1);
	}

	@Then("User selects {int} th index in birthyear dropdown")
	public void user_selects_th_index_in_birthyear_dropdown(Integer int1) {
		userInfoPageTy.selectBirthYear(int1);
	}

	@Then("User press update button")
	public void user_press_update_button() {
		userInfoPageTy.birthDateUpdate();
		userInfoPageTy.scrollUp();
	}

	@Then("Verify the birthdate")
	public void verify_the_birthdate() {
		Assert.assertTrue(userInfoPageTy.updateSuccessMsg().isDisplayed());
	}
	
	@And("User close the browser")
	public void user_close_the_browser() {
	    tearDown();
	}

}

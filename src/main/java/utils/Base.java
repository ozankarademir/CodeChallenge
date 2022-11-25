package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static WebDriverWait w;
	private Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\utils\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");// data.properties
		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}
	
	public void tearDown () {
		driver.quit();
	}

	public void waitFunctionClickable(By locator) {
		w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public void waitFunctionVisible(By locator)
	{
		w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void mouseOver(By by) {
		w.until(ExpectedConditions.visibilityOfElementLocated(by));
		w.until(ExpectedConditions.elementToBeClickable(by));
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(by);
		action.moveToElement(element).perform();
	}

	public void clickButton(By by) {
		w.until(ExpectedConditions.visibilityOfElementLocated(by));
		w.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}

	public void sendKey(By by, String keys) {
		w.until(ExpectedConditions.visibilityOfElementLocated(by));
		driver.findElement(by).sendKeys(new CharSequence[] { keys });
	}
}

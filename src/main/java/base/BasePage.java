package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BasePage {

	protected WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	private Logger logger = Logger.getLogger(String.valueOf(BasePage.class));

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement find(By locator) {
		logger.info(String.format("Locating element '%s'", locator.toString()));
		return new WebDriverWait(driver, 200).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void openURL(String url) {
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public void click(By locator) {
		logger.info(String.format("Clicking element '%s'", locator.toString()));
		find(locator).click();
	}

	public void type(String text, By locator) {
		type(text, true, locator);
	}

	public void type(String text, boolean append, By locator) {
		WebElement element = find(locator);
		if (append) {
			element.clear();
		}

		logger.info(String.format("Typing '%s' in element '%s'", text, locator.toString()));
		element.sendKeys(text);
	}
	
	protected WebElement waitForElementToBeVisible(final By locator) {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(200,
				TimeUnit.MILLISECONDS);

		return wait.until(ExpectedConditions.visibilityOf(find(locator)));
	}

	public enum Locators {
		id, name, classname, css, xpath, linktext, tagName;
	}
	
	public By getBy(String locatorType, String locatorValue) {
		switch (Locators.valueOf(locatorType)) {
		case id:
			return By.id(locatorValue);
		case xpath:
			return By.xpath(locatorValue);
		case css:
			return By.cssSelector(locatorValue);
		case name:
			return By.name(locatorValue);
		case classname:
			return By.className(locatorValue);
		case linktext:
			return By.linkText(locatorValue);
		case tagName:
			return By.tagName(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}
	
	public static String changeDateFormat(String Date, String actualFormat, String newFormat) {
		DateFormat originalFormat = new SimpleDateFormat(actualFormat);
		DateFormat targetFormat = new SimpleDateFormat(newFormat);
		Date date = null;
		try {
			date = originalFormat.parse(Date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String formattedDate = targetFormat.format(date);
		return formattedDate;
	}

}

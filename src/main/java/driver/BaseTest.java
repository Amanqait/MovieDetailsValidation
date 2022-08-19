package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagesObject.IMDBMovie_page;
import pagesObject.IMDB_page;
import pagesObject.WikiLanding_page;
import pagesObject.Wiki_page;

/*
 * Setting up the driver
 */

public abstract class BaseTest {

  private WebDriver driver;
  public static DesiredCapabilities caps = new DesiredCapabilities();

  public void setUp() {
	  WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--incognito");
      options.addArguments("--test-type");
      options.addArguments("--disable-popup-bloacking");
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-gpu");
      options.addArguments("--disable-crash-reporter");
      options.addArguments("--disable-extensions");
      options.addArguments("--disable-in-process-stack-traces");
      options.addArguments("--disable-logging");
      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--log-level=3");
      options.addArguments("--output=/dev/null");
      System.setProperty("webdriver.chrome.silentOutput", "true");
      caps.setCapability(ChromeOptions.CAPABILITY, options);
      caps.setJavascriptEnabled(true);
      driver = new ChromeDriver(options);
      driver.manage().deleteAllCookies();
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
  }

  public void tearDown() {
    driver.quit();
    driver = null;
  }

  /**
   * This method is protected to restrict changing the driver instance.
   *
   * @return instance of {@link WebDriver}
   */
  protected WebDriver getDriver() {
    return driver;
  }

  protected IMDB_page getIMDbPage() {
    return new IMDB_page(getDriver());
  }
  
  protected Wiki_page getWikiPage() {
	    return new Wiki_page(getDriver());
  }
  
  protected IMDBMovie_page getIMDbMoviePage() {
	    return new IMDBMovie_page(getDriver());
  }
  
  protected WikiLanding_page getWikiLandingPage() {
	    return new WikiLanding_page(getDriver());
}
}

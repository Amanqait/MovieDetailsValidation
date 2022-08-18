package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class WikiLanding_page extends BasePage {

    public WikiLanding_page(WebDriver driver) {
        super(driver);
    }
    
    public static final By movieHeading = By.cssSelector("h1#firstHeading");
    public static final By releaseDate = By.xpath("//div[text()='Release date']/..//following-sibling::td");
    public static final By countryOfOrigin = By.xpath("//th[text()='Country']/..//following-sibling::td");	
    
    public String getMovieHeading() {
    	return find(movieHeading).getText();
    }
    
    public String getMovieReleaseDate() {
    	return find(releaseDate).getText();
    }
    
    public String getCountryOfOrigin() {
    	return find(countryOfOrigin).getText();
    }
    

}

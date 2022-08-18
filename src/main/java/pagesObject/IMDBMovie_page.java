package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class IMDBMovie_page extends BasePage {

    public IMDBMovie_page(WebDriver driver) {
        super(driver);
    }
    
    public static final By movieHeading = By.cssSelector("h1[data-testid*='hero-title']");
    public static final By releaseDate = By.xpath("//*[@data-testid='title-details-section']//a[text()='Release date']/following-sibling::div");
    public static final By countryOfOrigin = By.xpath("//*[@data-testid='title-details-section']//span[text()='Country of origin']/following-sibling::div");	
    
    public String getMovieHeading() {
    	return find(movieHeading).getText();
    }
    
    public String getMovieReleaseDate() {
    	String temp = find(releaseDate).getText();
    	String[] movie = temp.split("\\(");
    	return movie[0].trim();
    }
    
    public String getCountryOfOrigin() {
    	return find(countryOfOrigin).getText();
    }
    

}

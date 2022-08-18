package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class IMDB_page extends BasePage {

    public IMDB_page(WebDriver driver) {
        super(driver);
    }
    
    public static final By searchField = By.cssSelector("input[aria-label='Search IMDb']");
    public static String movieFromSuggestion = "//ul[contains(@class,'suggestions-list')]//div[contains(text(),'$')]//ancestor::a";
    
    public void enterMovieName(String movieName) {
    	click(searchField);
    	type(movieName, searchField);
    }
    
    public void selectMovieFromSuggestion(String movieName) {
    	String temp = movieFromSuggestion.replace("$", movieName);
    	click(getBy("xpath",temp));
    }

}

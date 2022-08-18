package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class Wiki_page extends BasePage {

    public Wiki_page(WebDriver driver) {
        super(driver);
    }
    
    public static final By searchField = By.cssSelector("input[type='search']");
    public static String movieFromSuggestion = "div.suggestions-results>a[title='$']";
    
    public void enterMovieName(String movieName) {
    	click(searchField);
    	type(movieName, searchField);
    }
    
    public void selectMovieFromSuggestion(String movieName) {
    	String temp = movieFromSuggestion.replace("$", movieName);
    	click(getBy("css",temp));
    }

}

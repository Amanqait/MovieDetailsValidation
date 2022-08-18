package movieDetails;

import pagesObject.WikiLanding_page;
import pagesObject.Wiki_page;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driver.BaseTest;

public class Wiki_Test extends BaseTest {
    private Wiki_page WIKI;
    private WikiLanding_page WikiLanding;
    public String country,releaseDate;

    @BeforeClass
    public void setUp() {
        super.setUp();
        WIKI = getWikiPage();
        WikiLanding = getWikiLandingPage();
    }

    @Test
    public void Test001_Open_WIKI_URL() {
        WIKI.openURL("https://en.wikipedia.org/wiki/Wiki/");
        Assert.assertEquals(WIKI.getPageTitle(), "Wikipedia, the free encyclopedia");
        Reporter.log("WIKI URL opened");
    }
    
    @Test
    public void Test002_Search_Movie() {
    	WIKI.enterMovieName("Pushpa: The Rise");
    	Reporter.log("Entered Movie");
    }
    
    @Test
    public void Test003_Select_Movie_From_Suggestion() {
    	WIKI.selectMovieFromSuggestion("Pushpa: The Rise");
    	Assert.assertTrue(WikiLanding.getMovieHeading().contains("Pushpa: The Rise"));
    	Reporter.log("Navigated to Landing Page");
    }
    
    @Test
    public void Test004_Get_The_Movie_Details() {
    	releaseDate = WikiLanding.getMovieReleaseDate();
    	country = WikiLanding.getCountryOfOrigin();
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}

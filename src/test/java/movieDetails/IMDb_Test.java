package movieDetails;

import pagesObject.IMDBMovie_page;
import pagesObject.IMDB_page;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driver.BaseTest;

public class IMDb_Test extends BaseTest {
    private IMDB_page IMDB;
    private IMDBMovie_page IMDBMOVIE;
    public String country,releaseDate;

    @BeforeClass
    public void setUp() {
        super.setUp();
        IMDB = getIMDbPage();
        IMDBMOVIE = getIMDbMoviePage();
    }

    @Test
    public void Test001_Open_IMDB_URL() {
        IMDB.openURL("https://www.imdb.com/");
        Assert.assertEquals(IMDB.getPageTitle(), "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows");
        Reporter.log("IDMB URL opened");
    }
    
    @Test
    public void Test002_Search_Movie() {
    	IMDB.enterMovieName("Pushpa: The Rise");
    	Reporter.log("Entered Movie");
    }
    
    @Test
    public void Test003_Select_Movie_From_Suggestion() {
    	IMDB.selectMovieFromSuggestion("Pushpa: The Rise");
    	Assert.assertTrue(IMDBMOVIE.getMovieHeading().contains("Pushpa: The Rise"));
    	Reporter.log("Navigated to Movie Page");
    }
    
    @Test
    public void Test004_Get_The_Movie_Details() {
    	releaseDate = IMDBMOVIE.getMovieReleaseDate();
    	country = IMDBMOVIE.getCountryOfOrigin();
    }
    

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}

package movieDetails;

import pagesObject.IMDBMovie_page;
import pagesObject.IMDB_page;
import pagesObject.WikiLanding_page;
import pagesObject.Wiki_page;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driver.BaseTest;

public class VerificationOfReleaseDateAndCountry_Test extends BaseTest {
	private IMDB_page IMDB;
	private IMDBMovie_page IMDBMOVIE;
	private Wiki_page WIKI;
	private WikiLanding_page WikiLanding;
	String countryIMDb, releaseDateIMDb , countryWiki, releaseDateWiki;

	@BeforeClass
	public void setUp() {
		super.setUp();
		IMDB = getIMDbPage();
		IMDBMOVIE = getIMDbMoviePage();
		WIKI = getWikiPage();
		WikiLanding = getWikiLandingPage();
	}

	@Test(description = "Opening IMDB URL")
	public void Test001_Open_IMDB_URL() {
		IMDB.openURL("https://www.imdb.com/");
		Assert.assertEquals(IMDB.getPageTitle(),
				"IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows");
		Reporter.log("IDMB URL opened");
	}

	@Test(description = "Searching the movie via Search field")
	public void Test002_Search_Movie() {
		IMDB.enterMovieName("Pushpa: The Rise");
		Reporter.log("Entered Movie");
	}

	@Test(description = "Selecting movie from Suggestion list")
	public void Test003_Select_Movie_From_Suggestion() {
		IMDB.selectMovieFromSuggestion("Pushpa: The Rise");
		Assert.assertTrue(IMDBMOVIE.getMovieHeading().contains("Pushpa: The Rise"));
		Reporter.log("Navigated to Movie Page");
	}

	@Test(description = "Retrieving Movie details")
	public void Test004_Get_The_Movie_Details() {
		releaseDateIMDb = IMDBMOVIE.getMovieReleaseDate();
		releaseDateIMDb = IMDBMovie_page.changeDateFormat(releaseDateIMDb, "MMMM d, yyyy", "d MMMM yyyy");
		countryIMDb = IMDBMOVIE.getCountryOfOrigin();
	}

	@Test(description = "Opening Wikipedia URL")
	public void Test005_Open_WIKI_URL() {
		WIKI.openURL("https://en.wikipedia.org/wiki/Wiki/");
		Assert.assertEquals(WIKI.getPageTitle(), "Wikipedia, the free encyclopedia");
		Reporter.log("WIKI URL opened");
	}

	@Test(description = "Searching movie on Wiki search")
	public void Test006_Search_Movie_ON_WIKI() {
		WIKI.enterMovieName("Pushpa: The Rise");
		Reporter.log("Entered Movie");
	}

	@Test(description = "Select the movie from suggestion list")
	public void Test007_Select_Movie_From_Suggestion() {
		WIKI.selectMovieFromSuggestion("Pushpa: The Rise");
		Assert.assertTrue(WikiLanding.getMovieHeading().contains("Pushpa: The Rise"));
		Reporter.log("Navigated to Landing Page");
	}

	@Test(description = "Retrieving the movie details")
	public void Test008_Get_The_Movie_Details() {
		releaseDateWiki = WikiLanding.getMovieReleaseDate();
		countryWiki = WikiLanding.getCountryOfOrigin();
	}
	
	@Test(description = "Comparing country details")
	public void Test009_Verify_The_Country_Details() {
		Assert.assertEquals(countryIMDb, countryWiki);
		Reporter.log("Country details MATCHED!!");
	}
	
	@Test(description = "Comparing the release date details")
	public void Test010_Verify_The_Release_Date_Details() {
		Assert.assertEquals(releaseDateIMDb, releaseDateIMDb);
	}

	//Closing the driver
    @AfterClass
	public void tearDown() {
		super.tearDown();
	}
}

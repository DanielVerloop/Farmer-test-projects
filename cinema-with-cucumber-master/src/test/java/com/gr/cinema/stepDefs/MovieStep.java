package com.gr.cinema.stepDefs;

import com.gr.cinema.common.JsonUtils;
import com.gr.cinema.domain.Movie;
import com.gr.cinema.domain.Movies;
import com.gr.framework.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


public class MovieStep extends TestBase{
    Movie movie;

    @Before
    public void setup() {
        loadEnv();
    }

    @After
    public void cleanup() {
        session.resetSession();
    }

    @Given("^I want to setup a new movie$")
    public void iWantToSetupOfNewMovie(){
        movie = new Movie();
    }

    @When("^the movie has the name \"([^\"]*)\"$")
    public void theMovieHasTheNameName(String name) {
        movie.setName(name);
    }

    @And("^the movie has a rating of \"([^\"]*)\"$")
    public void theMovieHasARatingOfRating(String rating) {
        movie.setRating(rating);
    }

    @And("^the duration of the movie is \"([^\"]*)\"$")
    public void theDurationOfTheMovieIsDuration(String duration) {
        movie.setDuration(duration);
    }

    @And("^the cast of the movie is \"([^\"]*)\"$")
    public void theCastOfTheMovieIsMainCast(String mainCast) {
        movie.setMainCast(mainCast);
    }

    @Then("^I validate that the the new movie is setup correctly.$")
    public void iValidateNewMovieSetupCorrectly() {
        Map<String,String> paramMap = new HashMap<>();

        String urlGET = envMap.get("url.movies")+"/"+movie.getMovieId();

        String movieJson = executeGET(urlGET, paramMap);

        Movies fetchedMovies = JsonUtils.fromJsonStr(movieJson, Movies.class);

        Assert.assertTrue( "Issue with persisting the Movie data.",
                compareMovies(movie , fetchedMovies.getMovies().get(0)));
    }

    public boolean compareMovies(Movie m1 , Movie m2) {

        boolean moviesMatch = true;

        if (m1 == null || m2 == null) {
            return false;
        }

        if (m1.getMovieId() != null && m2.getMovieId() != null) {
            if (! m1.getMovieId().equals(m2.getMovieId())) {
                moviesMatch = false;
            }
        }

        if (m1.getName() != null && m2.getName() != null) {
            if (! m1.getName().equals(m2.getName())) {
                moviesMatch = false;
            }
        }else {
            moviesMatch = false;
        }

        if (m1.getDuration() != null && m2.getDuration() != null) {
            if (! m1.getDuration().equals(m2.getDuration())) {
                moviesMatch = false;
            }
        }else {
            moviesMatch = false;
        }

        if (m1.getMainCast() != null && m2.getMainCast() != null) {
            if (! m1.getMainCast().equals(m2.getMainCast())) {
                moviesMatch = false;
            }
        }else {
            moviesMatch = false;
        }

        return moviesMatch;
    }
}

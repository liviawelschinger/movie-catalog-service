package de.livia.moviecatalogservice.restcontroller;

import de.livia.moviecatalogservice.model.CatalogItem;
import de.livia.moviecatalogservice.model.Movie;
import de.livia.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hardcoded (Dummy) REST API
 */
@RestController
@RequestMapping("/catalog") //when calls "/catalog", load up the class CatalogItem (resource)
public class MovieCatalogRestController {

    // call an external API with REST Template (synchronous client to perform HTTP requests)
    @Autowired // Dependency Injection of the Bean created in the Application class
    private RestTemplate restTemplate;


    // http://localhost:8081/catalog/foo or http://localhost:8080/catalog/abc
    // returns [{"title":"Test name","desc":"Desc","rating":4},{"title":"Test name","desc":"Desc","rating":3}]
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog (@PathVariable("userId") String userId) {


        // get all rated movie IDs

        /*List<Rating> ratings = new Arrays.asList(
            new Rating("1234", 4),
            new Rating("5678", 3)

        );*/

        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("1234", 4));
        ratings.add(new Rating("5678", 3));


        // The information abot the catalog item which is hard coded here should normally come from the API
        return ratings.stream().map(rating -> {
            // 1st parameter URL, you want to call; 2nd parameter class response Type
            // iteration: for each rating get the movie (movieId)
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            // first API call
            // for each movie ID call movieinfo service and get details
            return new CatalogItem(movie.getTitle(), "Desc", rating.getRating());
        })
                .collect(Collectors.toList());





    }
}

package com.pradeep.microservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.pradeep.microservice.models.Movie;
import com.pradeep.microservice.models.MovieCatalogueItem;
import com.pradeep.microservice.models.Rating;
import com.pradeep.microservice.models.UserRating;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueResource {

//	private static final String MOVIE_INFO_BASE_URL = "http://localhost:8083/movies/";
//	private static final String RATINGS_DATA_BASE_URL = "http://localhost:8084/ratings/";

	private static final String MOVIE_INFO_BASE_URL = "http://movie-info-service/movies/";
	private static final String RATINGS_DATA_BASE_URL = "http://ratings-data-service/ratings/";

	@Autowired
	RestTemplate restTemplate;

	// configuration for WebClient
	/*
	 * @Autowired WebClient.Builder webClientBuilder;
	 */

	@GetMapping("/{userId}")
	public List<MovieCatalogueItem> getMovieCatalogue(@PathVariable("userId") String userId) {
		UserRating userRating = restTemplate.getForObject(RATINGS_DATA_BASE_URL + "user/" + userId, UserRating.class);
		List<Rating> ratings = userRating.getRatings();

		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject(MOVIE_INFO_BASE_URL + rating.getMovieId(), Movie.class);
			return new MovieCatalogueItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
	}
}

// configuration for WebClient
/*
 * String movieUri = MOVIE_INFO_BASE_URL + ratingData.getMovieId(); Movie movie
 * = webClientBuilder.build() .get() .uri(movieUri) .retrieve()
 * .bodyToMono(Movie.class) .block();
 */

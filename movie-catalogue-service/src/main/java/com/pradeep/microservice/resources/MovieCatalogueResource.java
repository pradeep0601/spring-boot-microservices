package com.pradeep.microservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pradeep.microservice.models.Movie;
import com.pradeep.microservice.models.MovieCatalogueItem;
import com.pradeep.microservice.models.RatingData;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueResource {

	private static final String MOVIE_INFO_URL = "http://localhost:8083/movies/";

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<MovieCatalogueItem> getMovieCatalogue(@PathVariable("userId") String userId) {
		List<RatingData> ratingDatas = Arrays.asList(new RatingData("1234", 40), new RatingData("4557", 31));
		return ratingDatas.stream().map(ratingData -> {
			Movie movie = restTemplate.getForObject(MOVIE_INFO_URL + ratingData.getMovieId(), Movie.class);
			return new MovieCatalogueItem(movie.getName(), movie.getDescription(), ratingData.getRating());
		}).collect(Collectors.toList());
	}
}

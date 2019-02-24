package com.pradeep.microservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.microservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

		return new Movie(movieId, "Test movie", "Test movie's desc");
	}
}

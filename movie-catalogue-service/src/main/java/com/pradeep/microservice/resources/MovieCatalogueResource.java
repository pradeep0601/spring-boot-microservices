package com.pradeep.microservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.microservice.models.MovieCatalogueItem;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueResource {

	@RequestMapping("/{userId}")
	public List<MovieCatalogueItem> getMovieCatalogue(@PathVariable("userId") String userId) {
		return Collections.singletonList(new MovieCatalogueItem("Avenger", "Movie about avengers", 5));
	}
}

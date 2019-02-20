package com.pradeep.microservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.microservice.models.RatingData;

@RestController
@RequestMapping("/ratings")
public class RatingDataResource {

	@RequestMapping("/{movieId}")
	public RatingData getRating(@PathVariable("movieId") String movieId) {
		return new RatingData(movieId, 6);
	}
}

package com.pradeep.microservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.microservice.models.Rating;
import com.pradeep.microservice.models.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingDataResource {

	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 6);
	}
	
	@GetMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 5),
				new Rating("3456", 8),
				new Rating("6789", 3)
				);
		UserRating userRating = new UserRating();
		userRating.setRatings(ratings);
		return userRating;
	}
}

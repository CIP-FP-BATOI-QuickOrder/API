package ApiQuickOrder.controller;

import ApiQuickOrder.models.Ratings;
import ApiQuickOrder.models.RatingsId;
import ApiQuickOrder.models.Review;
import ApiQuickOrder.service.RatingService;
import ApiQuickOrder.service.RestaurantService;
import ApiQuickOrder.service.ReviewService;
import ApiQuickOrder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("rating")
public class RatingController {
	@Autowired
	RatingService service;
	@Autowired
	UserService userService;
	@Autowired
	RestaurantService restaurantService;

	@PostMapping("/user={userId}/restaurant={restaurantId}/content={value}")
	public ResponseEntity<?> add(@PathVariable int userId, @PathVariable int restaurantId, @PathVariable double value) {
		Ratings ratings = new Ratings(value);
		RatingsId ids = new RatingsId(userId, restaurantId);
		ratings.setId(ids);
		Ratings newRating = service.save(ratings);
		return new ResponseEntity<>(newRating.getId(), HttpStatus.CREATED);
	}

}

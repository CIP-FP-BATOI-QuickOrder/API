package ApiQuickOrder.controller;

import ApiQuickOrder.models.PaymentMethod;
import ApiQuickOrder.models.Product;
import ApiQuickOrder.models.Review;
import ApiQuickOrder.service.*;
import jdk.jfr.DataAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("review")
public class ReviewController {
	@Autowired
	ReviewService service;
	@Autowired
	UserService userService;
	@Autowired
	RestaurantService restaurantService;

	@GetMapping("/restaurant={restaurantId}")
	public List<Review> search(@PathVariable int restaurantId) {
		return service.getByRestaurantId(restaurantId);
	}

	@PostMapping("/user={userId}/restaurant={restaurantId}")
	public ResponseEntity<?> add(@RequestBody Review review, @PathVariable int userId, @PathVariable int restaurantId) {
		review.setUser(userService.getById(userId));
		review.setRestaurant(restaurantService.getById(restaurantId));
		review.setCreatedAt(Date.valueOf(LocalDate.now()));
		Review newReview = service.save(review);
		return new ResponseEntity<>(newReview.getId(), HttpStatus.CREATED);
	}

}

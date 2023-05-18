package ApiQuickOrder.controller;

import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.models.User;
import ApiQuickOrder.service.RestaurantService;
import ApiQuickOrder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
	@Autowired
	RestaurantService service;

	@GetMapping("")
	public List<Restaurant> findUserById() {
		return service.findAll();
	}

	@GetMapping("/search={search}")
	public List<Restaurant> search(@PathVariable String search) {
		return service.search(search);
	}
}

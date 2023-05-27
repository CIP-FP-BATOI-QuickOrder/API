package ApiQuickOrder.controller;

import ApiQuickOrder.models.Product;
import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.service.ProductService;
import ApiQuickOrder.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping("/restaurant={restaurantId}")
	public List<Product> search(@PathVariable int restaurantId) {
		return service.findByRestaurant(restaurantId);
	}

}

package ApiQuickOrder.controller;

import ApiQuickOrder.models.Address;
import ApiQuickOrder.models.Product;
import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.service.ProductService;
import ApiQuickOrder.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService service;
	@Autowired
	RestaurantService restaurantService;
	@GetMapping("/restaurant={restaurantId}")
	public List<Product> search(@PathVariable int restaurantId) {
		return service.findByRestaurant(restaurantId);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Product newProduct, @PathVariable Integer id) {
		try {
			Product product = service.getById(id);
			product.setName(newProduct.getName());
			product.setDescription(newProduct.getDescription());
			product.setPrice(newProduct.getPrice());
			service.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/restaurant={restaurantId}")
	public ResponseEntity<?> save(@RequestBody Product product, @PathVariable int restaurantId) {
		try {
			product.setRestaurant(restaurantService.getById(restaurantId));
			Product newProduct = service.save(product);
			return new ResponseEntity<>(newProduct.getId(), HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@PostMapping("/upload={productId}")
	public void handleFileUpload(@PathVariable int productId, @RequestPart("photo") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				String fileName = StringUtils.cleanPath(file.getOriginalFilename());
				Path filePath = Path.of("/var/www/html", fileName);
				Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
				service.updatePhoto(productId, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

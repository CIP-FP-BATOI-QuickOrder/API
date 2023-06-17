package ApiQuickOrder.controller;

import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.models.Tags;
import ApiQuickOrder.service.RestaurantService;
import ApiQuickOrder.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("tag")
public class TagController {
	@Autowired
	TagService service;
	@Autowired
	RestaurantService restaurantService;

	@PostMapping("{tag}/restaurant={restaurantId}")
	public ResponseEntity<?> add(@PathVariable String tag, @PathVariable int restaurantId) {
		Tags newTag = new Tags(restaurantService.getById(restaurantId), tag);
		newTag = service.save(newTag);
		return new ResponseEntity<>(newTag.getId(), HttpStatus.CREATED);
	}
}

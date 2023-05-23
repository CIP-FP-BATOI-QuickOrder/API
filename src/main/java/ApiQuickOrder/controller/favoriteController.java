package ApiQuickOrder.controller;

import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorites")
public class favoriteController {
    @Autowired
    UserService service;

    @GetMapping("/user={user_id}/restaurant={restaurant_id}")
    public ResponseEntity<?> isFavorite(@PathVariable int user_id, @PathVariable int restaurant_id) {
        if (service.isFavorite(user_id, restaurant_id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/add/user={user_id}/restaurant={restaurant_id}")
    public ResponseEntity<?> addFavorite(@PathVariable int user_id, @PathVariable int restaurant_id) {
		service.addFavorites(user_id, restaurant_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/remove/user={user_id}/restaurant={restaurant_id}")
    public ResponseEntity<?> removeFavorite(@PathVariable int user_id, @PathVariable int restaurant_id) {
        service.removeFavorites(user_id, restaurant_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

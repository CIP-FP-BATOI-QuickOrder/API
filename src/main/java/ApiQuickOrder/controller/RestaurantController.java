package ApiQuickOrder.controller;

import ApiQuickOrder.models.Restaurant;
import ApiQuickOrder.models.User;
import ApiQuickOrder.service.RestaurantService;
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

    @GetMapping("rand={limit}")
    public List<Restaurant> rand(@PathVariable Integer limit) {
        return service.rand(limit);
    }

    @GetMapping("popular={limit}")
    public List<Restaurant> popular(@PathVariable Integer limit) {
        return service.populars(limit);
    }

    @GetMapping("/favorites={user_id}")
    public List<Restaurant> getFavorites(@PathVariable int user_id) {
        return service.getFavorites(user_id);
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = service.save(restaurant);
        return new ResponseEntity<>(newRestaurant.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/upload={restaurantId}")
    public void handleFileUpload(@PathVariable int restaurantId, @RequestPart("photo") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                Path filePath = Path.of("/var/www/html", fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                service.updatePhoto(restaurantId, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/nif={nif}/password={password}")
    public ResponseEntity<Optional<Restaurant>> login(@PathVariable String nif, @PathVariable String password) {
        try {
            Optional<Restaurant> restaurant = service.login(nif, password);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reset/nif={nif}/password={password}")
    public void reset(@PathVariable String nif, @PathVariable String password) {
        Restaurant restaurant = service.getByNif(nif);
        restaurant.setPassword(password);
        service.save(restaurant);
    }

}

package ApiQuickOrder.controller;

import ApiQuickOrder.models.Address;
import ApiQuickOrder.models.User;
import ApiQuickOrder.service.UserService;
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
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService service;

	@GetMapping("/id={id}")
	public ResponseEntity<Optional<User>> findUserById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/email={email}/password={passwd}")
	public ResponseEntity<Optional<User>> auth(@PathVariable String email, @PathVariable String passwd) {
		try {
			Optional<User> user = service.login(email, passwd);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/user={user_id}/restaurant={restaurant_id}")
	public ResponseEntity<?> isFavorite(@PathVariable int user_id, @PathVariable int restaurant_id) {
		if (service.isFavorite(user_id, restaurant_id)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping("")
	public ResponseEntity<?> add(@RequestBody User user) {
		try {
			User newUser = service.save(user);
			return new ResponseEntity<>(newUser.getId(), HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@PutMapping("/email={email}/password={password}")
	public ResponseEntity<?> update(@PathVariable String email, @PathVariable String password) {
		try {
			User user = service.findByEmail(email);
			if (user != null){
				user.setPassword(password);
				service.save(user);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/upload={userId}")
	public void handleFileUpload(@PathVariable int userId, @RequestPart("photo") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				String fileName = StringUtils.cleanPath(file.getOriginalFilename());
				Path filePath = Path.of("/var/www/html", fileName);
				Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
				service.updatePhoto(userId, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
		try {
			User actualUser = service.getById(id);
			actualUser.setPassword(user.getPassword());
			actualUser.setName(user.getName());
			actualUser.setEmail(user.getEmail());
			actualUser.setSurname(user.getSurname());
			actualUser.setPhone(user.getPhone());
			service.save(actualUser);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

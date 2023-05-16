package ApiQuickOrder.controller;

import ApiQuickOrder.models.User;
import ApiQuickOrder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> findUserById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{email}/{passwd}")
	public ResponseEntity<Optional<User>> auth(@PathVariable String email, @PathVariable String passwd) {
		try {
			Optional<User> user = service.login(email, passwd);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
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
}

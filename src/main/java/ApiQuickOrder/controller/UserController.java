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
}

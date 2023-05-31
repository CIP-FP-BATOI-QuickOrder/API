package ApiQuickOrder.controller;

import ApiQuickOrder.models.Address;
import ApiQuickOrder.models.PaymentMethod;
import ApiQuickOrder.service.AddressService;
import ApiQuickOrder.service.ProductService;
import ApiQuickOrder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService service;
    @Autowired
    UserService userService;

    @PostMapping("/{userId}")
    public ResponseEntity<?> add(@RequestBody Address address, @PathVariable int userId) {
        address.setUser(userService.getById(userId));
        Address newAddress = service.save(address);
        return new ResponseEntity<>(newAddress.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Address address, @PathVariable Integer id) {
        try {
            Address actualAddress = service.getById(id);
            actualAddress.setAddress(address.getAddress());
            actualAddress.setCity(address.getCity());
            actualAddress.setCp(address.getCp());
            actualAddress.setName(address.getName());
            actualAddress.setNumber(address.getNumber());
            actualAddress.setAddressName(address.getAddressName());
            service.save(actualAddress);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
}

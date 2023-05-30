package ApiQuickOrder.controller;

import ApiQuickOrder.models.Address;
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

    @PostMapping("/user={userId}/name={name}/city={city}/cp={cp}/number={number}/address={address}/name={addressName}")
    public ResponseEntity<?> add(@PathVariable Integer userId, @PathVariable String name, @PathVariable Integer number,
                                 @PathVariable String city, @PathVariable Integer cp, @PathVariable String address,
                                 @PathVariable String addressName) {
        Address newAddress = new Address(userService.getById(userId), address, number, name, city, cp, addressName);
        newAddress = service.save(newAddress);
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

package ApiQuickOrder.controller;

import ApiQuickOrder.models.Address;
import ApiQuickOrder.models.PaymentMethod;
import ApiQuickOrder.service.AddressService;
import ApiQuickOrder.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("pay")
public class PaymentMethodController {
    @Autowired
    PaymentMethodService service;

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody PaymentMethod paymentMethod) {
        PaymentMethod newPaymentMethod = service.save(paymentMethod);
        return new ResponseEntity<>(newPaymentMethod.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody PaymentMethod paymentMethod, @PathVariable Integer id) {
        try {
            PaymentMethod actualPaymentMethod = service.getById(id);
            actualPaymentMethod.setBank(paymentMethod.getBank());
            actualPaymentMethod.setCreditCart(paymentMethod.getCreditCart());
            actualPaymentMethod.setExpirationDate(paymentMethod.getExpirationDate());
            service.save(actualPaymentMethod);
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

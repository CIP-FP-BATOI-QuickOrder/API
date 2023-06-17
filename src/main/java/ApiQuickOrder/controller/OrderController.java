package ApiQuickOrder.controller;

import ApiQuickOrder.models.Order;
import ApiQuickOrder.models.PaymentMethod;
import ApiQuickOrder.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService service;
    @Autowired
    UserService userService;
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    AddressService addressService;

    @PostMapping("/userId={userId}/restaurantId={restaurantId}/addressId={addressId}")
    public ResponseEntity<?> add(@RequestBody Order order, @PathVariable int userId,
                                 @PathVariable int restaurantId, @PathVariable int addressId) {
        order.setUser(userService.getById(userId));
        order.setRestaurant(restaurantService.getById(restaurantId));
        order.setAddress(addressService.getById(addressId));
        Order newOrder = service.save(order);
        return new ResponseEntity<>(newOrder.getId(), HttpStatus.CREATED);
    }
}

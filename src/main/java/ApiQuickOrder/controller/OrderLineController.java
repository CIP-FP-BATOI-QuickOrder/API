package ApiQuickOrder.controller;

import ApiQuickOrder.models.Order;
import ApiQuickOrder.models.OrderLine;
import ApiQuickOrder.models.OrderLineId;
import ApiQuickOrder.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("orderLine")
public class OrderLineController {
    @Autowired
    OrderLineService service;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @PostMapping("/orderId={orderId}/productId={productId}")
    public ResponseEntity<?> add(@RequestBody OrderLine orderLine, @PathVariable int orderId,
                                 @PathVariable int productId) {
        orderLine.setOrder(orderService.getById(orderId));
        orderLine.setProduct(productService.getById(productId));
        orderLine.setId(new OrderLineId(0,orderId));
        OrderLine newOrderLine = service.save(orderLine);
        return new ResponseEntity<>(newOrderLine.getId(), HttpStatus.CREATED);
    }
}

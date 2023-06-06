package de.lptrk.ecommerce.backend.order;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import de.lptrk.ecommerce.backend.user.UserEty;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class OrderController {

    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("orders")
    public ResponseEntity<List<OrderEty>> getOrders() {
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<OrderEty> getOrderById(String id) throws EntityNotFoundException {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    record newOrderRequest(
            String id,
            UserEty user,
            Date orderDate,
            Double totalAmount,
            String status,
            String shippingAddress,
            Date createdAt,
            Date updatedAt
    ) {
    }

    @PostMapping("orders")
    public ResponseEntity<OrderEty> createOrder(@RequestBody OrderEty orderEty) {
        return new ResponseEntity<>(orderService.saveOrder(orderEty), HttpStatus.CREATED);
    }

}

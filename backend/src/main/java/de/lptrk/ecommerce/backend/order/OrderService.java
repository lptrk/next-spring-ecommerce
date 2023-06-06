package de.lptrk.ecommerce.backend.order;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<OrderEty>getOrders(){
        return orderRepository.findAll();
    }

    //wenn findby id == null => exception ansonsten return orderety
    //@ControllerAdvice für exception

    public OrderEty getOrderById(String id) throws EntityNotFoundException {
        var order = orderRepository.findById(id);
        if(order.isEmpty()) throw new EntityNotFoundException();
        return order.get();
    }

    public OrderEty saveOrder(OrderEty orderEty) {
        return orderRepository.save(orderEty);
    }



}

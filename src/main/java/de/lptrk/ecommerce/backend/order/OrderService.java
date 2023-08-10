package de.lptrk.ecommerce.backend.order;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import de.lptrk.ecommerce.backend.product.ProductEty;
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

    public OrderEty updateOrder(OrderEty o , String id) throws EntityNotFoundException {
        var getOrder = this.getOrderById(id);
        getOrder.setUser(o.getUser());
        getOrder.setOrdeDate(o.getOrdeDate());
        getOrder.setTotalAmount(o.getTotalAmount());
        getOrder.setStatus(o.getStatus());
        getOrder.setShippingAddress(o.getShippingAddress());
        getOrder.setCreatedAt(o.getCreatedAt());
        getOrder.setUpdatedAt(o.getUpdatedAt());
        return getOrder;
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }


}

package co.decem.service;



import java.util.Optional;

import co.decem.model.Order;
import co.decem.model.OrderDTO;

public interface OrderService {

    Optional<Order> getOrderByIdWithOrderLinesAndProducts(Long id);

    Order createOrder(OrderDTO orderDTO);
}

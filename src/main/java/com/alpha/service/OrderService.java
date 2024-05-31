package com.alpha.service;



import java.util.Optional;

import com.alpha.model.Order;
import com.alpha.model.OrderDTO;

public interface OrderService {

    Optional<Order> getOrderByIdWithOrderLinesAndProducts(Long id);

    Order createOrder(OrderDTO orderDTO);
}

package com.alpha.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alpha.dao.OrderLineRepository;
import com.alpha.dao.OrderRepository;
import com.alpha.dao.ProductRepository;
import com.alpha.model.Order;
import com.alpha.model.OrderDTO;
import com.alpha.model.OrderLine;
import com.alpha.model.Product;
import com.alpha.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Order> getOrderByIdWithOrderLinesAndProducts(Long id) {
        return orderRepository.findByIdWithOrderLinesAndProducts(id);
    }

    @Override
    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setSalesDate(orderDTO.getSalesDate());
        order.setTotalAmmount(orderDTO.getTotalAmmount());
        order.setPaymentMethod(orderDTO.getPaymentMethod());

        Order savedOrder = orderRepository.save(order);

        List<OrderLine> orderLines = orderDTO.getOrderLines().stream().map(orderLineDTO -> {
            OrderLine orderLine = new OrderLine();
            orderLine.setOrder(savedOrder);
            orderLine.setQuantity(orderLineDTO.getQuantity());
            orderLine.setPrice(orderLineDTO.getPrice());
            
            Product product = productRepository.findById(orderLineDTO.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            orderLine.setProduct(product);
            
            return orderLine;
        }).collect(Collectors.toList());

        orderLineRepository.saveAll(orderLines);

        savedOrder.setOrderLines(orderLines);

        return savedOrder;
    }
}

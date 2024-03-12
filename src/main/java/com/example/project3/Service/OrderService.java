package com.example.project3.Service;

import com.example.project3.dto.OrderDto;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();

    void AddOrder(OrderDto orderDto);

    void deleteOrder(Long orderId);
}

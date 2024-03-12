package com.example.project3.Service.impl;

import com.example.project3.Repository.CarrierConfigurationRepository;
import com.example.project3.Repository.OrderRepository;
import com.example.project3.Service.OrderService;
import com.example.project3.dto.OrderDto;
import com.example.project3.entity.CarrierConfiguration;
import com.example.project3.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CarrierConfigurationRepository carrierConfigurationRepository;


    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orderList=orderRepository.findAll();

        return orderList.stream()
                .map(order -> modelMapper.map(order,OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void AddOrder(OrderDto orderDto) {

        List<CarrierConfiguration> carrier=carrierConfigurationRepository.findAll();
        Order order=modelMapper.map(orderDto,Order.class);
        shippingCalculator.calculateShipping(order,carrier);
        orderRepository.save(order);

    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }


}

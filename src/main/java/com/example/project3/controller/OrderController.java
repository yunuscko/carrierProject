package com.example.project3.controller;

import com.example.project3.Service.OrderService;
import com.example.project3.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllOrder")
    public ResponseEntity getAllOrder(){
        try {
            return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addOrder")
    public ResponseEntity addOrder(@RequestBody OrderDto orderDto){
        try {
            orderService.AddOrder(orderDto);
            return new ResponseEntity<>("order successfully added",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable Long orderId){
        try {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>("order successfully deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}

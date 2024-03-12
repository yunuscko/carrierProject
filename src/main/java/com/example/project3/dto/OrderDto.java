package com.example.project3.dto;

import com.example.project3.entity.Carrier;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;


@Data
public class OrderDto {

    private int OrderId;

    private int orderDesi;

    private LocalDate orderDate;

    private BigDecimal orderCarrierCost;

    @ManyToOne
    private Carrier carrier;
}

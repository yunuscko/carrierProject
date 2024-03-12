package com.example.project3.dto;

import com.example.project3.entity.Carrier;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Data
public class CarrierConfigurationDto {

    private int CarrierConfigurationId;

    private int carrierId;

    private int carrierMaxDesi;

    private int carrierMinDesi;

    private BigDecimal cost;

    @ManyToOne
    private Carrier carrier;
}

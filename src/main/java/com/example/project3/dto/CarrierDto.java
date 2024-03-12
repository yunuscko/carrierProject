package com.example.project3.dto;

import com.example.project3.entity.CarrierConfiguration;
import com.example.project3.entity.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
public class CarrierDto {

    private int CarrierId;

    private String carrierName;

    private Boolean CarrierIsActive;

    private int carrierPlusDesiCost;

    private int carrierConfigurationId;

    @OneToMany
    private List<Order> orders;

    @OneToMany
    private List<CarrierConfiguration> carrierConfigurations;
}

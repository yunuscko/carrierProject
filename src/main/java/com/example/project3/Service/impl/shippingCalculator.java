package com.example.project3.Service.impl;

import com.example.project3.entity.Carrier;
import com.example.project3.entity.CarrierConfiguration;
import com.example.project3.entity.Order;

import java.math.BigDecimal;
import java.util.List;

public class shippingCalculator {

    public static void calculateShipping(Order order, List<CarrierConfiguration> carriers) {
        BigDecimal minCost = null;
        CarrierConfiguration carrierConfiguration = null;

        for (CarrierConfiguration carrier : carriers) {
            if (order.getOrderDesi() >= carrier.getCarrierMinDesi() && order.getOrderDesi() <= carrier.getCarrierMaxDesi()) {
                BigDecimal currentCost = carrier.getCost();

                if (minCost == null || currentCost.compareTo(minCost) < 0) {
                    minCost = currentCost;
                    carrierConfiguration = carrier;
                }
            }
        }

        if (carrierConfiguration != null) {
            order.setOrderCarrierCost(minCost);
            order.setCarrierId(carrierConfiguration.getCarrierId());
        }

        double minDistance = Double.MAX_VALUE;


        for (CarrierConfiguration carrierConfig : carriers) {   
            double distance;

            if (order.getOrderDesi() < carrierConfig.getCarrierMinDesi()) {
                distance = carrierConfig.getCarrierMinDesi() - order.getOrderDesi();

            } else if (order.getOrderDesi() > carrierConfig.getCarrierMaxDesi()) {
                distance = order.getOrderDesi() - carrierConfig.getCarrierMaxDesi();

            } else {
                distance = 0;

            if (distance < minDistance) {
                minDistance = distance;
                order.setCarrierId(carrierConfig.getCarrierId());

                double extraCost = carrierConfig.getCarrier().getCarrierPlusDesiCost();
                BigDecimal addCost = BigDecimal.valueOf(extraCost).add(carrierConfig.getCost());
                order.setOrderCarrierCost(addCost);

            }
        }
        }

    }}


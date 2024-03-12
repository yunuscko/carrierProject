package com.example.project3.Service;

import com.example.project3.dto.CarrierConfigurationDto;

import java.util.List;

public interface CarrierConfigurationService {

    List<CarrierConfigurationDto> getAllCarrierConfigurations();

    void addCarrierConfiguration(CarrierConfigurationDto carrierConfigurationDto);

    void updateCarrierConfiguration(Long CarrierConfigurationId,CarrierConfigurationDto carrierConfigurationDto);

    void deleteCarrierConfiguration(Long CarrierConfigurationId);
}

package com.example.project3.Service.impl;

import com.example.project3.Repository.CarrierConfigurationRepository;
import com.example.project3.Service.CarrierConfigurationService;
import com.example.project3.dto.CarrierConfigurationDto;
import com.example.project3.entity.Carrier;
import com.example.project3.entity.CarrierConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrierConfigurationServiceImpl implements CarrierConfigurationService {

    @Autowired
    private CarrierConfigurationRepository carrierConfigurationRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CarrierConfigurationDto> getAllCarrierConfigurations() {
        List<CarrierConfiguration> carrierConfigurations=carrierConfigurationRepository.findAll();

        return carrierConfigurations.stream()
                .map(carrierConfiguration -> modelMapper.map(carrierConfiguration,CarrierConfigurationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addCarrierConfiguration(CarrierConfigurationDto carrierConfigurationDto) {
        Optional<CarrierConfiguration> carrierConfiguration=carrierConfigurationRepository.findById((long) carrierConfigurationDto.getCarrierId());
        if(carrierConfiguration.isPresent()){
            System.out.println("carrier Configuration is not found");
        }

        CarrierConfiguration carrierConfiguration1=modelMapper.map(carrierConfigurationDto,CarrierConfiguration.class);
        carrierConfigurationRepository.save(carrierConfiguration1);
    }

    @Override
    public void updateCarrierConfiguration(Long CarrierConfigurationId, CarrierConfigurationDto carrierConfigurationDto) {

        Optional<CarrierConfiguration> optionalCarrierConfiguration=carrierConfigurationRepository.findById(CarrierConfigurationId);
        CarrierConfiguration carrierConfiguration=modelMapper.map(carrierConfigurationDto,CarrierConfiguration.class);
        if(optionalCarrierConfiguration.isPresent()){

            CarrierConfiguration carrierConfiguration1 = getConfiguration(optionalCarrierConfiguration, carrierConfiguration);

            carrierConfigurationRepository.save(carrierConfiguration1);
        }else {
            System.out.println("Error: Carrier Configuration to be updated not found.");
        }
    }

    private static CarrierConfiguration getConfiguration(Optional<CarrierConfiguration> optionalCarrierConfiguration, CarrierConfiguration carrierConfiguration) {
        CarrierConfiguration carrierConfiguration1= optionalCarrierConfiguration.get();

        carrierConfiguration1.setCarrierId(carrierConfiguration.getCarrierId());
        carrierConfiguration1.setCarrier(carrierConfiguration.getCarrier());
        carrierConfiguration1.setCarrierMaxDesi(carrierConfiguration.getCarrierMaxDesi());
        carrierConfiguration1.setCarrierMinDesi(carrierConfiguration.getCarrierMinDesi());
        carrierConfiguration1.setCost(carrierConfiguration.getCost());
        carrierConfiguration1.setCarrierConfigurationId(carrierConfiguration.getCarrierConfigurationId());
        return carrierConfiguration1;
    }

    @Override
    public void deleteCarrierConfiguration(Long CarrierConfigurationId) {
        carrierConfigurationRepository.deleteById(CarrierConfigurationId);

    }
}

package com.example.project3.controller;

import com.example.project3.Service.CarrierService;
import com.example.project3.dto.CarrierDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrier")
public class CarrierController {

    @Autowired
    private CarrierService carrierService;

    @GetMapping("/getAllCarriers")
    public ResponseEntity getAllCarriers(){

        try {
            return new ResponseEntity<>(carrierService.getAllCarriers(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addCarrier")
    public ResponseEntity addCarrier(@RequestBody CarrierDto carrierDto){
        try {
            carrierService.addCarrier(carrierDto);
            return new ResponseEntity<>("carrier successfully added",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCarrier/{carrierId}")
    public  ResponseEntity deleteCarrier(@PathVariable Long carrierId){
        try {
            carrierService.deleteCarrier(carrierId);
            return new ResponseEntity<>("carrier successfully deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateCarrier/{carrierId}")
    public ResponseEntity updateCarrier(@PathVariable Long carrierId,@RequestBody CarrierDto carrierDto){
        try {
            carrierService.updateCarrier(carrierId,carrierDto);
            return new ResponseEntity<>("carrier successfully updated",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



}

package com.galvanize.alpha.speedwaytrials.racecar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class RaceCarController {

    @Autowired
    CarsService carsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCars(@RequestBody CarsDto carsDto){
        this.carsService.addCars(carsDto);
    }

    @GetMapping
    public List<CarsDto> getAllCars(){
        return carsService.fetchAllCars();
    }


}

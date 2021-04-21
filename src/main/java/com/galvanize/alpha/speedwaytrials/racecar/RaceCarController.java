package com.galvanize.alpha.speedwaytrials.racecar;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class RaceCarController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCars(){

    }

    @GetMapping
    public String getAllCars(){
        return "[]";
    }


}

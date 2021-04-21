package com.galvanize.alpha.speedwaytrials.racecar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cars")
public class RaceCarController {

    @GetMapping
    public String getAllCars(){
        return "[]";
    }


}

package com.galvanize.alpha.speedwaytrials.drivers.controller;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drivers")
public class DriversController {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String addADriver(@RequestBody DriverDto driverDto) {
        return "Driver Added Successfully";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DriverDto> getAllDrivers() {
        return List.of();
    }
}

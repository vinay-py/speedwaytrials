package com.galvanize.alpha.speedwaytrials.drivers.controller;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

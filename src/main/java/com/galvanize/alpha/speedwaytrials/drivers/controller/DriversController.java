package com.galvanize.alpha.speedwaytrials.drivers.controller;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("drivers")
public class DriversController {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String addADriver(@RequestBody DriverDto driverDto) {
        return null;
    }
}

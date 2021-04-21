package com.galvanize.alpha.speedwaytrials.drivers.service;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import com.galvanize.alpha.speedwaytrials.drivers.models.DriverEntity;
import com.galvanize.alpha.speedwaytrials.drivers.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public void addNewDriver(DriverDto driver) {
        driverRepository.save(DriverEntity.builder().firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .age(driver.getAge())
                .cars(driver.getCars())
                .wins(driver.getWins())
                .losses(driver.getLosses())
                .build());
    }
}

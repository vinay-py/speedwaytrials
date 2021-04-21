package com.galvanize.alpha.speedwaytrials.drivers.service;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import com.galvanize.alpha.speedwaytrials.drivers.models.DriverEntity;
import com.galvanize.alpha.speedwaytrials.drivers.repository.DriverRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DriverServiceTest {

    @InjectMocks
    DriverService service;

    @Mock
    DriverRepository driverRepository;

    @Test
    void addDriver() {
        DriverDto driver = DriverDto.builder()
                .firstName("SpeedRacer")
                .lastName("LastName")
                .age(19)
                .cars(List.of("car1", "car2"))
                .wins(99)
                .losses(1)
                .build();

        service.addNewDriver(driver);

        verify(driverRepository).save(DriverEntity.builder()
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .age(driver.getAge())
                .cars(driver.getCars())
                .wins(driver.getWins())
                .losses(driver.getLosses())
                .build());
    }

}

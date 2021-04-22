package com.galvanize.alpha.speedwaytrials.racecar;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsDto {
    String model;
    String nickname;
    int year;
//    DriverEntity owner;
    String status;
    int topSpeed;
}

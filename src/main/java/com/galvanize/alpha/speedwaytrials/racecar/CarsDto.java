package com.galvanize.alpha.speedwaytrials.racecar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Driver;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsDto {
    String model;
    String nickname;
    int year;
//    Driver owner;
    String status;
    int topSpeed;
}

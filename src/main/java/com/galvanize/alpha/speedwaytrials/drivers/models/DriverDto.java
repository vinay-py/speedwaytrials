package com.galvanize.alpha.speedwaytrials.drivers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private String firstName;
    private String lastName;
    private int age;
    private String nickname;
    private List<String> cars;
    private int wins;
    private int losses;
}

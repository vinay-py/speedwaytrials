package com.galvanize.alpha.speedwaytrials.drivers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private String firstName;
    private String lastName;
    private String age;
    private String nickname;
    private List<String> cars;
    private String wins;
    private String losses;
}

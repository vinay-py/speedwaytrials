package com.galvanize.alpha.speedwaytrials.races;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaceDto {
    String name;
    String category;
    String date;
    String bestTime;
    DriverDto winner;
    List<DriverDto> participants;
}

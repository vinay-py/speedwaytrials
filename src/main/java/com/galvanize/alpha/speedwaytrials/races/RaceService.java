package com.galvanize.alpha.speedwaytrials.races;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceService {

    @Autowired
    RaceRepository raceRepository;

    public void addRace(RaceDto raceDto) {
        raceRepository.save(new RaceEntity(raceDto.getName(),raceDto.getCategory(),raceDto.getDate(),raceDto.getBestTime()));
    }

    public List<RaceDto> getRaces() {
        return raceRepository.findAll()
                .stream()
                .map(raceEntity ->
                {return new RaceDto(raceEntity.getName(),raceEntity.getCategory(),raceEntity.getDate(),raceEntity.getBestTime(),new DriverDto(),new ArrayList<>());
                }).collect(Collectors.toList());
    }
}

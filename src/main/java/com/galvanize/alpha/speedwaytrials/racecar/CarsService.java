package com.galvanize.alpha.speedwaytrials.racecar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsService {

    @Autowired
    CarsRepository carsRepository;

    public void addCars(CarsDto carsDto) {
        carsRepository.save(new CarsEntity(carsDto.getModel(),
            carsDto.getNickname(),
            carsDto.getYear(),
            carsDto.getStatus(),
            carsDto.getTopSpeed()));
    }

    public List<CarsDto> fetchAllCars() {
        return carsRepository.findAll()
            .stream()
            .map(carsEntity -> {
                return new CarsDto(carsEntity.getModel(),
                                    carsEntity.getNickname(),
                                    carsEntity.getYear(),
                                    carsEntity.getStatus(),
                                    carsEntity.getTopSpeed()
                );
            }).collect(Collectors.toList());
    }
}

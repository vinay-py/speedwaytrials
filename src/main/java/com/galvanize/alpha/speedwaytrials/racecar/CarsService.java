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
        carsRepository.save(new CarsEntity(carsDto.getModel()));
    }

    public List<CarsDto> fetchAllCars() {
        return carsRepository.findAll()
            .stream()
            .map(carsEntity -> {
                return new CarsDto(carsEntity.getModel());
            }).collect(Collectors.toList());
    }
}

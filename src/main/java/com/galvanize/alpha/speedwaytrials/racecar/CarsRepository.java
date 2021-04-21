package com.galvanize.alpha.speedwaytrials.racecar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository <CarsEntity, Long> {
}

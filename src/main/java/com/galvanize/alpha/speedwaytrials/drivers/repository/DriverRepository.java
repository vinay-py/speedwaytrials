package com.galvanize.alpha.speedwaytrials.drivers.repository;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
}

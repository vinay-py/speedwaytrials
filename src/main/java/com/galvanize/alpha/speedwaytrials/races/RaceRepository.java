package com.galvanize.alpha.speedwaytrials.races;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<RaceEntity,Long> {
}

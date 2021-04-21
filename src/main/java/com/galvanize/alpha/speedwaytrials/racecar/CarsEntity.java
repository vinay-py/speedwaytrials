package com.galvanize.alpha.speedwaytrials.racecar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String model;

    public CarsEntity(String model) {
        this.model = model;
    }
}

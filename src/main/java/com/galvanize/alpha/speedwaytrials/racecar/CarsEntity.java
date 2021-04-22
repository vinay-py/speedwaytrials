package com.galvanize.alpha.speedwaytrials.racecar;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String model;
    String nickname;
    int year;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "owner_id", nullable = true)
//    DriverEntity owner;

    String status;
    int topSpeed;

    public CarsEntity(String model, String nickname, int year, String status, int topSpeed) {
        this.model = model;
        this.nickname = nickname;
        this.year = year;
        this.status = status;
        this.topSpeed = topSpeed;
    }
}

package com.galvanize.alpha.speedwaytrials.races;

import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import com.galvanize.alpha.speedwaytrials.drivers.models.DriverEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String category;
    String date;
    String bestTime;

    @OneToOne
    @JoinColumn(name = "winner_id", nullable = true)
    DriverEntity winner;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id", nullable = true)
    List<DriverEntity> participants;

    public RaceEntity(String name, String category, String date, String bestTime) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.bestTime = bestTime;
    }
}

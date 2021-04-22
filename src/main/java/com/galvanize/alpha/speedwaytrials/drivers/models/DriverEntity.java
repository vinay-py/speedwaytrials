package com.galvanize.alpha.speedwaytrials.drivers.models;

import com.galvanize.alpha.speedwaytrials.races.RaceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String nickname;
    @ElementCollection
    private List<String> cars;
    private int wins;
    private int losses;

    @OneToOne(mappedBy = "winner")
    RaceEntity winner;
}

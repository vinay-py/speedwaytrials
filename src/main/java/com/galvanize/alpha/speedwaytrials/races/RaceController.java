package com.galvanize.alpha.speedwaytrials.races;

import com.galvanize.alpha.speedwaytrials.racecar.CarsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("races")
public class RaceController {

    @Autowired
    RaceService raceService;

    @GetMapping
    public List<RaceDto> getRaces() {
        return this.raceService.getRaces();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRace(@RequestBody RaceDto raceDto) {
        this.raceService.addRace(raceDto);
    }
}

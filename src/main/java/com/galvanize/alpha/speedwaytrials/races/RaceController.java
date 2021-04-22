package com.galvanize.alpha.speedwaytrials.races;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("races")
public class RaceController {

    @GetMapping
    public String getRaces() {
        return "[]";
    }
}

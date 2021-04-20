package com.galvanize.alpha.speedwaytrials.drivers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@SpringBootTest
@AutoConfigureMockMvc
public class DriversIT {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objMapper;

    @Test
    public void addADriver () throws Exception
    {
        DriverDto driverDto =  DriverDto.builder()
                .firstName("Rohit")
                .lastName("Ranjan")
                .age(32)
                .nickname("")
                .cars(List.of("Car1","Car2"))
                .wins(2)
                .losses(0).build();

        mockMvc.perform(post("/drivers")
                .contentType(MediaType.APPLICATION_JSON)
        .content(objMapper.writeValueAsString(driverDto)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Driver Added Successfully")
                );
    }
}

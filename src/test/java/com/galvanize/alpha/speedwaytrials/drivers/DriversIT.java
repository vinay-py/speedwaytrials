package com.galvanize.alpha.speedwaytrials.drivers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DriversIT {
    @Autowired
    MockMvc mockMvc;
    ObjectMapper objMapper;

    @Test
    public void addADriver ()
    {
        DriverDto driverDto =  new DriverDto();
        mockMvc.perform(post("/drivers")
                .contentType(MediaType.APPLICATION_JSON)
        .content(objMapper.writeValueAsString(driverDto)))
                .andExpect(status().isCreated());
    }
}

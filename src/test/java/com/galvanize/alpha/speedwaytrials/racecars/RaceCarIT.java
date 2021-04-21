package com.galvanize.alpha.speedwaytrials.racecars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.alpha.speedwaytrials.racecar.CarsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class RaceCarIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllCars_EmptyList() throws Exception {
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(0))
                .andDo(document("GetCars"));
    }

    @Test
    public void addCars() throws Exception {

        CarsDto carsDto = new CarsDto("Ferrari");

        mockMvc.perform(post("/cars").content(objectMapper.writeValueAsString(carsDto)).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andDo(document("AddCars"));

        mockMvc.perform(get("/cars"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("length()").value(1))
            .andExpect(jsonPath("[0].model").value("Ferrari"))
            .andDo(document("GetCars"));
    }
}

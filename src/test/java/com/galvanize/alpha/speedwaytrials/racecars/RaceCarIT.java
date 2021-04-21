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

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

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

        CarsDto carsDto = new CarsDto("Corvette", "The Condor",2019,"AVAILABLE",189);

        mockMvc.perform(post("/cars").content(objectMapper.writeValueAsString(carsDto)).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andDo(document("AddCars"));

        mockMvc.perform(get("/cars"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("length()").value(1))
            .andExpect(jsonPath("[0].model").value("Corvette"))
            .andExpect(jsonPath("[0].nickname").value("The Condor"))
            .andExpect(jsonPath("[0].year").value(2019))
            .andExpect(jsonPath("[0].status").value("AVAILABLE"))
            .andExpect(jsonPath("[0].topSpeed").value(189))
            .andDo(document("GetCars", responseFields(
                fieldWithPath("[0].model").description("Corvette")
                ,fieldWithPath("[0].nickname").description("The Condor")
                ,fieldWithPath("[0].year").description(2019)
                ,fieldWithPath("[0].status").description("AVAILABLE")
                ,fieldWithPath("[0].topSpeed").description(189)
            )));
    }
}

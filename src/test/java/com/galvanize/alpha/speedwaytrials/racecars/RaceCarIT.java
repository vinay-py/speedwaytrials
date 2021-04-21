package com.galvanize.alpha.speedwaytrials.racecars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
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

    @Test
    public void getAllCars_EmptyList() throws Exception {
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(0))
                .andDo(document("GetCars"));
    }

    @Test
    public void addCars() throws Exception {

        mockMvc.perform(post("/cars").content("").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andDo(document("AddCars"));
    }
}

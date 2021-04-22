package com.galvanize.alpha.speedwaytrials.races;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import com.galvanize.alpha.speedwaytrials.racecar.CarsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class RaceIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllRaces_EmptyList() throws Exception {
        mockMvc.perform(get("/races"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(0))
                .andDo(document("GetRaces"));
    }

    @Test
    public void addRace() throws Exception {

        DriverDto driverDto =  DriverDto.builder()
                .firstName("Rohit")
                .lastName("Ranjan")
                .age(32)
                .nickname("")
                .cars(List.of("Car1","Car2"))
                .wins(2)
                .losses(0).build();

        RaceDto raceDto = new RaceDto("Grand prix","finals","12/12/12","03:36:78",driverDto,new ArrayList<>());


        mockMvc.perform(post("/races").content(objectMapper.writeValueAsString(raceDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(document("AddRace"));

        mockMvc.perform(get("/races"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("Grand prix"))
                .andExpect(jsonPath("[0].category").value("finals"))
                .andExpect(jsonPath("[0].date").value("12/12/12"))
                .andExpect(jsonPath("[0].bestTime").value("03:36:78"));
//                .andExpect(jsonPath("[0].winner").value("null"))
//                .andExpect(jsonPath("[0].participants").value("[]"))
//                .andDo(document("GetRaces", responseFields(
//                        fieldWithPath("[0].name").description("Grand prix")
//                        ,fieldWithPath("[0].category").description("finals")
//                        ,fieldWithPath("[0].date").description("12/12/12")
//                        ,fieldWithPath("[0].bestTime").description("03:36:78")
//                        ,fieldWithPath("[0].winner").description(null)
//                        ,fieldWithPath("[0].participants").description("[]")
//                )));
    }
}

package com.galvanize.alpha.speedwaytrials.drivers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.alpha.speedwaytrials.drivers.models.DriverDto;
import com.galvanize.alpha.speedwaytrials.drivers.models.DriverEntity;
import com.galvanize.alpha.speedwaytrials.drivers.repository.DriverRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@SpringBootTest
@AutoConfigureMockMvc
public class DriversIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objMapper;
    @Mock
    DriverRepository repository;

    @Test
    @Transactional
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
                ).andDo(document("add-driver"));
    }

    @Test
    public void getAllDrivers_returnsEmptyList() throws Exception {
            mockMvc.perform(get("/drivers"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("length()").value(0))
                    .andDo(document("get-drivers"));
    }

    @Test
    public void getAllDrivers_returnsListOfAllDrivers() throws Exception {
      repository.save(DriverEntity.builder()
              .firstName("SpeedRacer")
              .lastName("LastName")
              .age(19)
              .cars(List.of("car1", "car2"))
              .wins(99)
              .losses(1)
              .build());

      repository.save(DriverEntity.builder()
              .firstName("SpeedRacer2")
              .lastName("LastName2")
              .age(23)
              .cars(List.of("car3", "car4"))
              .wins(1)
              .losses(5)
              .build());

        mockMvc.perform(get("/drivers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andDo(document("get-drivers"));
    }
}

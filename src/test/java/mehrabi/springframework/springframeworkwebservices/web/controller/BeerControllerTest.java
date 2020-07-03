package mehrabi.springframework.springframeworkwebservices.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mehrabi.springframework.springframeworkwebservices.services.BeerService;
import mehrabi.springframework.springframeworkwebservices.web.model.BeerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    static BeerDTO validBeer;

    @BeforeEach
    public void setUp(){
        validBeer = BeerDTO.builder().id(UUID.randomUUID())
        .beerName("Beer1")
        .beerStyle("PALE_ALE")
        .upc(123456789012L)
        .build();
    }

    @Test
    void getBeerById() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/beer/"+ validBeer.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id",is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName",is("Beer1")));
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDTO beerDto = validBeer;
        beerDto.setId(null);
        BeerDTO savedDto = BeerDTO.builder().id(UUID.randomUUID()).beerName("New Beer").build();

        given(beerService.saveNewBeer(any())).willReturn(savedDto);

        String value = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(value))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDTO beerDto = validBeer;
        beerDto.setId(null);
        String value = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/"+ UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(value)).andExpect(status().isNoContent());

        then(beerService).should().updateBeer(any(),any());

    }
}
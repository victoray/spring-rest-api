package com.odinson.springrestapi.web;

import com.odinson.springrestapi.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DogService dogService;


    @Test
    public void getDogs() throws Exception {
        mockMvc.perform(get("/dogs/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveAllDogs();
    }

    @Test
    public void getDogBreeds() throws Exception {
        mockMvc.perform(get("/breeds"))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreed();

    }

    @Test
    public void getDogBreedsById() throws Exception {
        mockMvc.perform(get("/breedsbyid/1"))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreedById((long) 1);
    }

    @Test
    public void getDogNames() throws Exception {
        mockMvc.perform(get("/names"))
                .andExpect(status().isOk());

        verify(dogService).retrieveDogNames();
    }
}
package com.openclassrooms.starterjwt.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.starterjwt.dto.SessionDto;
import com.openclassrooms.starterjwt.security.jwt.JwtUtils;
import com.openclassrooms.starterjwt.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SessionControllerIntegration {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtUtils jwtUtils;

    private String jwt;

    @BeforeEach
    void setUp() {
        UserDetailsImpl userDetails = UserDetailsImpl.builder().username("yoga@studio.com").build();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null);
        jwt = jwtUtils.generateJwtToken(authentication);
    }

    @Test
    void findById() throws Exception {
        // ce mock permet de simuler une requête GET sur l'URL /api/session/{id} en etant connecté avec un token valide
        this.mockMvc.perform(get("/api/session/1")
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void findByIdNoToken() throws Exception {
        // ce mock permet de simuler une requête GET sur l'URL /api/session/{id} sans token
        this.mockMvc.perform(get("/api/session/1"))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }

    @Test
    void findAll() throws Exception {
        // ce mock permet de simuler une requête GET sur l'URL /api/session en etant connecté avec un token valide
        this.mockMvc.perform(get("/api/session")
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void create() throws Exception {
        // ce mock permet de simuler une requête POST sur la création d'une session avec un token valide
        SessionDto sessionDto = new SessionDto();
        sessionDto.setName("new session");
        sessionDto.setDescription("this is a new session");
        sessionDto.setDate(Date.from(Instant.now()));
        sessionDto.setTeacher_id(1L);


        this.mockMvc.perform(post("/api/session")
                        .header("Authorization", "Bearer " + jwt)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(sessionDto))
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void update() throws Exception {
        // ce mock permet de simuler une requête PUT sur la mise à jour d'une session avec un token valide
        SessionDto sessionDto = new SessionDto();
        sessionDto.setName("new session");
        sessionDto.setDescription("this is a new session");
        sessionDto.setDate(Date.from(Instant.now()));
        sessionDto.setTeacher_id(2L);

        this.mockMvc.perform(post("/api/session")
                        .header("Authorization", "Bearer " + jwt)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(sessionDto))
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void save() throws Exception {
        // ce mock permet de simuler une requête DELETE sur la suppression d'une session avec un token valide
        this.mockMvc.perform(delete("/api/session/1")
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void participate() throws Exception {
        // ce mock permet de simuler une requête POST sur la participation d'une session avec un token valide
        this.mockMvc.perform(post("/api/session/1/participate/1")
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void noLongerParticipate() {
    }
}
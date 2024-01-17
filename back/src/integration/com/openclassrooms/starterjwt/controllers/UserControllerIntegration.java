package com.openclassrooms.starterjwt.controllers;

import com.openclassrooms.starterjwt.security.jwt.JwtUtils;
import com.openclassrooms.starterjwt.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegration {

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
        // ce mock permet de simuler une requête GET sur l'URL /api/user/{id} en etant connecté avec un token valide
      this.mockMvc.perform(get("/api/user/1")
                    .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    // ce mock permet de simuler une requête GET sur l'URL /api/user/{id} sans token
    void findByIdNoToken() throws Exception {
        this.mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }

    @Test
    // ce mock permet de simuler une requête GET sur l'URL /api/user en etant connecté avec un token valide
    void save() throws Exception {
        this.mockMvc.perform(delete("/api/user/1")
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    // ce mock permet de simuler une requête GET sur l'URL /api/user sans token
    void saveNoToken() throws Exception {
        this.mockMvc.perform(delete("/api/user/1"))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }
}
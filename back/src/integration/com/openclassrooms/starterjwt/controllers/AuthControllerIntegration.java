package com.openclassrooms.starterjwt.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Autowired
private TestRestTemplate restTemplate;

@Autowired
private MockMvc mockMvc;

@Autowired
private JwtUtils jwtUtils;

class AuthControllerIntegration {

    @Test
    void authenticateUser() {
     //   ce test permet de simuler une requête POST sur l'URL /api/auth/login avec un body contenant un username et un password qui retourne un token
        this.mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"yoga", \"password\": \"yoga\"}"))
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void registerUser() {
        // ce test permet de simuler une requête POST sur l'URL /api/auth/register avec un body contenant un username, un email et un password qui retourne un token
        this.mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"yoga\", \"email\": \"yoga@test.com\", \"password\": \"yoga\"}"))
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
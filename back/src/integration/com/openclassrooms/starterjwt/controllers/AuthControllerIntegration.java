package com.openclassrooms.starterjwt.controllers;

import com.openclassrooms.starterjwt.security.jwt.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthControllerIntegration {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtUtils jwtUtils;

    @Test
    void authenticateUser() throws Exception {
        //   ce test permet de simuler une requête POST sur l'URL /api/auth/login avec un body contenant un username et un password qui retourne un token
        this.mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"email\": \"yoga@studio.com\", \"password\": \"test!1234\" }")
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void authenticationBadCredentials() throws Exception {
        // ce test permet de simuler une requête POST sur l'URL /api/auth/login avec un body contenant un username et un password qui retourne une erreur
        this.mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"email\": \"noyoga@studio.com\", \"password\": \"test!1234\" }")
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }

    @Test
    void registerUser()  throws Exception {
        // ce test permet de simuler une requête POST sur l'URL /api/auth/register avec un body contenant un username, un email et un password qui retourne un token
        this.mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"email\": \"descartes_37@test.com\", \"password\": \"test!1234\", \"firstName\": \"René\", \"lastName\": \"descartes\" }")
                .accept(MediaType.APPLICATION_JSON)
                .with(csrf()))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
void registerUserBadRequestEmail()  throws Exception {
        // ce test permet de simuler une requête POST sur l'URL /api/auth/register avec un email existant
        this.mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"email\": \"descartes_37@test.com\", \"password\": \"test!1234\", \"firstName\": \"René\", \"lastName\": \"descartes\" }")
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

}
package com.openclassrooms.starterjwt.controllers;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TeacherControllerIntegration {

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
        this.mockMvc.perform(get("/api/teacher/1")
                    .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void findByIdNoToken() throws Exception {
        this.mockMvc.perform(get("/api/teacher/1"))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }

    @Test
    void findAll() throws Exception {
        this.mockMvc.perform(get("/api/teacher")
                    .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk())
                .andDo(print());

    }
    @Test
    void findAllNoToken() throws Exception {
        this.mockMvc.perform(get("/api/teacher"))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }
}
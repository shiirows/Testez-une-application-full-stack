package com.openclassrooms.starterjwt.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class UserDtoTest {

    @Test
    void getId() {
        Long id = 1L;
        UserDto userDto = new UserDto();
        userDto.setId(id);
        Long retrievedId = userDto.getId();
        assertEquals(id, retrievedId);
    }

    @Test
    void getEmail() {
        String email = "toto.com";
        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        String retrievedEmail = userDto.getEmail();
        assertEquals(email, retrievedEmail);
    }

    @Test
    void getLastName() {
        String lastName = "Doe";
        UserDto userDto = new UserDto();
        userDto.setLastName(lastName);
        String retrievedLastName = userDto.getLastName();
        assertEquals(lastName, retrievedLastName);
    }

    @Test
    void getFirstName() {
        String firstName = "John";
        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        String retrievedFirstName = userDto.getFirstName();
        assertEquals(firstName, retrievedFirstName);
    }

    @Test
    void isAdmin() {
        boolean admin = true;
        UserDto userDto = new UserDto();
        userDto.setAdmin(admin);
        boolean retrievedAdmin = userDto.isAdmin();
        assertEquals(admin, retrievedAdmin);
    }

    @Test
    void getPassword() {
        String password = "securePassword";
        UserDto userDto = new UserDto();
        userDto.setPassword(password);
        String retrievedPassword = userDto.getPassword();
        assertEquals(password, retrievedPassword);
    }

    @Test
    void getCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        UserDto userDto = new UserDto();
        userDto.setCreatedAt(createdAt);
        LocalDateTime retrievedCreatedAt = userDto.getCreatedAt();
        assertEquals(createdAt, retrievedCreatedAt);


    }

    @Test
    void getUpdatedAt() {
        LocalDateTime updatedAt = LocalDateTime.now();
        UserDto userDto = new UserDto();
        userDto.setUpdatedAt(updatedAt);
        LocalDateTime retrievedUpdatedAt = userDto.getUpdatedAt();
        assertEquals(updatedAt, retrievedUpdatedAt);

    }

    @Test
    void setId() {
        Long id = 1L;
        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(id);
        assertEquals(id, sessionDto.getId());
    }

    @Test
    void setEmail() {
        String email = "toto.com";
        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        String retrievedEmail = userDto.getEmail();
        assertEquals(email, retrievedEmail);
    }

    @Test
    void setLastName() {
        String lastName = "Doe";
        UserDto userDto = new UserDto();
        userDto.setLastName(lastName);
        String retrievedLastName = userDto.getLastName();
        assertEquals(lastName, retrievedLastName);
    }

    @Test
    void setFirstName() {
        String firstName = "John";
        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        String retrievedFirstName = userDto.getFirstName();
        assertEquals(firstName, retrievedFirstName);
    }

    @Test
    void setAdmin() {
        boolean admin = true;
        UserDto userDto = new UserDto();
        userDto.setAdmin(admin);
        boolean retrievedAdmin = userDto.isAdmin();
        assertEquals(admin, retrievedAdmin);
    }

    @Test
    void setPassword() {
        String password = "securePassword";
        UserDto userDto = new UserDto();
        userDto.setPassword(password);
        String retrievedPassword = userDto.getPassword();
        assertEquals(password, retrievedPassword);
    }

    @Test
    void setCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        SessionDto sessionDto = new SessionDto();
        sessionDto.setCreatedAt(createdAt);
        LocalDateTime retrievedCreatedAt = sessionDto.getCreatedAt();
        assertEquals(createdAt, retrievedCreatedAt);
    }

    @Test
    void setUpdatedAt() {
        LocalDateTime updatedAt = LocalDateTime.now();
        SessionDto sessionDto = new SessionDto();
        sessionDto.setUpdatedAt(updatedAt);
        LocalDateTime retrievedUpdatedAt = sessionDto.getUpdatedAt();
        assertEquals(updatedAt, retrievedUpdatedAt);
    }

    @Test
    void testEquals() {

        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setEmail("toto.com");
        userDto.setLastName("Doe");
        userDto.setFirstName("John");
        userDto.setAdmin(true);
        userDto.setPassword("securePassword");
        userDto.setCreatedAt(createdAt);
        userDto.setUpdatedAt(updatedAt);

        UserDto userDto2 = new UserDto();
        userDto2.setId(1L);
        userDto2.setEmail("toto.com");
        userDto2.setLastName("Doe");
        userDto2.setFirstName("John");
        userDto2.setAdmin(true);
        userDto2.setPassword("securePassword");
        userDto2.setCreatedAt(createdAt);
        userDto2.setUpdatedAt(updatedAt);

        boolean result = userDto.equals(userDto2);
        assertTrue(result);


    }

    @Test
    void canEqual() {

            LocalDateTime createdAt = LocalDateTime.now();
            LocalDateTime updatedAt = LocalDateTime.now();

            UserDto userDto = new UserDto();
            userDto.setId(1L);
            userDto.setEmail("toto.com");
            userDto.setLastName("Doe");
            userDto.setFirstName("John");
            userDto.setAdmin(true);
            userDto.setPassword("securePassword");
            userDto.setCreatedAt(createdAt);
            userDto.setUpdatedAt(updatedAt);

            UserDto userDto2 = new UserDto();
            userDto2.setId(1L);
            userDto2.setEmail("toto.com");
            userDto2.setLastName("Doe");
            userDto2.setFirstName("John");
            userDto2.setAdmin(true);
            userDto2.setPassword("securePassword");
            userDto2.setCreatedAt(createdAt);
            userDto2.setUpdatedAt(updatedAt);

            boolean result = userDto.canEqual(userDto2);
            assertTrue(result);
    }

    @Test
    void testHashCode() {

            LocalDateTime createdAt = LocalDateTime.now();
            LocalDateTime updatedAt = LocalDateTime.now();

            UserDto userDto = new UserDto();
            userDto.setId(1L);
            userDto.setEmail("toto.com");
            userDto.setLastName("Doe");
            userDto.setFirstName("John");
            userDto.setAdmin(true);
            userDto.setPassword("securePassword");
            userDto.setCreatedAt(createdAt);
            userDto.setUpdatedAt(updatedAt);

            assertEquals(userDto.hashCode(), userDto.hashCode());

    }

    @Test
    void testToString() {

                LocalDateTime createdAt = LocalDateTime.now();
                LocalDateTime updatedAt = LocalDateTime.now();

                UserDto userDto = new UserDto();
                userDto.setId(1L);
                userDto.setEmail("toto.com");
                userDto.setLastName("Doe");
                userDto.setFirstName("John");
                userDto.setAdmin(true);
                userDto.setPassword("securePassword");
                userDto.setCreatedAt(createdAt);
                userDto.setUpdatedAt(updatedAt);

                assertEquals(userDto.toString(), userDto.toString());
    }

    @Test
    void userDto() {

        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();


        UserDto userDto = new UserDto(1L, "toto.com", "toto", "tata", true, "securePassword", createdAt, updatedAt);

        assertEquals(1L, userDto.getId());
        assertEquals("toto.com", userDto.getEmail());
        assertEquals("tata", userDto.getFirstName());
        assertEquals("toto", userDto.getLastName());
        assertTrue(userDto.isAdmin());
        assertEquals("securePassword", userDto.getPassword());
        assertEquals(createdAt, userDto.getCreatedAt());
        assertEquals(updatedAt, userDto.getUpdatedAt());



    }
}
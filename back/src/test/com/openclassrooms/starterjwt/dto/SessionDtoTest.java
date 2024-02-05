package com.openclassrooms.starterjwt.dto;

import com.openclassrooms.starterjwt.models.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class SessionDtoTest {

    @Test
    void getId() {
        Long id = 1L;
        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(id);
        Long retrievedId = sessionDto.getId();
        assertEquals(id, retrievedId);
    }

    @Test
    void getName() {

        String name = "Maths";
        SessionDto sessionDto = new SessionDto();
        sessionDto.setName(name);
        String retrievedName = sessionDto.getName();
        assertEquals(name, retrievedName);

    }

    @Test
    void getDate() {
        Date date = new Date();
        SessionDto sessionDto = new SessionDto();
        sessionDto.setDate(date);
        Date retrievedDate = sessionDto.getDate();
        assertEquals(date, retrievedDate);
    }

    @Test
    void getTeacher_id() {
        Long teacher_id = 1L;
        SessionDto sessionDto = new SessionDto();
        sessionDto.setTeacher_id(teacher_id);
        Long retrievedTeacher_id = sessionDto.getTeacher_id();
        assertEquals(teacher_id, retrievedTeacher_id);
    }

    @Test
    void getDescription() {
        String description = "Maths";
        SessionDto sessionDto = new SessionDto();
        sessionDto.setDescription(description);
        String retrievedDescription = sessionDto.getDescription();
        assertEquals(description, retrievedDescription);
    }

    @Test
    void getUsers() {
       List<Long> users = new ArrayList<>();

        SessionDto sessionDto = new SessionDto();
        sessionDto.setUsers(users);
        List<Long> retrievedUsers = sessionDto.getUsers();
        assertEquals(users, retrievedUsers);
    }

    @Test
    void getCreatedAt() {

        LocalDateTime createdAt = LocalDateTime.now();

        SessionDto sessionDto = new SessionDto();
        sessionDto.setCreatedAt(createdAt);
        LocalDateTime retrievedCreatedAt = sessionDto.getCreatedAt();
        assertEquals(createdAt, retrievedCreatedAt);



    }

    @Test
    void getUpdatedAt() {
        LocalDateTime updatedAt = LocalDateTime.now();

        SessionDto sessionDto = new SessionDto();
        sessionDto.setUpdatedAt(updatedAt);
        LocalDateTime retrievedUpdatedAt = sessionDto.getUpdatedAt();
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
    void setName() {
        String name = "Toto";
        SessionDto sessionDto = new SessionDto();
        sessionDto.setName(name);
        assertEquals(name, sessionDto.getName());
    }

    @Test
    void setDate() {
        Date date = new Date();
        SessionDto sessionDto = new SessionDto();
        sessionDto.setDate(date);
        assertEquals(date, sessionDto.getDate());
    }

    @Test
    void setTeacher_id() {
        Long teacher_id = 1L;
        SessionDto sessionDto = new SessionDto();
        sessionDto.setTeacher_id(teacher_id);
        assertEquals(teacher_id, sessionDto.getTeacher_id());
    }

    @Test
    void setDescription() {
        String description = "Maths";
        SessionDto sessionDto = new SessionDto();
        sessionDto.setDescription(description);
        assertEquals(description, sessionDto.getDescription());
    }

    @Test
    void setUsers() {
        List<Long> users = new ArrayList<>();
        SessionDto sessionDto = new SessionDto();
        sessionDto.setUsers(users);
        assertEquals(users, sessionDto.getUsers());
    }

@Test
    void setCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        SessionDto sessionDto = new SessionDto();
        sessionDto.setCreatedAt(createdAt);
        assertEquals(createdAt, sessionDto.getCreatedAt());
    }

    @Test
    void setUpdatedAt() {
        LocalDateTime updatedAt = LocalDateTime.now();
        SessionDto sessionDto = new SessionDto();
        sessionDto.setUpdatedAt(updatedAt);
        assertEquals(updatedAt, sessionDto.getUpdatedAt());
    }

    @Test
    void equals() {

        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        SessionDto sessionDto1 = new SessionDto();
        sessionDto1.setId(1L);
        sessionDto1.setName("Toto");
        sessionDto1.setDate(new Date());
        sessionDto1.setTeacher_id(1L);
        sessionDto1.setDescription("Toto session");
        sessionDto1.setUsers(new ArrayList<>());
        sessionDto1.setCreatedAt(createdAt);
        sessionDto1.setUpdatedAt(updatedAt);

        SessionDto sessionDto2 = new SessionDto();
        sessionDto2.setId(1L);
        sessionDto2.setName("Toto");
        sessionDto2.setDate(new Date());
        sessionDto2.setTeacher_id(1L);
        sessionDto2.setDescription("Toto session");
        sessionDto2.setUsers(new ArrayList<>());
        sessionDto2.setCreatedAt(createdAt);
        sessionDto2.setUpdatedAt(updatedAt);

        boolean result = sessionDto1.equals(sessionDto2);

        assertTrue(result);

    }

    @Test
    void toStringTest() {

        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(1L);
        sessionDto.setName("Toto");
        sessionDto.setDate(new Date());
        sessionDto.setTeacher_id(1L);
        sessionDto.setDescription("Toto session");
        sessionDto.setUsers(new ArrayList<>());
        sessionDto.setCreatedAt(createdAt);
        sessionDto.setUpdatedAt(updatedAt);

        assertEquals(sessionDto.toString(), sessionDto.toString());
    }

    @Test
    void sessionDto() {
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        Date date = new Date();

        SessionDto sessionDto = new SessionDto(1L, "Toto", date, 1L, "Toto session", new ArrayList<>(), createdAt, updatedAt);

        assertEquals(sessionDto.getId(), 1L);
        assertEquals(sessionDto.getName(), "Toto");
        assertEquals(sessionDto.getDate(), date);
        assertEquals(sessionDto.getTeacher_id(), 1L);
        assertEquals(sessionDto.getDescription(), "Toto session");
        assertEquals(sessionDto.getUsers(), new ArrayList<>());
        assertEquals(sessionDto.getCreatedAt(), createdAt);
        assertEquals(sessionDto.getUpdatedAt(), updatedAt);
    }

    @Test
    void hashCodeTest() {
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(1L);
        sessionDto.setName("Toto");
        sessionDto.setDate(new Date());
        sessionDto.setTeacher_id(1L);
        sessionDto.setDescription("Toto session");
        sessionDto.setUsers(new ArrayList<>());
        sessionDto.setCreatedAt(createdAt);
        sessionDto.setUpdatedAt(updatedAt);

        assertEquals(sessionDto.hashCode(), sessionDto.hashCode());
    }

    @Test
    void canEqual() {
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(1L);
        sessionDto.setName("Toto");
        sessionDto.setDate(new Date());
        sessionDto.setTeacher_id(1L);
        sessionDto.setDescription("Toto session");
        sessionDto.setUsers(new ArrayList<>());
        sessionDto.setCreatedAt(createdAt);
        sessionDto.setUpdatedAt(updatedAt);

        SessionDto sessionDto2 = new SessionDto();
        sessionDto2.setId(1L);
        sessionDto2.setName("Toto");
        sessionDto2.setDate(new Date());
        sessionDto2.setTeacher_id(1L);
        sessionDto2.setDescription("Toto session");
        sessionDto2.setUsers(new ArrayList<>());
        sessionDto2.setCreatedAt(createdAt);
        sessionDto2.setUpdatedAt(updatedAt);

        boolean result = sessionDto.canEqual(sessionDto2);
        assertTrue(result);
    }



}
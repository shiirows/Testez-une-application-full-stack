package com.openclassrooms.starterjwt.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class TeacherDtoTest {

    @Test
    void getId() {
        Long id = 1L;
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(id);
        Long retrievedId = teacherDto.getId();
        assertEquals(id, retrievedId);
    }

    @Test
    void getLastName() {
        String lastName = "toto";
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setLastName(lastName);
        String retrievedLastName = teacherDto.getLastName();
        assertEquals(lastName, retrievedLastName);
    }

    @Test
    void getFirstName() {
        String firstName = "tata";
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setFirstName(firstName);
        String retrievedFirstName = teacherDto.getFirstName();
        assertEquals(firstName, retrievedFirstName);
    }

    @Test
    void getCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setCreatedAt(createdAt);
        LocalDateTime retrievedCreatedAt = teacherDto.getCreatedAt();
        assertEquals(createdAt, retrievedCreatedAt);

    }

    @Test
    void getUpdatedAt() {
        LocalDateTime updatedAt = LocalDateTime.now();
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setUpdatedAt(updatedAt);
        LocalDateTime retrievedUpdatedAt = teacherDto.getUpdatedAt();
        assertEquals(updatedAt, retrievedUpdatedAt);
    }

    @Test
    void setId() {
        Long id = 1L;
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(id);
        assertEquals(id, teacherDto.getId());
    }

    @Test
    void setLastName() {
        String lastName = "Toto";
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setLastName(lastName);
        assertEquals(lastName, teacherDto.getLastName());
    }

    @Test
    void setFirstName() {
        String firstName = "Tata";
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setFirstName(firstName);
        assertEquals(firstName, teacherDto.getFirstName());
    }

    @Test
    void setCreatedAt() {
        LocalDateTime createdAt = LocalDateTime.now();
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setCreatedAt(createdAt);
        assertEquals(createdAt, teacherDto.getCreatedAt());
    }

    @Test
    void setUpdatedAt() {
        LocalDateTime updatedAt = LocalDateTime.now();
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setUpdatedAt(updatedAt);
        assertEquals(updatedAt, teacherDto.getUpdatedAt());
    }

    @Test
    void testEquals() {

        LocalDateTime updatedAt = LocalDateTime.now();
        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setFirstName("toto");
        teacherDto.setLastName("tata");
        teacherDto.setCreatedAt(updatedAt);
        teacherDto.setUpdatedAt(updatedAt);
        assertTrue(teacherDto.equals(teacherDto));

        TeacherDto teacherDto2 = new TeacherDto();
        teacherDto2.setFirstName("toto");
        teacherDto2.setLastName("tata");
        teacherDto2.setCreatedAt(updatedAt);
        teacherDto2.setUpdatedAt(updatedAt);
        assertTrue(teacherDto.equals(teacherDto2));

    }


    @Test
    void canEqual() {

            LocalDateTime updatedAt = LocalDateTime.now();
            TeacherDto teacherDto = new TeacherDto();

            teacherDto.setFirstName("toto");
            teacherDto.setLastName("tata");
            teacherDto.setCreatedAt(updatedAt);
            teacherDto.setUpdatedAt(updatedAt);

            TeacherDto teacherDto2 = new TeacherDto();
            teacherDto2.setFirstName("toto");
            teacherDto2.setLastName("tata");
            teacherDto2.setCreatedAt(updatedAt);
            teacherDto2.setUpdatedAt(updatedAt);
            assertTrue(teacherDto.canEqual(teacherDto2));
    }

    @Test
    void testHashCode() {

            LocalDateTime updatedAt = LocalDateTime.now();
            TeacherDto teacherDto = new TeacherDto();

            teacherDto.setFirstName("toto");
            teacherDto.setLastName("tata");
            teacherDto.setCreatedAt(updatedAt);
            teacherDto.setUpdatedAt(updatedAt);
            assertEquals(teacherDto.hashCode(), teacherDto.hashCode());
    }

    @Test
    void testToString() {
        LocalDateTime updatedAt = LocalDateTime.now();
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setFirstName("toto");
        teacherDto.setLastName("tata");
        teacherDto.setCreatedAt(updatedAt);
        teacherDto.setUpdatedAt(updatedAt);
        assertEquals(teacherDto.toString(), teacherDto.toString());
    }
}
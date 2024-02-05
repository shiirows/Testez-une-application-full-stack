package com.openclassrooms.starterjwt.mapper;

import com.openclassrooms.starterjwt.models.Teacher;
import com.openclassrooms.starterjwt.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionMapperTest {

    @Test
    void toEntity() {

        User user1 = new User();
        user1.setId(1L);

        User user2 = new User();
        user2.setId(2L);

        Teacher teacher = new Teacher();
        teacher.setId(1L);


    }

    @Test
    void toDto() {
    }
}
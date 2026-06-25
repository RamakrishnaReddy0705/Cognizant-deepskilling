
package com.example.repository;

import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void shouldFindUsersByName() {

        repository.save(new User(1L,"John"));
        repository.save(new User(2L,"John"));
        repository.save(new User(3L,"David"));

        List<User> users = repository.findByName("John");

        assertEquals(2, users.size());

        assertTrue(
                users.stream()
                        .allMatch(u ->
                                u.getName().equals("John"))
        );
    }

    @Test
    void shouldReturnEmptyListWhenNameNotFound() {

        repository.save(new User(1L,"John"));

        List<User> users =
                repository.findByName("Unknown");

        assertTrue(users.isEmpty());
    }
}

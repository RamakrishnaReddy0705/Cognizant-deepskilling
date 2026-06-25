
package com.example.service;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceExceptionTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    void shouldReturnUserWhenPresent() {

        User user = new User(1L, "John");

        when(repository.findById(1L))
                .thenReturn(Optional.of(user));

        User result = service.getUserById(1L);

        assertEquals("John", result.getName());
    }

    @Test
    void shouldThrowExceptionWhenUserMissing() {

        when(repository.findById(99L))
                .thenReturn(Optional.empty());

        UserNotFoundException ex =
                assertThrows(UserNotFoundException.class,
                        () -> service.getUserById(99L));

        assertEquals(
                "User not found with id: 99",
                ex.getMessage()
        );

        verify(repository).findById(99L);
    }
}

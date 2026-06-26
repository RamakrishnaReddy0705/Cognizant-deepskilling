
package com.example.service;

import com.example.entity.User;
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
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserWhenPresent() {

        User user = new User(1L,"John");

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("John", result.getName());

        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void shouldReturnNullWhenUserNotFound() {

        when(userRepository.findById(99L))
                .thenReturn(Optional.empty());

        User result = userService.getUserById(99L);

        assertNull(result);

        verify(userRepository).findById(99L);
    }
}

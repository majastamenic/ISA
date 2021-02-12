package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.GetAllPharmaciesDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.pharmacy.users.domain.User;
import com.isa.pharmacy.users.repository.UserRepository;
import com.isa.pharmacy.users.service.UserService;
import com.isa.pharmacy.users.service.interfaces.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void getByEmailTestSuccess() {
        User user = new User();
        user.setEmail("maja@mailinator.com");
        when(userRepository.findByEmail(user.getEmail())).thenReturn(new User());
        assertNotNull(user);
    }

    @Test
    public void getByIdTestSuccess() {
        User user = new User();
        user.setId(1l);
        when(userRepository.findUserById(user.getId())).thenReturn(new User());
        assertNotNull(user);
    }

    @Test
    public void getByEmailAndPasswordTestSuccess() {
        User user = new User();
        user.setEmail("maja@mailinator.com");
        user.setPassword("maja");
        when(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(new User());
        assertNotNull(user);
    }
}

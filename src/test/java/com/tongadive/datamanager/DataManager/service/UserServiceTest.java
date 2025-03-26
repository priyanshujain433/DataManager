package com.tongadive.datamanager.DataManager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tongadive.datamanager.DataManager.entites.User;
import com.tongadive.datamanager.DataManager.repo.UserRepository;

public class UserServiceTest {
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveUser() {
		User user = new User();
		user.setName("John Doe");
		user.setEmail("john.doe@example.com");
		user.setAge(30);

		when(userRepository.save(any(User.class))).thenReturn(user);

		User savedUser = userService.saveUser(user);
		assertNotNull(savedUser);
		assertEquals("John Doe", savedUser.getName());
	}

	@Test
	void testGetUserById() {
		User user = new User();
		user.setUserId(1);
		user.setName("Jane Doe");

		when(userRepository.findById(1)).thenReturn(Optional.of(user));

		Optional<User> foundUser = userService.getUserById(1);
		assertTrue(foundUser.isPresent());
		assertEquals("Jane Doe", foundUser.get().getName());
	}
}

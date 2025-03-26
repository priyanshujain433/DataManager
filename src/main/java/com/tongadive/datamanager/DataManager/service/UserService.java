package com.tongadive.datamanager.DataManager.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tongadive.datamanager.DataManager.entites.User;
import com.tongadive.datamanager.DataManager.exceptions.UserNotFoundException;
import com.tongadive.datamanager.DataManager.exceptions.ValidationException;
import com.tongadive.datamanager.DataManager.repo.UserRepository;
import com.tongadive.datamanager.DataManager.util.UserValidator;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Page<User> getAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}

	public User saveUser(User user) {
		Map<String, String> errors = UserValidator.validate(user);
		if (!errors.isEmpty()) {
			throw new ValidationException(errors);
		}
		return userRepository.save(user);
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	public User updateUser(Integer id, User updatedUser) {
		return userRepository.findById(id).map(user -> {
			user.setName(updatedUser.getName());
			user.setEmail(updatedUser.getEmail());
			user.setAge(updatedUser.getAge());
			return userRepository.save(user);
		}).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	public List<User> saveMultipleUsers(List<User> users) {
		for (User user : users) {
			Map<String, String> errors = UserValidator.validate(user);
			if (!errors.isEmpty()) {
				throw new ValidationException(errors);
			}
		}
		return userRepository.saveAll(users);
	}
}

package com.tongadive.datamanager.DataManager.util;

import java.util.HashMap;
import java.util.Map;

import com.tongadive.datamanager.DataManager.entites.User;

public class UserValidator {
	public static Map<String, String> validate(User user) {
        Map<String, String> errors = new HashMap<>();
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            errors.put("name", "Name is mandatory");
        }
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") ) {
            errors.put("email", "Invalid email format");
        }
        if (user.getAge() < 0) {
            errors.put("age", "Age must be positive");
        }
        return errors;
    }
}

package com.tongadive.datamanager.DataManager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tongadive.datamanager.DataManager.entites.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}

package com.elearning.in.Elearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.elaerning.in.Elearning.model.User;
import com.elearning.in.Elearning.repository.UserRepository;


@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public int saveUser(User user) {
		int savedUser = userRepository.saveUser(user);
		// savedUniqueId = savedUser;
		//updateUserApp(user, savedUser);
		return savedUser;
	}
}

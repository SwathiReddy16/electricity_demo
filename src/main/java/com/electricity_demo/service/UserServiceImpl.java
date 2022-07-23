package com.electricity_demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity_demo.entity.User;
import com.electricity_demo.exception.DuplicateUserException;
import com.electricity_demo.exception.InvalidLoginCredentialException;
import com.electricity_demo.exception.InvalidUserIdException;
import com.electricity_demo.exception.InvalidUserNameException;
import com.electricity_demo.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User registerUser(User user) throws DuplicateUserException {

		try {
			User user1 = this.getUserByUserName(user.getUserName());
		} catch (InvalidUserNameException exception) {
			userRepository.save(user);
			return user;
		}
		throw new DuplicateUserException();

	}

	@Override
	public User loginUser(User user) throws InvalidLoginCredentialException {

		List<User> users = userRepository.findAll();
		System.out.println(users);
		for (User user1 : users) {
			if (Objects.equals(user.getUserName(), user1.getUserName())
					&& Objects.equals(user.getPassword(), user1.getPassword()))
				return user1;
		}
		throw new InvalidLoginCredentialException();
	}

	@Override
	public User forgetPassword(String username) {
		
		List<User> users = userRepository.findAll();
		System.out.println(users);
		for (User user1 : users) {
			if (Objects.equals(user1.getUserName(), username)) {
				user1.setPassword("Test@pwd123");
				System.out.print(user1);
				userRepository.save(user1);
				return user1;
			}

		}
		throw new InvalidLoginCredentialException();
	}

	@Override
	public User changePassword(User user, String np) throws InvalidLoginCredentialException {
		

		List<User> users = userRepository.findAll();
		for (User user1 : users) {
			if (Objects.equals(user1.getUserName(), user.getUserName())
					&& Objects.equals(user1.getPassword(), user.getPassword())) {
				user1.setPassword(np);
				userRepository.save(user1);
				return user1;
			}
		}

		throw new InvalidLoginCredentialException();
	}

	@Override
	public User getUserById(Integer uid) {
		// TODO Auto-generated method stub

		try {
			Optional<User> user = userRepository.findById(uid);
			if (user.isPresent())
				return user.get();
		} catch (Exception e) {
			throw new InvalidLoginCredentialException();
		}
		throw new InvalidUserIdException();
	}

	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if (Objects.equals(user.getUserName(), username)) {
				return user;
			}
		}
		throw new InvalidUserNameException();
	}

	@Override
	public List<User> getallUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}

package com.electricity_demo.service;

import java.util.List;

import com.electricity_demo.entity.User;
import com.electricity_demo.exception.DuplicateUserException;
import com.electricity_demo.exception.InvalidLoginCredentialException;

public interface UserService {

	public User registerUser(User user)throws DuplicateUserException;
    public User loginUser(User user) throws InvalidLoginCredentialException;
    public User forgetPassword(String username);
    public User changePassword(User user,String np)throws InvalidLoginCredentialException;
    public User getUserById(Integer uid);
    public User getUserByUserName(String username);
    public List<User> getallUsers();
}

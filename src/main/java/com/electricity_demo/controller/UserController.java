package com.electricity_demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electricity_demo.entity.ChangePassword;
import com.electricity_demo.entity.User;
import com.electricity_demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.ACCEPTED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody @Valid User user) {
		User user1 = userService.loginUser(user);
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "login successful");
		response.put("username", user.getUserName());
		response.put("uid", String.valueOf(user1.getUserId()));
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@PutMapping("/fp")
	public ResponseEntity<?> forgetPassword(@RequestParam String username) {
		System.out.println(username);
		return ResponseEntity.status(HttpStatus.OK).body(userService.forgetPassword(username));
	}

	@PutMapping("/cp")
	public ResponseEntity<?> changePassword(@RequestBody @Valid ChangePassword changePassword) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(userService.changePassword(changePassword.getUser(), changePassword.getNewPassword()));
	}

	@GetMapping("/id/{uid}")
	public ResponseEntity<?> getUserById(@PathVariable @Valid int uid) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(uid));
	}

	@GetMapping("/un/{uname}")
	public ResponseEntity<?> getByUserName(@PathVariable @Valid String uname) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUserName(uname));
	}

	@GetMapping()
	public List<User> getallUsers() {
		return userService.getallUsers();
	}

}

package com.iiht.mentor.userprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.mentor.userprofile.model.UserProfileEntity;
import com.iiht.mentor.userprofile.rep.RepMessage;
import com.iiht.mentor.userprofile.repositorydao.UserRepositorydao;
import com.iiht.mentor.userprofile.req.BlockUser;


@RestController
@RequestMapping("v1/user")
public class UserProfileController {

	@Autowired
	UserRepositorydao userRepositorydao;


	@PostMapping("/block")
	public ResponseEntity<?> blockUser(@RequestBody BlockUser blockUserRequest) {
		UserProfileEntity user = userRepositorydao.findByUsername(blockUserRequest.getUsername())
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User not found."));

		user.setActive(false);
		userRepositorydao.save(user);

		return new ResponseEntity<>(new RepMessage("User blocked!"), HttpStatus.OK);
	}

	@PostMapping("/unblock")
	public ResponseEntity<?> UnblockUser(@RequestBody BlockUser blockUserRequest) {
		System.out.println("=========== here");
		UserProfileEntity user = userRepositorydao.findByUsername(blockUserRequest.getUsername())
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User not found."));

		user.setActive(true);
		userRepositorydao.save(user);

		return new ResponseEntity<>(new RepMessage("User Un-blocked!"), HttpStatus.OK);
	}

	@GetMapping("/testString")
	public String getTestString() {

		return "Hello USerAm Working";

	}
}

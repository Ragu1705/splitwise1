package com.splitwise.splitwiseApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.splitwiseApp.entity.Friends;
import com.splitwise.splitwiseApp.service.FriendsService;

@RestController
@RequestMapping("/split")
public class FriendsController {

	@Autowired
	FriendsService friendsService;
	
	@GetMapping("/*")
	public List<String> getAllData() {
		return friendsService.getAllData();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Friends> addFriends(@RequestBody Friends friend){
		return new ResponseEntity<>(friendsService.saveFriends(friend),HttpStatus.CREATED);
	}
}

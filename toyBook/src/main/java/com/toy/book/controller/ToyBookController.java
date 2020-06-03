package com.toy.book.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.book.service.UserService;


@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
public class ToyBookController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/users")
	public List<HashMap<String,Object>> userList() {
		
		System.out.println("여기까진 들어옴");
		
		List<HashMap<String,Object>> result =userService.userList();
		
		return result;
	}
	
	
}

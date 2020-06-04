package com.toy.book.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toy.book.service.UserService;


@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
public class ToyBookController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/users")
	public List<HashMap<String,Object>> userList() {
		
		
		List<HashMap<String,Object>> result =userService.userList();
		
		return result;
	}
	
	
	@DeleteMapping("/delete/{delList}")
	public String deleteUser(@PathVariable("delList") List<String> list) {
		
		for(String id : list) {
			
			System.out.println(id);
			
		}
		
		return null;
	}
	
	
}

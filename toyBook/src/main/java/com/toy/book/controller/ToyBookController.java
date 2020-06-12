package com.toy.book.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	//Exception이 발생된 경우도 롤백되었으면 하는 경우는 
	//@Transactional (rollbackFor = Exception.class)과 같이 설정한다.
	
	
	@DeleteMapping("/delete")
	public HashMap<String,String> deleteUser(@RequestBody List<String> list) {
		HashMap<String,String> result = userService.deleteUser(list);
		
		return result;
	}
	
	@PostMapping("/temporayuser")
	public HashMap<String, String> tempoUser(@RequestBody HashMap<String,Object> userData){
		HashMap<String,String> result = userService.temporay(userData);
		return result;
	}
	
	@PostMapping("/add")
	public HashMap<String,Object> addUser(@RequestBody HashMap<String,Object> userData){
		HashMap<String,Object> result =userService.addUser(userData);
		return result;
	}
	
	
}

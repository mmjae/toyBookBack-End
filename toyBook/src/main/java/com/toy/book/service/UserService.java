package com.toy.book.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.book.dao.UserDao;

@Service
public class UserService {
		
	@Autowired
	UserDao userDao;
	
	
	 public List<HashMap<String,Object>> userList() {
		 
		 List<HashMap<String,Object>> result = userDao.userList();
		 
		 return result;
	 }
	
	
}

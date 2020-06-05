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


	public HashMap<String, String> deleteUser(List<String> list) {
		
		HashMap<String, String> resultMap= new HashMap<>();
		
		if(list.size()==0) {
			resultMap.put("message", "삭제 할 회원을 선택해 주세요");
			return resultMap;
		}
		
		
		int result=userDao.delete(list);
		
		if(result!=0) {
			resultMap.put("message", "success");
			return resultMap;
		}
		resultMap.put("message", "fail");
		return resultMap;
	}
	
	
}

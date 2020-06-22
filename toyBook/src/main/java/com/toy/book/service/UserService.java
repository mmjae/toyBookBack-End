package com.toy.book.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toy.book.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	

	public List<HashMap<String, Object>> userList() {

		List<HashMap<String, Object>> result = userDao.userList();

		return result;
	}

	public HashMap<String, String> deleteUser(List<HashMap<String, Object>> list) {

		HashMap<String, String> resultMap = new HashMap<>();

		if (list.size() == 0) {
			resultMap.put("message", "삭제 할 회원을 선택해 주세요");
			return resultMap;
		}

		int result = userDao.delete(list);

		if (result != 0) {
			resultMap.put("message", "success");
			return resultMap;
		}
		resultMap.put("message", "fail");
		return resultMap;
	}

	public HashMap<String, String> temporay(HashMap<String, Object> userData) {
		HashMap<String, String> resultMap = new HashMap<>();
		resultMap.put("message", "success");
		if (userData.get("password") == null) {
			userData.put("password", "");
		}

		if (userData.get("age") == null) {
			userData.put("age", "");
		}

		try {
			userDao.temporay(userData);
		} catch (Exception e) {
			resultMap.put("message", "fail");
			System.out.println(e);
		}

		return resultMap;
	}

	public HashMap<String, Object> addUser(HashMap<String, Object> userData) {
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("message", "success");
		// HashMap<String, Object> tot = new HashMap<String, Object>();
		try {
			userDao.addUser(userData);
		} catch (Exception e) {
			resultMap.put("message", "fail");
			System.out.println(e);
			return resultMap;
		}

		if (resultMap.get("message").equals("success")) {
			int userId = (int) userData.get("idnum");
			try {
				resultMap = userDao.selectAddUser(userId);
				resultMap.put("message", "success");
			} catch (Exception e) {
				resultMap.put("message", "fail");
			}
		}
		return resultMap;
	}

	public HashMap<String, Object> updateUser(List<HashMap<String, Object>> list) {
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("message", "success");
		try {
			userDao.updateUser(list);
		} catch (Exception e) {
			resultMap.put("message", "fail");
			System.out.println(e);
		}
		return resultMap;
	}

	public List<HashMap<String, Object>> getTempoUsers() {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		try {
			result = userDao.getTempoUsers();
		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}
	
	@Transactional
	public HashMap<String, Object> delTempoUsers(List<HashMap<String, Object>> list) {
		HashMap<String, Object> result= new HashMap<String, Object>();
		result.put("message", "success");
		//delete 리턴값 알아보고 
		//다중 delete 찾아봐야됨
		if(list.size()==0) {
			result.put("message", "삭제할 데이터를 선택해 주세요.");
			return result;
		}
		
		int resultInt = userDao.delTempoUsers(list);
		if(resultInt==0) {
			result.put("message", "fail");
		}
		
		return result;
	}

}

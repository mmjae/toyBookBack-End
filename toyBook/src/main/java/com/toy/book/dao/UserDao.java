package com.toy.book.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

	List<HashMap<String,Object>> userList();

	
	int delete(List<HashMap<String, Object>> list);


	void temporay(HashMap<String, Object> userData);


	void addUser(HashMap<String, Object> userData);


	HashMap<String, Object> selectAddUser(int userId);


	void updateUser(List<HashMap<String, Object>> list);

	
	List<HashMap<String, Object>> getTempoUsers();


	int delTempoUsers(List<HashMap<String, Object>> list);
	
}

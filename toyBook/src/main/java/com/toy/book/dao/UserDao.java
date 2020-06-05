package com.toy.book.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

	List<HashMap<String,Object>> userList();

	
	int delete(List<String> list);
	
}

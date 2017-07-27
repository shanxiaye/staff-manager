package com.staff.dao;

import java.util.List;

public interface BaseDAO<T> {
	
	List<T> selectAll();
	
	Integer insert(T t);
	
	Integer update(T t);
	
	Integer delete(Integer id);
	

}

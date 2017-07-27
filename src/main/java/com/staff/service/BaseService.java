package com.staff.service;

import java.util.List;


public interface BaseService<T> {
	
	List<T> selectAll();
	
	Integer insert(T t);
	
	Integer update(T t);
	
	Integer delete(Integer id);

}

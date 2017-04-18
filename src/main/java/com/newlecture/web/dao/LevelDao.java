package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Level;

public interface LevelDao {
	
	List<Level> getList();
	Level get(String code);
	int add(Level level);
	int	 update(Level level);
	int delete(String code);
	
}

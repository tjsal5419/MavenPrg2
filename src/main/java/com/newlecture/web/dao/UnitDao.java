package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Chapter;
import com.newlecture.web.entity.Unit;

public interface UnitDao {
	List<Unit> getList(String chapterId);
	Unit get(String id);
	int add(Unit chapter);
	int	update(Unit chapter);	
	int delete(String id);
}

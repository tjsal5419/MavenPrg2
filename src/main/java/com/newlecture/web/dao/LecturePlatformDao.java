package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.LecturePlatform;


public interface LecturePlatformDao {
	List<LecturePlatform> getList();
	List<LecturePlatform> getList(int page, String field, String query);
	List<LecturePlatform> getList(int page);
	
	LecturePlatform get(String code);
	int add(LecturePlatform lecturePlatform);
	int update(LecturePlatform lecturePlatform);
	int delete(String code);
}

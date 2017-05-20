package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Chapter;

public interface ChapterDao {
	 List<Chapter> getList(String lectureId);
	    List<Chapter> getList();
	    List<Chapter> getList(int page, String field, String query);
	    List<Chapter> getList(int page);
	    Chapter get(String id);

	    int add(Chapter chapter);
	    int   update(Chapter chapter);
	    int delete(String id);
}

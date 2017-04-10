package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public interface NoticeDao {
	
	String lastCode();
	
	NoticeView get(String code);
	
	NoticeView getPrev(String code);
	NoticeView getNext(String code);
	
	List<NoticeView> getList();
	List<NoticeView> getList(int page);
	List<NoticeView> getList(int page, String field, String query); 
	
	int getSize();
	int getSize(String field, String query);
	
	int add(Notice notice);
	int add(String title, String content, String writer);
	
	int	 update(Notice notice);
	int	 update(String title, String content, String code);
	
	int delete(String code);
}

package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public interface NoticeDao {
	
	String lastCode();
	
	@Select("SELECT * FROM NOTICE_VIEW	WHERE CODE=#{id}")
	NoticeView get(String id);
	
	NoticeView getPrev(String id);
	NoticeView getNext(String id);
	
	List<NoticeView> getList();
	List<NoticeView> getList(int page);
	List<NoticeView> getList(
			@Param("page") int page, 
			@Param("field") String field, 
			@Param("query") String query); 
	
	int getSize();
	int getSize(String field, String query);
	
	@SelectKey(
			statement="SELECT MAX(CAST(id AS UNSIGNED))+1 id FROM NOTICE",
			before=true,
			keyProperty="id",
			resultType=String.class)
	@Insert("INSERT INTO NOTICE( "+
			"id, "+
			"title, "+
			"writer, "+
			"content "+
		")  "+
		"VALUES( "+
		"	#{id}, "+
		"	#{title}, "+
		"	#{writer}, "+
		"	#{content} "+
		")")
	int add(Notice notice);
	int add(String title, String content, String writer);
	
	int	 update(Notice notice);
	int	 update(String title, String content, String id);
	
	int delete(String id);
}

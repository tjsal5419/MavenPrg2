package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.PlatformVer;

public interface PlatformVerDao {
	
	List<PlatformVer> getList();
	List<PlatformVer> getList(int page);
	List<PlatformVer> getList(int page, String feild, String query);
	PlatformVer get(String code);
	
	int add(PlatformVer platformVer);
	int	 update(PlatformVer platformVer);	
	int delete(String code);
}

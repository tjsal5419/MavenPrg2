package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.LanguageVer;

public interface LanguageVerDao {
	
	List<LanguageVer> getList();
	List<LanguageVer> getList(int page);
	List<LanguageVer> getList(int page, String field, String query);
	LanguageVer get(String code);
	
	int add(LanguageVer languageVer);
	int	 update(LanguageVer languageVer);	
	int delete(String code);
	
}

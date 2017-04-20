package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.LectureLanguageDao;
import com.newlecture.web.entity.LectureLanguage;



public class MyBatisLectureLanguageDao implements LectureLanguageDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<LectureLanguage> getList(String lectureCode) {
		LectureLanguageDao lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);
		
		return lectureLanguageDao.getList(lectureCode);
	}
	
	@Override
	public LectureLanguage get(String lectureCode, String languageCode) {
		
		LectureLanguageDao lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);
		
		return lectureLanguageDao.get(lectureCode, languageCode);
	}

	@Override
	public int add(LectureLanguage lectureLanguage) {
		LectureLanguageDao lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);
		return lectureLanguageDao.add(lectureLanguage);
	}

	@Override
	public int update(LectureLanguage lectureLanguage) {
		LectureLanguageDao lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);
		return lectureLanguageDao.update(lectureLanguage);
	}

	@Override
	public int delete(String lectureCode, String languageCode) {
		LectureLanguageDao lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);
		return lectureLanguageDao.delete(lectureCode, languageCode);
	}



	



}
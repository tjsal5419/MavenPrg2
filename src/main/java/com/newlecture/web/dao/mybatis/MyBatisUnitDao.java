package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.ChapterDao;
import com.newlecture.web.dao.LevelDao;
import com.newlecture.web.dao.UnitDao;
import com.newlecture.web.entity.Chapter;
import com.newlecture.web.entity.Level;
import com.newlecture.web.entity.Unit;

public class MyBatisUnitDao implements UnitDao{

   @Autowired
   private SqlSession sqlSession;
	
	@Override
	public List<Unit> getList(String chapterId) {
		UnitDao unitDao;
		unitDao = sqlSession.getMapper(UnitDao.class);
		return unitDao.getList(chapterId);
	}

	
	@Override
	public int add(Unit chapter) {
		UnitDao unitDao;
		unitDao = sqlSession.getMapper(UnitDao.class);
		return unitDao.add(chapter);
	}
	
	@Override
	public int update(Unit chapter) {
		UnitDao unitDao;
		unitDao = sqlSession.getMapper(UnitDao.class);
		return unitDao.update(chapter);
	}
	
	@Override
	public int delete(String id) {
		UnitDao unitDao;
		unitDao = sqlSession.getMapper(UnitDao.class);
		return unitDao.delete(id);
	}


	@Override
	public Unit get(String id) {
		UnitDao unitDao;
		unitDao = sqlSession.getMapper(UnitDao.class);
		return unitDao.get(id);
	}


	 
   
}
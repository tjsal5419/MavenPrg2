package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.ChapterDao;
import com.newlecture.web.dao.LevelDao;
import com.newlecture.web.entity.Chapter;
import com.newlecture.web.entity.Level;

public class MyBatisChapterDao implements ChapterDao{

   @Autowired
   private SqlSession sqlSession;

	@Override
	public List<Chapter> getList(String chapterId) {
		ChapterDao chapterDao;
		chapterDao = sqlSession.getMapper(ChapterDao.class);
		return chapterDao.getList(chapterId);
	}

	@Override
	public Chapter get(String id) {
		ChapterDao chapterDao;
		chapterDao = sqlSession.getMapper(ChapterDao.class);
		return chapterDao.get(id);
	}


	@Override
	public int add(Chapter chapter) {
		ChapterDao chapterDao;
		chapterDao = sqlSession.getMapper(ChapterDao.class);
		return chapterDao.add(chapter);
	}
	
	@Override
	public int update(Chapter chapter) {
		ChapterDao chapterDao;
		chapterDao = sqlSession.getMapper(ChapterDao.class);
		return chapterDao.update(chapter);
	}
	
	@Override
	public int delete(String id) {
		ChapterDao chapterDao;
		chapterDao = sqlSession.getMapper(ChapterDao.class);
		return chapterDao.delete(id);
	}
	   
 

}
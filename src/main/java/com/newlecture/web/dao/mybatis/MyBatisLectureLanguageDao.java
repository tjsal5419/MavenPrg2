package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.LectureLanguageDao;
import com.newlecture.web.entity.LectureLanguage;


public class MyBatisLectureLanguageDao implements LectureLanguageDao{

   @Autowired
   private SqlSession sqlSession;
   
   
   @Override
   public List<LectureLanguage> getList(int page, String field, String query) {
      LectureLanguageDao lectureLanguageDao;
      lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);
      
      return lectureLanguageDao.getList(page, field, query);
   }
   
   @Override
   public List<LectureLanguage> getList(int page) {
      
      
      return getList(page, "TITLE", "");
   }
   
   @Override
   public List<LectureLanguage> getList() {
      
      
      return getList(1, "TITLE", "");
   }

   @Override
   public int delete(String code) {
      LectureLanguageDao lectureLanguageDao;
      lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);

      return lectureLanguageDao.delete(code);
   }

   @Override
   public LectureLanguage get(String code) {
      LectureLanguageDao lectureLanguageDao;
      lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);

      return lectureLanguageDao.get(code);
   }

   @Override
   public int add(LectureLanguage lectureLanguage) {
      LectureLanguageDao lectureLanguageDao;
      lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);

      return lectureLanguageDao.add(lectureLanguage);
   }

   @Override
   public int update(LectureLanguage lectureLanguage) {
      LectureLanguageDao lectureLanguageDao;
      lectureLanguageDao = sqlSession.getMapper(LectureLanguageDao.class);

      return lectureLanguageDao.update(lectureLanguage);
   }

}
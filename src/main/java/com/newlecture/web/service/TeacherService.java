package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newlecture.web.dao.LectureDao;
import com.newlecture.web.dao.LectureLanguageDao;
import com.newlecture.web.dao.LecturePlatformDao;
import com.newlecture.web.dao.LevelDao;
import com.newlecture.web.entity.Lecture;
import com.newlecture.web.model.teacher.LectureModel;

@Component
public class TeacherService {
	@Autowired
	private LectureDao lectureDao;
	
	@Autowired
	private LectureLanguageDao lectureLanguageDao;
	
	@Autowired
	private LecturePlatformDao lecturePlatformDao;
	
	@Autowired
	private LevelDao levelDao;
		
	public LectureModel getLectureModel(
			int page, String field, String query){
		
		LectureModel model = new LectureModel();
		
		List<Lecture> lectures = lectureDao.getList(page, field, query);
		int size = lectureDao.getSize(field, query);
		
		model.setLectures(lectures);
		model.setTotalPageCount(size);
		
		/*for(Lecture lec : lectures){
			lec.setMember(?);
			lec.setLevel(?);
			List<LectureLanguage> langs = lectureLanguageDao.getList(lec.getCode());
			lec.setLanguages(langs);			
			//lec.setPlatforms(platforms);
		}*/
		
		
		return model;
	}
}

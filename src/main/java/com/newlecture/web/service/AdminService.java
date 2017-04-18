package com.newlecture.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.LectureDao;
import com.newlecture.web.dao.LectureLanguageDao;
import com.newlecture.web.dao.LecturePlatformDao;
import com.newlecture.web.dao.LevelDao;
import com.newlecture.web.model.admin.LectureModel;

public class AdminService {
	
	
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
		
		/*model.setLectures();
		model.setLanguages(?);
		model.setPlatforms(?);
		model.setTotalRecordCount(?)*/
		
		return model;
	}
}

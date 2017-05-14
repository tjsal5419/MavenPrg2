package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.ChapterDao;
import com.newlecture.web.dao.LanguageDao;
import com.newlecture.web.dao.LectureDao;
import com.newlecture.web.dao.LectureLanguageDao;
import com.newlecture.web.dao.LecturePlatformDao;
import com.newlecture.web.dao.PlatformDao;
import com.newlecture.web.dao.UnitDao;
import com.newlecture.web.entity.Chapter;
import com.newlecture.web.entity.Language;
import com.newlecture.web.entity.LectureView;
import com.newlecture.web.entity.Platform;
import com.newlecture.web.entity.Unit;
import com.newlecture.web.model.teacher.LectureModel;

public class TeacherService {
	@Autowired
	private LectureDao lectureDao;

	@Autowired
	private LanguageDao languageDao;
	
	@Autowired
	private PlatformDao PlatformDao;
	
	@Autowired
	private ChapterDao chapterDao;
	
	@Autowired
	private UnitDao unitDao;
	
	public LectureModel getLectureModel(
			int page, String field, String query){
		
		LectureModel model = new LectureModel();
		
		List<LectureView> lectures = lectureDao.getList(page, field, query);
		int size = lectureDao.getSize(field, query);
		
		model.setLectures(lectures);
		model.setTotalPageCount(size);
		
		for(LectureView lec : lectures){
			
			List<Language> langs = languageDao.getListOfLecture(lec.getId());
			lec.setLanguages(langs);
			
			List<Chapter> chaps = chapterDao.getList(lec.getId());
			for(Chapter ch : chaps){
				List<Unit> units = unitDao.getList(ch.getId());
				ch.setUnits(units);
			}
			lec.setChapters(chaps);
			
			List<Platform> platforms = PlatformDao.getListOfLecture(lec.getId());
			lec.setPlatforms(platforms);
			
		}
		
		
		return model;
	}
}

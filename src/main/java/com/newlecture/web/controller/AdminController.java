package com.newlecture.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.model.teacher.LectureModel;
import com.newlecture.web.service.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("index")
	public String index(){
		
		return "admin.index";
	}
	
	@RequestMapping(value="get-member-list", produces="text/plain;charset=UTF-8")
	   @ResponseBody
	   public String getMemberList(@RequestParam(value="id", defaultValue="")String id){
	      List<Member> list=memberDao.getList(id);
	      
	      String json = new Gson().toJson(list);
	      
	      return json;
	 }
}

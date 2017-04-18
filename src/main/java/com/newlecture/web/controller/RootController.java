package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RootController {
	
	@RequestMapping("/index")	
	public String index(){
		
		//return "/WEB-INF/views/index.jsp";
		return "index";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value = "file") MultipartFile file){
		
		System.out.println("a");
					
		return "1";
	}
	
}

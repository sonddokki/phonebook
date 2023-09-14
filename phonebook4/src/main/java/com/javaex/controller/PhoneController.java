package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;


@Controller
public class PhoneController {
	
	@Autowired
	private PersonDao personDao;
	
	
	// 리스트
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list() {
		System.out.println("list");
		
		List<PersonVo> personList = personDao.personSelect();

		
		return null;
	}

}

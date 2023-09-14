package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	@Autowired
	private PersonDao personDao;

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("리스트");

		// db에서 리스트를 가져온다
		List<PersonVo> personList = personDao.personSelect();

		// ds에게 데이터 보낸다
		model.addAttribute("personList", personList);

		return "list";
	}

	// 삭제 실행
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int person_id) {
		System.out.println("삭제 실행");

		int count = personDao.personDelete(person_id);
		
		System.out.println(count);

		// list.jsp에 리다이렉트 한다
		return "redirect:list";
	}

}

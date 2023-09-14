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
		System.out.println("리스트 출력");

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

	@RequestMapping("/writeForm")
	public String writeForm() {
		System.out.println("등록폼 출력");

		return "writeForm";
	}

	@RequestMapping("/write")
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("등록 실행");
		
		int count = personDao.personInsert(personVo);
		System.out.println(count);
		
		return "redirect:list";		
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(@RequestParam("id") int person_id, Model model) {
		System.out.println("수정폼 출력");		
		
		// 1명데이터 가져오기
		PersonVo personVo = personDao.personSelectOne(person_id);
		
		// ds 포워드 시키기
		model.addAttribute("personVo",personVo);
		
		return "updateForm";		
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("수정 실행");
		
		int count = personDao.personUpdate(personVo);
		System.out.println(count);
		
		return "redirect:list";
		
	}
	
	
}

package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		model.addAttribute("personVo", personVo);

		return "updateForm";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("수정 실행");

		int count = personDao.personUpdate(personVo);
		System.out.println(count);

		return "redirect:list";

	}

	// =================================================================
	// Map사용 (등록하기2 예제)
	@RequestMapping("/write2") 
	public String write2(@RequestParam("name") String name
			//,@ModelAttribute PersonVo personVo
			) {
		System.out.println("수정하기2 예제");
		String hp = "010-1313-3131";
		String company = "010-9999-3131";
		
		// sql세션에는 한가지값만 넘길 수 있음
		// 1) Vo로 묶는다 (해당값을 넘길 Vo가 없으면 만들어서 묶기)
//		PersonVo personVo = new PersonVo();
//		personVo.setPerson_id(no);
//		personVo.setHp(hp);
//		personVo.setCompany(company);
//		int count = personDao.write2(personVo);
//		System.out.println(count);
		
		// ==================		
		// 2) Vo를 만들지않기   ?==> 이번 딱 1번만 쓸거 같아서 걍 안만들기 (Map을 사용한다)
		Map<String, Object> personMap = new HashMap<String, Object>();
		// Map<String, String> 
		// 전부 String일때는 Object대신 String넣어도 무방
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		// http://localhost:8000/phonebook4/write2?name=
		System.out.println(personMap);	
		personDao.write2(personMap);

		return "";
	}

}

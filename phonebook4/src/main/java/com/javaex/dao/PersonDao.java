package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PersonDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 생성자,메소드gs

	// 메소드 일반

	// 리스트 검색
	public List<PersonVo> personSelect() {

		// db에서 리스트 가져온다
		List<PersonVo> personList = sqlSession.selectList("phonebook.select");

		return personList;
	}

	// 삭제하기
	public int personDelete(int person_id) {

		int count = sqlSession.delete("phonebook.delete", person_id);

		return count;
	}

	// 등록하기
	public int personInsert(PersonVo personVo) {

		int count = sqlSession.insert("phonebook.insert", personVo);
		
		return count;
	}
	
	// 1명데이터 가져오기
	public PersonVo personSelectOne(int person_id) {

		PersonVo personVo = sqlSession.selectOne("phonebook.selectByNo", person_id);
		
		return personVo;		
	}
	
	
	// 수정하기
	public int personUpdate(PersonVo personVo) {
		System.out.println(personVo);
		
		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count);
		
		return count;
	}

}

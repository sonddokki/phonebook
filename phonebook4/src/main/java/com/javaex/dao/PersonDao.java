package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PersonDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	// 생성자,메소드gs
	
	// 메소드 일반
	
	// 리스트 검색
	public List<PersonVo> personSelect() {
		
		// db에서 리스트 가져온다
		List<PersonVo> personList = sqlSession.selectList("phonebook.Select");

		System.out.println(personList);
		
		return null;		
	}

}

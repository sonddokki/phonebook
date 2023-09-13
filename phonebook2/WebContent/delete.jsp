<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.dao.PersonDao" %>
<%@ page import="com.javaex.vo.PersonVo" %>


<%
	// 파라미터 꺼내기 (db에 전달해서 삭제할 id값)
	int personId = Integer.parseInt(request.getParameter("id"));
	System.out.println(personId);
	
	// personDao의 personDelete(id)를 통해서 id 지우기
	PersonDao personDao = new PersonDao();	
	
	int count = personDao.personDelete(personId);
	System.out.println(count);

	// 리스트 보여주기 --> 리스트로 리다이렉트
	response.sendRedirect("./list.jsp");
%>



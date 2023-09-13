<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.javaex.dao.PersonDao"%>
<%@ page import="com.javaex.vo.PersonVo"%>
<%@ page import="java.util.List" %>

<%
	// 파라미터 꺼내기 (db에 전달해서 확인할 id값)
	int code = Integer.parseInt(request.getParameter("id"));
	System.out.println(code);
	
	// personDao의 personUpdate(id)를 통해서 id 불러오기
	PersonDao personDao = new PersonDao();
	
	List<PersonVo> personList = personDao.personSelect("");
	
	%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><%=personList.get(code).getName()%> 전화번호 수정화면</h1>

	<p> 수정화면입니다. 아래 항목을 수정하고 "수정" 버튼을 클릭하세요. <p>	

	<form action="./update.jsp" method="get">
		<input type="hidden" name="personId" value="<%=personList.get(code).getPersonId()%>"><br>
		이름(name): <input type="text" name="name" value="<%=personList.get(code).getName()%>"><br>
		핸드폰(hp): <input type="text" name="hp" value="<%=personList.get(code).getHp()%>"><br>
		회사(company): <input type="text" name="company" value="<%=personList.get(code).getCompany()%>"><br>
		
		<button type="submit">수정</button>
	</form>





</body>
</html>
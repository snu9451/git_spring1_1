<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%
	List<Map<String, Object>> empList =
		(List<Map<String, Object>>)request.getAttribute("empList");
	int size = 0;
	if(empList!=null){
		size = empList.size();		
	}
	out.print("전체 레코드 수는 "+size+"<br>");
	out.print("WEB-INF를 경유했습니다~~<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getEmpList.jsp - [WEB-INF]</title>
<style type="text/css">
	body{
	 font-size: 30px;
	}
	b {
	 color: red;
	}
</style>
</head>
<body>
 페이지 요청 성공<br>
저는 getEmpList<b>.jsp</b>예요.<br>
getEmpList<b>.sp1</b>로 쳤는데 화면은 .jsp로 나옵니다~~~<br>
<i>요청된 데이터 결과: ${empList}</i>
</body>
</html>
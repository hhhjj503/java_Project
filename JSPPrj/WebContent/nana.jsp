<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int cnt = 100;
String cnt_ = request.getParameter("cnt");

if(cnt_ != null && !cnt_.equals(""))
	cnt = Integer.parseInt(request.getParameter("cnt"));

for(int i =0; i < cnt;i++)
out.println((i+1)+" : Hello 안녕 ~~~<br/>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>
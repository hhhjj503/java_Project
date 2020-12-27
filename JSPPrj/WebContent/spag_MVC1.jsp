<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 제일 상당은 Control = 코드블럭 ((JAVA) 부분) ---------------- -->
<%
int num = 0;
String num_ = request.getParameter("n");
if(num_ != null && !num_.equals("")) num = Integer.parseInt(num_);

String result;
if(num%2 ==0) result = "짝수";
else result = "홀수";
%>
<!-- View = 출력블럭 (부터는 out.write + model 부분만) ------------ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= result %>입니다.
</body>
</html>
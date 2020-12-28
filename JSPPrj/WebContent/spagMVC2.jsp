<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- View = 출력블럭 (부터는 out.write + model 부분만) ------------ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= request.getAttribute("result") %>입니다.<br/>
	${result} 입니다 <br/>
	<!-- request.getParameter("result") = ${rersult} -->
	${names[1]} <br/><br/>
	${result }<br/>
	${requestScope.notice.title} <br/>
	${pageScope.result} <br/><br/>
	
	${empty param.n}<br/> <!-- ${empty param.n} = ${param.n == null || param.n == ''} -->
	${header.cookie} <br/>
	${header.accept} <br/>
	${pageContext.request.method} <br/><br/>
	
	<!-- gt > , gt >=, lt <, le <= -->
	${param.n ge 3} <br/>
	${!empty param.n? '값이 있어요!' : '값이 없어요!' } <!-- ${param.n != null && param.n != ''} --> <br/>
	${param.n/2} <br/>
	
</body>
</html>
<%
int x= 3;
int y =4;
//int page =3;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input {
	width: 50px;
	height: 50px;
	}
	
	.output {
	height: 50px;
	background-color: #E9E9E9;
	font: 24px bold white;
	text-align: right;
	padding: 0px 10px;
	}
</style>
</head>
<body>
<div>
	<form action="calc3" method="post">
	<table>
		<tr>
			<td colspan="4" class="output">${3+4}</td>
		</tr>
		<tr>
			<td><input type="submit" name="operator" value="CE"></td>
			<td><input type="submit" name="operator" value="C"></td>
			<td><input type="submit" name="operator" value="BS"></td>
			<td><input type="submit" name="operator" value="/"></td>
		</tr>
		<tr>
			<td><input type="submit" name="value" value="7"></td>
			<td><input type="submit" name="value" value="8"></td>
			<td><input type="submit" name="value" value="9"></td>
			<td><input type="submit" name="operator" value="×"></td>
		</tr>
		<tr>
			<td><input type="submit" name="value" value="4"></td>
			<td><input type="submit" name="value" value="5"></td>
			<td><input type="submit" name="value" value="6"></td>
			<td><input type="submit" name="operator" value="-"></td>
		</tr>
		<tr>
			<td><input type="submit" name="value" value="1"></td>
			<td><input type="submit" name="value" value="2"></td>
			<td><input type="submit" name="value" value="3"></td>
			<td><input type="submit" name="operator" value="+"></td>
		</tr>
		<tr>
			<td><input type="submit" name="operator" value="±"></td>
			<td><input type="submit" name="value" value="0"></td>
			<td><input type="submit" name="dot" value="."></td>
			<td><input type="submit" name="operator" value="="></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>
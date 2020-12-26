package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet{
	
	/* 
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * //if로 doGet, doPost 실행하기 if(req.getMethod().equals("GET"))
	 * System.out.println("GET 요청이 왔습니다"); else if(req.getMethod().equals("POST"))
	 * System.out.println("POST 요청이 왔습니다");
	 * 
	 * super.service(req, resp);
	 * 
	 * }
	 */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 메서드도 존재합니다!");
		String operator = request.getParameter("operator");
		String value = request.getParameter("value");
		String dot = request.getParameter("dot");
		
		Cookie[] cookies = request.getCookies();
		
		String exp ="";
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("savedExp"))
					exp = c.getValue();
			}
		}
		
		if(operator != null && operator.equals("=") ) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(operator != null && operator.equals("C") ) {
			exp = "";
		} else {
			exp += (value == null)? "" : value;
			exp += (operator == null)? "" : operator;
			exp += (dot == null)? "" : dot;
		}
		
		Cookie expCookie = new Cookie("savedExp", exp);
		expCookie.setPath("/calculator");
		if(operator != null && operator.equals("C"))
			expCookie.setMaxAge(0);
		response.addCookie(expCookie);
		response.sendRedirect("calculator"); //url을 사용자 대신 프로그램에서 요청하는것
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 메서드도 존재합니다!");
		Cookie[] cookies = request.getCookies();
		String exp ="0";
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("savedExp"))
					exp = c.getValue();
			}
			//if(exp.equals("")) exp = "0";
		}
		//getName , getValue
		
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>"); //println 은 console..출력..
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input {");
		out.write("width: 50px;");
		out.write("height: 50px;");
		out.write("}");
		out.write("	.output {");
		out.write("	height: 50px;");
		out.write("	background-color: #E9E9E9;");
		out.write("	font: 24px bold white;");
		out.write("	text-align: right;");
		out.write("	padding: 0px 10px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div>");
		out.write("	<form method=\"post\">");
		out.write("	<table>");
		out.write("	<tr>");
		out.printf("	<td colspan=\"4\" class=\"output\">%s</td>\n", exp);
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"/\"></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"*\"></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"±\"></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
		out.write("<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("</form>");
		out.write("</div>");
		out.write("</body>");
		out.write("</html>");
	}
}

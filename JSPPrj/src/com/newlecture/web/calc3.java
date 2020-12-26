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

@WebServlet("/calc3")
public class calc3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		response.sendRedirect("calcPage"); //url을 사용자 대신 프로그램에서 요청하는것
	}
}


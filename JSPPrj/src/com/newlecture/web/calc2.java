package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class calc2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		//ServletContext application = request.getServletContext();
		
		int v = 0;
		String operator = request.getParameter("operator");
		String v_ = request.getParameter("v");
		
		if(!v_.equals("") && v_!= null) v = Integer.parseInt(v_);
		
		//계산
		if(operator.equals("=")) {
			//int x = (int) application.getAttribute("value");
			//int x = (int) session.getAttribute("value");
			int x = 0;
			int result;
			String op = null;
			//String op = (String)application.getAttribute("op");
			//String op = (String)session.getAttribute("op");
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies)
				if(cookie.getName().equals("value")) {
				x = Integer.parseInt(cookie.getValue());
				break;
				}
			
			for(Cookie cookie : cookies) 
				if(cookie.getName().equals("operator")) {
				op = cookie.getValue();
				break;
				}
				
			PrintWriter out = response.getWriter();
			
			if(op.equals("+")) {
			result = x + v;
			out.printf("result is : %d", result);
			} else { //default
				result = x -v;
				out.printf("result is : %d", result);
			}
		}
		
		//값을 저장
		else {
		
			//application.setAttribute("value", v);
			//application.setAttribute("op", operator);
			
			//session.setAttribute("value", v);
			//session.setAttribute("op", operator);		
			
			Cookie vCookie = new Cookie("value", String.valueOf(v));
			Cookie oCookie = new Cookie("operator", operator);
			vCookie.setPath("/calc2");
			vCookie.setMaxAge(60*60*24);
			oCookie.setPath("/calc2");
			response.addCookie(vCookie);
			response.addCookie(oCookie);
			
			response.sendRedirect("calc2.html");
		}
	}
}

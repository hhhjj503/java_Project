package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class calc2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext application = request.getServletContext();
		int v = 0;
		
		String operator = request.getParameter("operator");
		String v_ = request.getParameter("v");
		
		if(!v_.equals("") && v_!= null) v = Integer.parseInt(v_);
		
		
		//계산
		if(operator.equals("=")) {
			int x = (int) application.getAttribute("value");
			int y = v;
			int result;
			String op = (String)application.getAttribute("op");
			PrintWriter out = response.getWriter();
			if(op.equals("+")) {
			result = x + y;
			out.printf("result is : %d", result);
			} else {
				result = x -y;
				out.printf("result is : %d", result);
			}
		}
		//값을 저장
		else {
			application.setAttribute("value", v);
			application.setAttribute("op", operator);		
		}
		
	}
}

package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class calc extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int x= 0;
		int y =0;
		int result;
		
		String operator = request.getParameter("operator");
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		if(!x_.equals("") && x_!= null) x = Integer.parseInt(x_);
		if(!y_.equals("") && y_!= null) y = Integer.parseInt(y_);
		
		if(operator.equals("덧셈")) result= x+y;
		else result= x-y;
		
		PrintWriter out = response.getWriter();
	
		out.printf("result is : %d", result);
	}
}

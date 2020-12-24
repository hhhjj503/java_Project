package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int x= 0;
		int y =0;
		int result;
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		if(!x_.equals("")) x = Integer.parseInt(request.getParameter("x_"));
		if(!y_.equals("")) y = Integer.parseInt(request.getParameter("y_"));
		
		result= x+y;
		
		PrintWriter out = response.getWriter();
	
	
		out.printf("덧셈 결과 : %d", result);
	}

}

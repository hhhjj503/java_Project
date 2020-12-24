package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int x= 0;
		int result = 0;
		
		String[] num_ = request.getParameterValues("num");
		//배열은 변수를 여러개 선언하는것
		
		for(int i = 0 ; i < num_.length; i++) {
		int num = 0;
		if(!num_.equals("") && num_ != null) num = Integer.parseInt((num_[i]));
		result += num;
		}
		
		PrintWriter out = response.getWriter();
		out.printf("덧셈 결과 : %d", result);
	}

}

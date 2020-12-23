package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
	
	@Override //(입력도구,출력도구)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//응답을 받는 웹 브라우저가 어떤 브라우저인지 종류를 알 수 없으니 반드시 설정해야만 한다
		
		response.setCharacterEncoding("UTF-8"); //서블렛을 작성한 코딩방식 (받는코딩은 설정 X)
		response.setContentType("text/html; charset=UTF-8"); //브라우저에게 알려줄 코딩방식
		
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents"); //contents key 안의 value 를 꺼내옴
		PrintWriter out = response.getWriter();
		
		if(title != null && !title.equals(""))
			out.println(title);
		if(contents != null && !contents.equals(""))
			out.println(contents);
			
		
		
		
		
	}
}


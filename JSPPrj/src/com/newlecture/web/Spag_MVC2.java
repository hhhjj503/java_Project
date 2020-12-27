package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag_MVC2")
public class Spag_MVC2 extends HttpServlet{

	@Override //super 의 service 안의 doGet 오버라이딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals("")) num = Integer.parseInt(num_);

		String result;
		if(num%2 ==0) result = "짝수";
		else result = "홀수";
		
		String[] names = {"newlec", "HHJ"}; 
		Map<String,Object> notice = new HashMap<String, Object>(); 
		notice.put("id", 1);
		notice.put("title", "EL은 좋아요!!");
		
		//redirect 새로운요청
		//forward 공유할 데이터를 추가가능 (이어가야 할떄는 foward 관계사용)
		
		request.setAttribute("result", result);
		request.setAttribute("names", names);
		request.setAttribute("notice", notice);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("spagMVC2.jsp");
		
		dispatcher.forward(request, response); //forward : 전송하다
		//spag_MVC2 서블렛의 request 와 response 를 spag_MVC2.jsp 에 보내라!!
	}
}

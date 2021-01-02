package com.newlec.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.app.entity.Notice;
import com.newlec.app.entity.NoticeView;
import com.newlec.app.service.NoticeService;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//null 값일 경경우를 대비해 일단 임시변수에 꺼낸다
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		int page = 1;
		//꺼낸값이 null 값일 경우를 대비한 원본값
		String field ="title";
		String query ="";
		
		if(field_ != null && !field_.equals("")) field = field_;
		if(query_ != null && !query_.equals("")) query = query_;
		if(page_ != null && !page_.equals("")) page = Integer.parseInt(page_);
		
		NoticeService service = new NoticeService();
		int count = service.getNoticeCount(field, query);
		List<NoticeView> list = service.getNoticeList(field,query,page);
		 
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("/WEB-INF/view/notice/newfile.jsp").forward(request, response);
		
	}
}
